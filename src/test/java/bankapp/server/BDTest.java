package bankapp.server;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BDTest {
	bankDAO bd;
	@Before
	public void setup(){
		bd = new bankDAO();
	}
	
	@Test
	public void validBD(){
		 User user = new User("testuser", "testpassword", "email@example.com");
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
