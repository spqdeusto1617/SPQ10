package bankapp.server;

public interface IBankDAO {
	User getUser(String username);
	void storeUser(User user);
	void updateUser(User user);
	void storeAccount(Account acc);
	void updateAccount(Account acc);
}
