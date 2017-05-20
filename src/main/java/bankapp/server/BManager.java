package bankapp.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the bank manger Class extends UnicastRemoteObject and implements IBManager
 */
public class BManager extends UnicastRemoteObject implements IBManager {

	/**
	 * @brief Static variable type long 
	 */
	private static final long serialVersionUID = 1L;
/**
 * @brief variable type bankDAO 
 * @briefvariable type string to store the server adress 
 * @brief variable tyoe int to store the port 
 * @brief variable type string to store server name
 */
	bankDAO bd = new bankDAO();
	String serverAddress;
	int port0;
	String servName;
/**
 * @brief BManager Constructor and also store an new user  
 * @param serverAddress
 * @param port0
 * @param servName
 * @throws RemoteException
 */
	public BManager(String serverAddress, String port0, String servName) throws RemoteException {
		super();
		this.serverAddress = serverAddress;
		this.port0 = Integer.parseInt(port0);
		this.servName = servName;
		bd.storeUser(new User("user", "pass", "user@mail.com"));
	}
/**
 * @brief Function Login as a bank manager allow or deny access 
 * @param username
 * @param pass
 * @return false
 * @throws RemoteException
 */
	public boolean login(String username, String pass) throws RemoteException {
		try{
			User login = bd.getUser(username);
			if(login.getPass().equals(pass)){
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
