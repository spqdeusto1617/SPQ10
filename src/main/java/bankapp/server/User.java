package bankapp.server;

import java.util.HashMap;
import javax.jdo.annotations.*;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the User 
 */
public class User extends Account{
	private String email;
	@Persistent(defaultFetchGroup="true")
	@Join
	private HashMap<String, bankAccount> accounts;
	/**
	 * @brief constractor
	 * @param username
	 * @param pass
	 * @param email
	 */
	public User(String username, String pass, String email){
		super(username, pass);
		this.email = email;
		this.accounts = new HashMap<>();
	}
	public void deduceAccountFunds(String accNum, long money){
		this.accounts.get(accNum).deducemoney(money);
	}
	public void addFundstoAccount(String accNum, long money){
		this.accounts.get(accNum).addmoney(money);
	}
	public int createAccount(){
		bankAccount acc = new bankAccount();
		addAccount(acc);
		return acc.getnumAcc();
	}
	public void addAccount(bankAccount acc){
		this.accounts.put(Integer.toString(acc.getnumAcc()), acc);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void deleteAccount(String accNum){
		this.accounts.remove(accNum);
	}
	public bankAccount getAccount(String accNum){
		return this.accounts.get(accNum);
	}
}
