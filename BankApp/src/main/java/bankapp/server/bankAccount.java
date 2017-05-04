package bankapp.server;

public class bankAccount {
	
	private static int accounts = 0;
	private int numAcc;
	private int money;
	
	public bankAccount(){
		accounts++;
		this.numAcc = accounts;
		this.money = 0;
	}
	public int getnumAcc(){
		return numAcc;
	}
	public int getmoney() {
		return money;
	}
	public void addmoney(int money) {
		this.money += money;
	}
	public void deducemoney(int money){
		this.money -= money;
	}

}
