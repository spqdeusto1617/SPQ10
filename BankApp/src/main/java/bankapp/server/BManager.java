package bankapp.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BManager extends UnicastRemoteObject implements IBManager {

	/**
	 * 
	 */

	private static final Logger LOGGER = Logger.getLogger(BManager.class.getName() );

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
				LOGGER.log(Level.FINE, "-- User : " + username + " // Pass : " + pass + " --");
				LOGGER.log(Level.FINE, "login successful!");
			return true;
			}
			else{
				LOGGER.log(Level.SEVERE, "Error: found user but password does not coincide");
				return false;
			}
		}catch(Exception ex){
			LOGGER.log(Level.SEVERE, "Error retrieving user from DB. Check if the user exists");
			return false;
		}
	}

}
