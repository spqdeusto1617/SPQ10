package bankapp.server;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the BankAccount Class implements Serializable
 */
public class BankAccount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int accounts = 0;
	private int numAcc;
	private long money;
	/**
	 * @brief Constructor
	 */
	public BankAccount(){
		accounts++;
		this.numAcc = accounts;
		this.money = 0;
	}
	/**
	 * get the account number
	 * @return
	 */
	public int getnumAcc(){
		return numAcc;
	}
	/**
	 * get the money amount
	 * @return
	 */
	public long getmoney() {
		return money;
	}
	/**
	 * add money to an account
	 * @param money
	 */
	public void addmoney(long money) {
		this.money += money;
	}
	/**
	 * deduce money to an account
	 * @param money
	 */
	public void deducemoney(long money){
		this.money -= money;
	}
	public String toString(){
		return numAcc + " // " + money;
	}
}
