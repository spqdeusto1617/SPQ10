package bankapp.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
	private static final Logger LOGGER = Logger.getLogger(BManager.class.getName() );
/**
 * @brief variable type bankDAO 
 * @briefvariable type string to store the server adress 
 * @brief variable tyoe int to store the port 
 * @brief variable type string to store server name
 */
	BankDAO bd = new BankDAO();
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
		bd.storeAccount(new Admin("adminuser", "adminpass"));
		bd.storeAccount(new User("user", "pass", "user@email.com"));
		bd.storeAccount(new User("user1", "pass1", "user1@email.com"));
	}
/**
 * @brief Function Login allows a user or admin to login into the service
 * @param username
 * @param pass
 * @return char
 * @throws RemoteException
 */
	public char login(String username, String pass) throws RemoteException {
		try{
			Account login = bd.getAccount(username);
			if(login.getPass().equals(pass)){
				LOGGER.log(Level.FINE, "-- User : " + username + " // Pass : " + pass + " --");
				LOGGER.log(Level.FINE, "login successful!");
				if(login instanceof Admin)
					return 'a';
				else if (login instanceof User)
					return 'u';
				else return 'e';
			}
			else{
				LOGGER.log(Level.SEVERE, "Error: found user but password does not coincide");
				return 'e';
			}
		}catch(Exception ex){
			LOGGER.log(Level.SEVERE, "Error retrieving user from DB. Check if the user exists");
			return 'e';
		}
	}
	/**
	 * @brief Transaction method for transactions between users
	 * @param user1
	 * @param user2
	 * @param money
	 * @param accum1
	 * @param accNum2
	 * @throws RemoteException
	 */
	public void transaction(String user1, String user2, long money, String accNum1, String accNum2) throws RemoteException {
		LOGGER.log(Level.FINE, "performing transaction: " + user1 + "---->" + user2 );
		User user1Obj = (User) bd.getAccount(user1);
		if(!user1.equals(user2)){
		User user2Obj = (User) bd.getAccount(user2);
		user2Obj.addFundstoAccount(accNum2, money);
		bd.storeAccount(user2Obj);
		}
		else{
			user1Obj.addFundstoAccount(accNum2, money);
		}
		user1Obj.deduceAccountFunds(accNum1, money);
		bd.storeAccount(user1Obj);
		bd.storeReport(new Report(user1, user2, money, accNum1, accNum2));
	}
	/**
	 * @brief  Method for Bank Account creation. Returns bank account number
	 * @param user
	 * @return int
	 * @throws RemoteException
	 */
	public int createBankAccount(String user) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
		int banknum = userObj.createAccount();
		bd.storeAccount(userObj);
		bd.storeReport(new Report(user, Integer.toString(banknum)));
		LOGGER.log(Level.FINE, "Created bank account for user " + user + " with number: " + banknum);
		return banknum;
	}
	/**
	 * @brief Method for adding funds to each account
	 * @param user
	 * @param accNum
	 * @param money
	 * @throws RemoteException
	 */
	public void addFunds(String user, String accNum, long money) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
		userObj.addFundstoAccount(accNum, money);
		bd.storeAccount(userObj);
		bd.storeReport(new Report(user, accNum, money));
		LOGGER.log(Level.FINE, "Added " + money + " for user: " + user);
	}
	/**
	 * @brief Method for deleting bank accounts
	 * @param user
	 * @param accNum1
	 * @param accNum2
	 * @throws RemoteException
	 */
	public void deleteBankAccount(String user, String accNum1) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
//		transaction(user, user, userObj.getAccount(accNum1).getmoney(), accNum1, accNum2);
		userObj.deleteAccount(accNum1);
		bd.storeAccount(userObj);
		LOGGER.log(Level.FINE, "Bank account number " + accNum1 + " deleted for user: " + user);
	}
	/**
	 * @brief Method for deleting accounts
	 * @param user
	 * @throws RemoteException
	 */
	public void deleteAccount(String user) throws RemoteException {
		bd.deleteAccount(user);
		LOGGER.log(Level.FINE, "User " + user + " deleted");
	}
	/**
	 * @brief Method for creating users
	 * @param username
	 * @param pass
	 * @param email
	 * @throws RemoteException
	 */
	public void createUser(String username, String pass, String email) throws RemoteException {
		System.out.println(username + pass + email);
		bd.storeAccount(new User(username, pass, email));
		LOGGER.log(Level.FINE, "User " + username + "created");
	}
	/**
	 * @brief Method for getting users from the database
	 * @param user
	 * @return User
	 */
	public User getUser(String user){
		System.out.println(user);
		return (User) bd.getAccount(user);
	}
	/**
	 * @brief Method for getting reports from the database
	 * @param accNum
	 * @return ArrayList
	 */
	public ArrayList<Report> getReports(int accNum){
		return bd.getReports(accNum);
	}
	/**
	 * @brief Method for getting all the users from the database
	 * @return ArrayList
	 * @throws RemoteException
	 */
	public List<Account> getUsers(){
		// TODO Auto-generated method stub
		return bd.getUsers();
	}

}
