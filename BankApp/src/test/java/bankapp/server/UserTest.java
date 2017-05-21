package bankapp.server;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.validation.Validator;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.JUnit4TestAdapter;

public class UserTest {

    protected static Validator validator;
    final Logger logger = LoggerFactory.getLogger(UserTest.class);
//    @Before
//    public void setup() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
    
    @Rule public ContiPerfRule rule = new ContiPerfRule();
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(UserTest.class);
	}
	
    @PerfTest(invocations = 1000, threads = 20)
    @Required(throughput = 20)
    @Test
    public void validUser() {
    	logger.info("Starting validUser test");
        User user = new User("username", "password", "email@example.com");
        int accountnum = user.createAccount();
        String accNum = Integer.toString(accountnum);
        assertTrue(user != null);
        assertThat(user.getEmail(), is("email@example.com"));
        assertThat(user.getPass(), is("password"));
        assertThat(user.getUsername(), is("username"));
        assertThat(user.getAccount(accNum).getnumAcc(), is(accountnum));
        logger.debug("Finishing validUser test");
    }
    @PerfTest(invocations = 1000, threads = 20)
    @Required(average = 50)
    @Test
    public void testAddFunds(){
    	logger.info("Starting testAddFunds");
    	User user = new User("username", "password", "email@example.com");
        int accountnum = user.createAccount();
        String accNum = Integer.toString(accountnum);
        user.addFundstoAccount(accNum, 250);  
        logger.debug("finishing testAddFunds");
    }
    
    @PerfTest(duration = 10000)
    @Test
    public void testTransaction(){
    	logger.info("Staring transaction test");
    	User user1 = new User("username", "password", "email@example.com");
    	User user2 = new User("username2", "password2", "email2@example.com");
    	int accountnum1 = user1.createAccount();
    	int accountnum2 = user2.createAccount();
        String accNum1 = Integer.toString(accountnum1);
        String accNum2 = Integer.toString(accountnum2);
    	user1.deduceAccountFunds(accNum1, 500);
    	user2.addFundstoAccount(accNum2, 500);
    	assertTrue(user2.getAccount(accNum2).getmoney() == 500);
    	assertTrue(user1.getAccount(accNum1).getmoney() == -500);
    	logger.debug("finishing transaction test");
    }
    /* TODO - review validation fields annotations */
//    @Test(expected = ConstraintViolationException.class)
//    public void invalidUser() {
//        User user = new User("", "", "");
//        assertTrue(user != null);
//        assertFalse(validate(user).isEmpty());
//    }
//
//    public static <T> Set<ConstraintViolation<T>> validate(T obj) {
//        return validator.validate(obj);
//    }
}
