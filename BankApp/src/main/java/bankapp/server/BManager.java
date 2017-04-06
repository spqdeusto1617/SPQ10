package bankapp.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;


public class BManager extends UnicastRemoteObject implements IBManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int paymentCode = 0;
	
	String serverAddress;
	int port0;
	String servName;
	HashMap<String, String> userMap = new HashMap<String, String>();

	public BManager(String serverAddress, String port0, String servName) throws RemoteException {
		super();
		this.serverAddress = serverAddress;
		this.port0 = Integer.parseInt(port0);
		this.servName = servName;
		this.userMap.put("pass", "user");
	}

	public boolean login(String user, String pass) throws RemoteException {
		if(userMap.containsValue(user) && user.equals(userMap.get(pass))){
			System.out.println("login successful!");
			System.out.println("-- User : " + user + " // Pass : " + pass + " --");
			return true;
		}
		else return false;
	}

}
