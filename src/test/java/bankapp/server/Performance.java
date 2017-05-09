package bankapp.server;

public class Performance {

	public static void main(String[] args) {
		bankDAO bd = new bankDAO();
		 User user = new User("perfuser", "perfpass", "email@example.com");
		 bd.storeAccount(user);
		 User user1 = (User) bd.getAccount(user.getUsername());
		 Admin admin = new Admin("perfadmin", "perfadminpass");
		 bd.storeAccount(admin);
		 Admin admin1 = (Admin) bd.getAccount(admin.getUsername());
		 int accNum = user1.createAccount();
		 user1.addFundstoAccount(Integer.toString(accNum), 190);
		 user1.deduceAccountFunds(Integer.toString(accNum), 40);
	}

}
