package bankapp.server;

public interface IbankDAO {
	public Account getAccount(String username);
	public void storeAccount(Account acc);
}
