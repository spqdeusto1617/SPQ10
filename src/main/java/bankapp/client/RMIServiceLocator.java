package bankapp.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bankapp.server.IBManager;
import bankapp.server.Report;
import bankapp.server.User;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the bank RMIServices hundler Class
 */
public class RMIServiceLocator {
	/**
	 * @brief Private Variable type IBManager
	 */
	private IBManager bm;
	/**
	 * @brief set the service of an RMI
	 * @param ip
	 * @param port
	 * @param serviceName
	 */
	public void setService(String ip, String port, String serviceName){    
		String name = "//" + ip + ":" + port + "/" + serviceName;
		try {
			bm = (IBManager) java.rmi.Naming.lookup(name);
		}catch (MalformedURLException | RemoteException | NotBoundException e) {
		e.printStackTrace();
		}    
	}
	/**
	 * @brief Login to RMIService
	 * @param user
	 * @param pass
	 * @return char
	 */
	public char login(String user, String pass){
		try{
			System.out.println("RMIServiceLocator calling -> EBManager");
			//calls server's bank manager class
			return bm.login(user, pass);
		} catch (RemoteException e) {
			System.out.println("RemoteException: Login error");
		}
		return 'e';
	}
	/**
	 * @brief RMI create user method call
	 * @param user
	 * @param pass
	 * @param email
	 */
	public void createUser(String user, String pass, String email){
		try {
			bm.createUser(user, pass, email);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @brief RMI transaction method call
	 * @param user1
	 * @param user2
	 * @param money
	 * @param accNum1
	 * @param accNum2
	 */
	public void transaction(String user1, String user2, long money, String accNum1, String accNum2){
		try {
			bm.transaction(user1, user2, money, accNum1, accNum2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @brief RMI create bank account method call
	 * @param user
	 * @return int
	 */
	public int createBankAccount(String user){
		int banknum = -1;
		try {
			banknum = bm.createBankAccount(user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banknum;
	}
	/**
	 * @brief RMI add funds method call
	 * @param user
	 * @param accNum
	 * @param money
	 */
	public void addFunds(String user, String accNum, long money){
		try {
			bm.addFunds(user, accNum, money);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Added " + money + "Euros to account");
	}
	/**
	 * @brief RMI delete bank account method call
	 * @param user
	 * @param accNum
	 * @param accNum2
	 */
	public void deleteBankAccount(String user, String accNum1, String accNum2){
		try {
			bm.deleteBankAccount(user, accNum1, accNum2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @brief RMI delete account method call
	 * @param user
	 */
	public void deleteAccount(String user){
		 try {
			bm.deleteAccount(user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User getUser(String user){
		try{
			return bm.getUser(user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Report> getReports(int accNum){
		try {
			return bm.getReports(accNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<User> getUsers(){
		try {
			return bm.getUsers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
