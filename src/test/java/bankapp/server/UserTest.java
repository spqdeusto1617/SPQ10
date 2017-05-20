package bankapp.server;

import bankapp.server.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.validation.*;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the UserTest class 
 */
public class UserTest {

    protected static Validator validator;

//    @Before
//    public void setup() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }

    @Test
    /**
     * @brief create valid user 
     */
    public void validUser() {
        User user = new User("username", "password", "email@example.com");
        int accountnum = user.createAccount();
        String accNum = Integer.toString(accountnum);
        assertTrue(user != null);
        assertThat(user.getEmail(), is("email@example.com"));
        assertThat(user.getPass(), is("password"));
        assertThat(user.getUsername(), is("username"));
        assertThat(user.getAccount(accNum).getnumAcc(), is(accountnum));
    }

    @Test
    /**
     * @brief test the add funds 
     */
    public void testAddFunds(){
    	User user = new User("username", "password", "email@example.com");
        int accountnum = user.createAccount();
        String accNum = Integer.toString(accountnum);
        user.addFundstoAccount(accNum, 250);    	
    }
    
    @Test
    /**
     * @brief test a transaction
     */
    public void testTransaction(){
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
