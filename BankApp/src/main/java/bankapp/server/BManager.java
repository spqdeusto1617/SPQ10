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
	//Manager is in charge of the providing the client with methods (facade)
	public BManager(String serverAddress, String port0, String servName) throws RemoteException {
		super();
		this.serverAddress = serverAddress;
		this.port0 = Integer.parseInt(port0);
		this.servName = servName;
		bd.storeAccount(new Admin("adminuser", "adminpass"));
		bd.storeAccount(new User("user", "pass", "user@mail.com"));
	}
		
	public char login(String username, String pass) throws RemoteException {
		try{
			Account login = bd.getAccount(username);
			if(login.getPass().equals(pass)){
				System.out.println("-- User : " + username + " // Pass : " + pass + " --");
				System.out.println("login successful!");
				if(login instanceof Admin)
					return 'a';
				else if (login instanceof User)
					return 'u';
				else return 'e';
			}
			else{
				System.out.println("Error: found user but password does not coincide");
				return 'e';
			}
		}catch(Exception ex){
			System.out.println("Error retrieving user from DB. Check if the user exists");
			return 'e';
		}
	}

	@Override
	public void transaction(String user1, String user2, int money, String accNum1, String accNum2) throws RemoteException {
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
	public void createAccount(String user) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
		userObj.createAccount();
		bd.storeAccount(userObj);
		bd.storeReport(new Report(user));
	}

	@Override
	public void addFunds(String user, String accNum, int money) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
		userObj.addFundstoAccount(accNum, money);
		bd.storeAccount(userObj);
		bd.storeReport(new Report(user, accNum, money));
	}

	@Override
	public void deleteBankAccount(String user, String accNum1, String accNum2) throws RemoteException {
		User userObj = (User) bd.getAccount(user);
		transaction(user, user, userObj.getAccount(accNum1).getmoney(), accNum1, accNum2);
		userObj.deleteAccount(accNum1);
		bd.storeAccount(userObj);
	}

}
