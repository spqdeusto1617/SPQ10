package bankapp.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBManager extends Remote {

	boolean login(String userName, String pass) throws RemoteException;
	
}