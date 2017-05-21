package bankapp.server;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.JUnit4TestAdapter;

public class BDTest {
	bankDAO bd;
	 final Logger logger = LoggerFactory.getLogger(BDTest.class);
//	 @Rule public ContiPerfRule rule = new ContiPerfRule();
	 
	 public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(BDTest.class);
	}
	@Before
	public void setup(){
		bd = new bankDAO();
	}
//	
//	@PerfTest(invocations = 1000, threads = 20)
//    @Required(throughput = 20)
	@Test
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
