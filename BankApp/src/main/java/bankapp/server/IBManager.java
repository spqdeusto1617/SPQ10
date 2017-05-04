package bankapp.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBManager extends Remote {

	public char login(String user, String pass) throws RemoteException;
	
}