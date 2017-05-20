package bankapp.server;

public interface IbankDAO {
	public User getUser(String username);
	public void storeUser(User user);
}
