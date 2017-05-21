package bankapp.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the Report 
 */
public class Report {
	private String user1;
	private String user2;
	private String accNum1;
	private String accNum2;
	private String reportType;
	private long money;
	@PrimaryKey
	private int id;
	private static int reports = 0;
	/**
	 * @brief constractor
	 * @param user1
	 * @param user2
	 * @param money
	 * @param accNum1
	 * @param accNum2
	 */
	public Report(String user1, String user2, long money, String accNum1, String accNum2){
		this.user1 = user1;
		this.user2 = user2;
		this.accNum1 = accNum1;
		this.accNum2 = accNum2;
		this.money = money;
		reports++;
		this.id = reports;
		this.reportType = "User-User transaction";
	}
	/**
	 * @brief constractor 2
	 * @param user1
	 */
	public Report(String user1){
		this.user1 = user1;
		reports++;
		this.id = reports;
		this.reportType = "Account creation";
	}
	/**
	 * @brief constractor 3
	 * @param user1
	 * @param accNum1
	 * @param money
	 */
	public Report(String user1, String accNum1, long money){
		this.user1 = user1;
		this.accNum1 = accNum1;
		this.money = money;
		reports++;
		this.id = reports;
		this.reportType = "funds added";
	}
	/**
	 * @brief get the report type
	 * @return reportType
	 */
	public String getReportType(){
		return reportType;
	}
	/**
	 * @brief get the user number 1
	 * @return user1
	 */
	public String getUser1() {
		return user1;
	}
	/**
	 * @brief get the user number 2
	 * @return user2
	 */
	public String getUser2(){
		return user2;
	}
	/**
	 * @brief get account 1 number 
	 * @return accNum1
	 */
	public String getAccNum1(){
		return accNum1;
	}
	/**
	 * @brief get account 2 number 
	 * @return accNum2
	 */
	public String getAccNum2(){
		return accNum2;
	}
	/**
	 * @get id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @brief get money amount
	 * @return money
	 */
	public long getMoney(){
		return money;
	}
}