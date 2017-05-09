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
	public void createUser(String user, String pass, String email){
		try {
			bm.createUser(user, pass, email);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void transaction(String user1, String user2, long money, String accNum1, String accNum2){
		try {
			bm.transaction(user1, user2, money, accNum1, accNum2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int createBankAccount(String user){
		int banknum = -1;
		try {
			banknum = bm.createBankAccount(user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banknum;
	}
	public void addFunds(String user, String accNum, long money){
		try {
			bm.addFunds(user, accNum, money);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Added " + money + "Euros to account");
	}
	public void deleteBankAccount(String user, String accNum1, String accNum2){
		try {
			bm.deleteBankAccount(user, accNum1, accNum2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteAccount(String user){
		 try {
			bm.deleteAccount(user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
