package bankapp.server;

public class Performance {

	public static void main(String[] args) {
		 User user = new User("perfuser", "perfpass", "email@example.com");
		 int accNum = user.createAccount();
		 user.addFundstoAccount(Integer.toString(accNum), 190);
		 user.deduceAccountFunds(Integer.toString(accNum), 40);
	}
}