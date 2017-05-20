package bankapp.server;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the bankAccountTest class 
 */
public class bankAccountTest {

    @Test
    /**
     * @brief create a valid account
     */
    public void validAccount() {
        bankAccount account = new bankAccount();
        account.addmoney(100);
        assertTrue(account != null);
        assertThat(account.getmoney(), is(100L));
    }
}
