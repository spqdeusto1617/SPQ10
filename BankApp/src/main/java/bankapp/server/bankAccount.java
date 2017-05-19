package bankapp.server;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
public class bankAccount {
	private static int accounts = 0;
	private int numAcc;
	private long money;
	
	public bankAccount(){
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

}
