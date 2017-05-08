package bankapp.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBManager extends Remote {

	public char login(String user, String pass) throws RemoteException;
	public void transaction(String user1, String user2, int money, String accNum1, String accNum2) throws RemoteException;
	public void createAccount(String user) throws RemoteException;
	public void addFunds(String user, String accNum, int money);
}