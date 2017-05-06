package es.deusto.spq.bankapp.unit.test.client;

import bankapp.client.bankController;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BankControllerUT {

    @Test
    public void createBankControllerObject() {
        bankController bankController = new bankController("ip",
                "port","serviceName");

        assertTrue(bankController.getRsl() != null);

    }
}
