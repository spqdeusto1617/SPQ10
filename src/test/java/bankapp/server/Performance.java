package bankapp.server;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the Performance class 
 */
public class Performance {
/**
 * @brief initialise user and create an account , add funds and deduce account funds  
 * @param args
 */
	public static void main(String[] args) {
		 User user = new User("perfuser", "perfpass", "email@example.com");
		 /* Tor remove - User class does not have the following methods */
		 /* int accNum = user.createAccount();
		 user.addFundstoAccount(Integer.toString(accNum), 190);
		 user.deduceAccountFunds(Integer.toString(accNum), 40); */
	}
}