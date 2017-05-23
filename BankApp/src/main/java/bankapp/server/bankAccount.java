package bankapp.server;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
public class BankAccount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int accounts = 0;
	private int numAcc;
	private long money;
	
	public BankAccount(){
		accounts++;
		this.numAcc = accounts;
		this.money = 0;
	}
	public int getnumAcc(){
		return numAcc;
	}
	public long getmoney() {
		return money;
	}
	public void addmoney(long money) {
		this.money += money;
	}
	public void deducemoney(long money){
		this.money -= money;
	}
	public String toString(){
		return numAcc + " // " + money;
	}
}
