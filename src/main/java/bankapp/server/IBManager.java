package bankapp.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
	public boolean login(String user, String pass) throws RemoteException;
	
}