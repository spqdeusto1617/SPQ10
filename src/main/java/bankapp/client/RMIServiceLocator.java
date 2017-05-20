package bankapp.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import bankapp.server.IBManager;
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
	 * @return false
	 */
	public boolean login(String user, String pass){
		try{
			System.out.println("RMIServiceLocator calling -> EBManager");
			return bm.login(user, pass);
		} catch (RemoteException e) {
			System.out.println("RemoteException: Login error");
		}
		return false;
	}
}
