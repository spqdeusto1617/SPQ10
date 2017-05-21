package bankapp.server;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.JUnit4TestAdapter;

public class ServerTest {
	bankDAO bd;
	BManager bManager;
	
	final Logger logger = LoggerFactory.getLogger(ServerTest.class);
	 
		
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ServerTest.class);
	}
	
	@Before
	public void setup() throws RemoteException{
		logger.info("Entering setup");
		bd = new bankDAO();
		bManager = new BManager("1", "1", "1");
	}
	
	@Test
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
