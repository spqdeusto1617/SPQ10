package bankapp.server;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class ServerTest {
	bankDAO bd;
	BManager bManager;
	@Before
	public void setup() throws RemoteException{
		bd = new bankDAO();
		bManager = new BManager("", "", "");
	}
	
	@Test
	public void testLogin() throws RemoteException{
		assertTrue(bManager.login("adminuser", "adminpass") == 'a');
	}
}
