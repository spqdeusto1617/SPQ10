package bankapp.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBManager extends Remote {

	public boolean login(String user, String pass) throws RemoteException;
	public boolean loginAdmin(String user, String pass) throws RemoteException;
	
}