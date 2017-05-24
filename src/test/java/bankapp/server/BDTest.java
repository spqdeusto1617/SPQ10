package test.java.bankapp.server;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the BDTest class 
 */

public class BDTest {
	BankDAO bd;
	@Before
	/**
	 * @brief initialise bankDAO object
	 */
	public void setup(){
		bd = new BankDAO();
	}
	
	@Test
	/**
	 * @brief create a valid DB
	 */
	public void validBD(){
		 User user = new User("testuser", "testpassword", "testemail@example.com");
		 bd.storeAccount(user);
		 User user1 = (User) bd.getAccount(user.getUsername());
		 Admin admin = new Admin("testadminuser", "testadminpass");
		 bd.storeAccount(admin);
		 Admin admin1 = (Admin) bd.getAccount(admin.getUsername());
		 assertTrue(user != null);
		 assertTrue(user1 != null);
		 assertTrue(admin != null);
		 assertTrue(admin1 != null);
		 assertFalse(admin.equals(admin1));
		 assertTrue(admin.getClass().equals(Admin.class));
		 assertFalse(user.equals(user1));
		 assertTrue(user.getClass().equals(User.class));
		 bd.deleteAccount(user.getUsername());
		 bd.deleteAccount(admin.getUsername());
	}
}
