package bankapp.server;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class bankAccountTest {

    @Test
    public void validAccount() {
        bankAccount account = new bankAccount();
        account.addmoney(100);
        assertTrue(account != null);
        assertThat(account.getmoney(), is(100L));
    }
}
