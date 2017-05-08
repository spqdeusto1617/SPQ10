package bankapp.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import bankapp.server.IBManager;

public class RMIServiceLocator {
	
	private IBManager bm;
	
	//hooks the service locator with the server's bank manager
	public void setService(String ip, String port, String serviceName){    
		String name = "//" + ip + ":" + port + "/" + serviceName;
		try {
			bm = (IBManager) java.rmi.Naming.lookup(name);
		}catch (MalformedURLException | RemoteException | NotBoundException e) {
		e.printStackTrace();
		}    
	}
	
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
}