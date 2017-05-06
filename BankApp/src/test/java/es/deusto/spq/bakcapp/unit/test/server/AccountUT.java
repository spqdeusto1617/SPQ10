package es.deusto.spq.bakcapp.unit.test.server;

import bankapp.server.Account;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountUT {



    @Test
    public void validAccout() {
        Account account = new Account();
        account.setmoney(100);
        account.setnumAcc(200);
        account.setNumcli(123);

        assertTrue(account != null);
        assertThat(account.getmoney(), is(100));
        assertThat(account.getnumAcc(), is(200));
        assertThat(account.getNumcli(), is(123));
    }
}
