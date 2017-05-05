package bankapp.server;

import java.util.HashMap;
import javax.jdo.annotations.*;
@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
public class User extends Account{
	private String email;
	@NotPersistent
	private HashMap<String, bankAccount> accounts;
	public User(String username, String pass, String email){
		super(username, pass);
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
		bankAccount acc = new bankAccount();
		addAccount(acc);
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
}
