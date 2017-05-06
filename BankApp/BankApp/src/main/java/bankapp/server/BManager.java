package bankapp.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BManager extends UnicastRemoteObject implements IBManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BankDAO bd = new BankDAO();

	public BManager() throws RemoteException {
		super();
		bd.storeUser(new User("user", "pass", "user@mail.com"));
	}

	public boolean login(String username, String pass) throws RemoteException {
		try{
			User login = bd.getUser(username);
			if(login.getPass().equals(pass)){
				/* TODO use logger */
				System.out.println("-- User : " + username + " // Pass : " + pass + " --");
				System.out.println("login successful!");
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
