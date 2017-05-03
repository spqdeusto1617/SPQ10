package bankapp.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BManager extends UnicastRemoteObject implements IBManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	bankDAO bd = new bankDAO();
	String serverAddress;
	int port0;
	String servName;

	public BManager(String serverAddress, String port0, String servName) throws RemoteException {
		super();
		this.serverAddress = serverAddress;
		this.port0 = Integer.parseInt(port0);
		this.servName = servName;
		bd.storeUser(new User("user", "pass", "user@mail.com"));
	}

	public boolean login(String username, String pass) throws RemoteException {
		
		try{
			User login = bd.getUser(username);
			if(login.getPass().equals(pass)){
				System.out.println("-- User : " + username + " // Pass : " + pass + " --");
				System.out.println("User login successful!");
			return true;
			}
			else{
				System.out.println("Error: found user but password does not coincide");
				return false;
			}
		}catch(Exception ex){
			System.out.println("Error retrieving user from DB. Check if the user exists");
			return false;
		}
		
	}


	@Override
	public boolean loginAdmin(String user, String pass) throws RemoteException {
		try{
			User loginAdmin = bd.getUser(user);
			if(loginAdmin.getPass().equals(pass)){
				System.out.println("-- User : " + user + " // Pass : " + pass + " --");
				System.out.println("Admin login successful!");
			return true;
			}
			else{
				System.out.println("Error: found user but password does not coincide");
				return false;
			}
		}catch(Exception ex){
			System.out.println("Error retrieving user from DB. Check if the user exists");
			return false;
		}
		
	}

}
