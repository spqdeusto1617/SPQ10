package bankapp.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBManager extends Remote {

	public char login(String user, String pass) throws RemoteException;
	public void transaction(String user1, String user2, long money, String accNum1, String accNum2) throws RemoteException;
	public int createBankAccount(String user) throws RemoteException;
	public void addFunds(String user, String accNum, long money) throws RemoteException;
	public void deleteBankAccount(String user, String accNum1, String accNum2) throws RemoteException;
	public void deleteAccount(String user) throws RemoteException;
	public void createUser(String username, String pass, String email) throws RemoteException;
}