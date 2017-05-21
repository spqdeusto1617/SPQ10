package bankapp.server;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the ServerTest class 
 */
public class ServerTest {
	bankDAO bd;
	BManager bManager;
	@Before
	/**
	 * @brief initialise bankDAO , BManager
	 * @throws RemoteException
	 */
	public void setup() throws RemoteException{
		bd = new bankDAO();
		bManager = new BManager("", "", "");
	}
	
	@Test
	/**
	 * @brief Test login
	 * @throws RemoteException
	 */
	public void testLogin() throws RemoteException{

		//assertTrue(bManager.login("adminuser", "adminpass") == 'a');
	}
}
