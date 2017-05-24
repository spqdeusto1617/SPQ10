package bankapp.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief Interface IBManager extends Remote to set function names and params
 */
public interface IBManager extends Remote {
/**
 * @brief function name and params
 * @param user
 * @param pass
 * @return
 * @throws RemoteException
 */
	public char login(String user, String pass) throws RemoteException;
	public void transaction(String user1, String user2, long money, String accNum1, String accNum2) throws RemoteException;
	public int createBankAccount(String user) throws RemoteException;
	public void addFunds(String user, String accNum, long money) throws RemoteException;
	public void deleteBankAccount(String user, String accNum1) throws RemoteException;
	public void deleteAccount(String user) throws RemoteException;
	public void createUser(String username, String pass, String email) throws RemoteException;
	public User getUser(String user) throws RemoteException;
	public ArrayList<Report> getReports(int accNum) throws RemoteException;
	public List<Account> getUsers() throws RemoteException;
}