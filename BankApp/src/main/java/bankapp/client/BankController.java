package bankapp.client;

import java.util.ArrayList;

import bankapp.server.Report;
import bankapp.server.User;

/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the bank controller and hundler Class
 */
public class BankController {
	/**
	 * @brief private variable type RMIServiceLocator
	 */
	private RMIServiceLocator rsl;
	/**
	 * @brief Constructor set the service for the RMI
	 * @param ip
	 * @param port
	 * @param serviceName
	 */
	public BankController(String ip, String port, String serviceName){
		rsl = new RMIServiceLocator();
		//Ventanas
		//new Login(this);
		rsl.setService(ip, port, serviceName);
	}
	/**
	 * @brief Login Function Allow or Deny access to the application
	 * @param user
	 * @param pass
	 * @return char
	 */
	public char login(String user, String pass){
		//calls the service locator login method from the controller
		System.out.println("Controller calling -> RMIServiceLocator");
		return rsl.login(user, pass);
	}
	/**
	 * @brief Create user method
	 * @param user
	 * @param pass
	 * @param email
	 */
	public void createUser(String user, String pass, String email){
		rsl.createUser(user, pass, email);
	}
	/**
	 * @brief Make transaction method
	 * @param user1
	 * @param user2
	 * @param money
	 * @param accNum1
	 * @param accNum2
	 */
	public void transaction(String user1, String user2, long money, String accNum1, String accNum2){
		rsl.transaction(user1, user2, money, accNum1, accNum2);
	}
	/**
	 * @brief Create bank account method
	 * @param user
	 * @return int
	 */
	public int createBankAccount(String user){
		return rsl.createBankAccount(user);
	}
	/**
	 * @brief Adds funds to any bank account
	 * @param user
	 * @param accNum
	 * @param money
	 */
	public void addFunds(String user, String accNum, long money){
		rsl.addFunds(user, accNum, money);
	}
	/**
	 * @brief Deletes bank account
	 * @param user
	 * @param accNum
	 * @param accNum2
	 */
	public void deleteBankAccount(String user, String accNum1, String accNum2){
		rsl.deleteBankAccount(user, accNum1, accNum2);
	}
	/**
	 * @brief Deletes account
	 * @param user
	 */
	public void deleteAccount(String user){
		rsl.deleteAccount(user);
	}
	
	public User getUser(String user){
		return rsl.getUser(user);
	}
	
	public ArrayList<Report> getReports(int accNum){
		System.out.println("Getting reports");
		return rsl.getReports(accNum);
		
	}
}
