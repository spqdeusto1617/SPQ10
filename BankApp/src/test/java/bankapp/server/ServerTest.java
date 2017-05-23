package bankapp.server;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the ServerTest class 
 */
public class ServerTest {
	BankDAO bd;
	BManager bManager;

	final Logger logger = LogManager.getLogger(ServerTest.class);
	 
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ServerTest.class);
	}
	
	@Before
	/**
	 * @brief initialise bankDAO , BManager
	 * @throws RemoteException
	 */
	public void setup() throws RemoteException{
		logger.info("Entering setup");
		bd = new BankDAO();
		bManager = new BManager("1", "1", "1");
	}
	
	@Test
	/**
	 * @brief Test login
	 * @throws RemoteException
	 */
	public void testLogin() throws RemoteException{
		logger.info("Starting testLogin");
		assertTrue(bManager.login("adminuser", "adminpass") == 'a');
		logger.debug("finishing testLogin");
	}
	@Test
	public void testTransaction() throws RemoteException{
		logger.info("Starting testTransaction");
    	bManager.createUser("username", "password", "email@example.com");
    	bManager.createUser("username2", "password2", "email2@example.com");
    	int accountnum1 = bManager.createBankAccount("username");
    	int accountnum2 = bManager.createBankAccount("username2");
        String accNum1 = Integer.toString(accountnum1);
        String accNum2 = Integer.toString(accountnum2);
    	bManager.transaction("username", "username2", 500, accNum1, accNum2);
    	User user = (User) bd.getAccount("username2");
    	assertTrue(user.getAccount(accNum2).getmoney() == 500);
    	bManager.deleteAccount("username");
    	bManager.deleteAccount("username2");
    	logger.debug("finishing testTransaction");
	}
}
