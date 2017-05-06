package bankapp.server;

public class Account {
	
	private int numAcc;
	/*
	private String libellecp;
	private String senscp;
	*/
	private int money;
	private int numcli;
	public Account(){
		
	}
	public int getnumAcc() {
		return numAcc;
	}
	public void setnumAcc(int numAcc) {
		this.numAcc = numAcc;
	}
	/*	
	public String getLibellecp() {
		return libellecp;
	}
	public void setLibellecp(String libellecp) {
		this.libellecp = libellecp;
	}
	public String getSenscp() {
		return senscp;
	}
	public void setSenscp(String senscp) {
		this.senscp = senscp;
	}
	*/
	public int getmoney() {
		return money;
	}
	public void setmoney(int money) {
		this.money = money;
	}
	public int getNumcli() {
		return numcli;
	}
	public void setNumcli(int numcli) {
		this.numcli = numcli;
	}

}
