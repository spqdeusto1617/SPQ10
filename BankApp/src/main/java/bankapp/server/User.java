package bankapp.server;

import java.util.HashMap;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class User {
	@PrimaryKey
	private String username;
	private String pass;
	private String email;
	private HashMap<String, Account> accounts;
	public User(String username, String pass, String email){
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.accounts = new HashMap<>();
	}
	public void deduceAccountFunds(String accNum, int money){
		this.accounts.get(accNum).deducemoney(money);
	}
	public void addFundstoAccount(String accNum, int money){
		this.accounts.get(accNum).addmoney(money);
	}
	public void createAccount(){
		Account acc = new Account();
		addAccount(acc);
	}
	public void addAccount(Account acc){
		this.accounts.put(Integer.toString(acc.getnumAcc()), acc);
	}
	public String getUsername() {
		return username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString(){
		return username;
	}
}
