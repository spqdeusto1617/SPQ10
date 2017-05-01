package bankapp.server;

public interface IbankDAO {
	public User getUser(String username);
	public void storeUser(User user);
	public void updateUser(User user);
	public void storeAccount(Account acc);
	public void updateAccount(Account acc);
}
