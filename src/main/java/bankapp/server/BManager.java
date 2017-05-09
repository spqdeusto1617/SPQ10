package bankapp.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BManager extends UnicastRemoteObject implements IBManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(BManager.class.getName() );
	
	bankDAO bd = new bankDAO();
	String serverAddress;
	int port0;
	String servName;
	//Manager is in charge of the providing the client with methods (facade)
	public BManager(String serverAddress, String port0, String servName) throws RemoteException {
		super();
		this.serverAddress = serverAddress;
		this.port0 = Integer.parseInt(port0);
		this.servName = servName;
		bd.storeAccount(new Admin("adminuser", "adminpass"));
	}
		
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

	@Override
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

	@Override
	public int createBankAccount(String user) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
		int banknum = userObj.createAccount();
		bd.storeAccount(userObj);
		bd.storeReport(new Report(user));
		LOGGER.log(Level.FINE, "Created bank account for user " + user + " with number: " + banknum);
		return banknum;
	}

	public void addFunds(String user, String accNum, long money) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
		userObj.addFundstoAccount(accNum, money);
		bd.storeAccount(userObj);
		bd.storeReport(new Report(user, accNum, money));
		LOGGER.log(Level.FINE, "Added " + money + " for user: " + user);
	}

	@Override
	public void deleteBankAccount(String user, String accNum1, String accNum2) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
		transaction(user, user, userObj.getAccount(accNum1).getmoney(), accNum1, accNum2);
		userObj.deleteAccount(accNum1);
		bd.storeAccount(userObj);
		LOGGER.log(Level.FINE, "Bank account number " + accNum1 + " deleted for user: " + user);
	}

	@Override
	public void deleteAccount(String user) throws RemoteException {
		bd.deleteAccount(user);
		LOGGER.log(Level.FINE, "User " + user + " deleted");
	}

	@Override
	public void createUser(String username, String pass, String email) throws RemoteException {
		System.out.println(username + pass + email);
		bd.storeAccount(new User(username, pass, email));
		LOGGER.log(Level.FINE, "User " + username + "created");
	}

}