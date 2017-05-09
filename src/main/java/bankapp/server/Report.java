package bankapp.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
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
	
	public Report(String user1){
		this.user1 = user1;
		reports++;
		this.id = reports;
		this.reportType = "Account creation";
	}
	
	public Report(String user1, String accNum1, long money){
		this.user1 = user1;
		this.accNum1 = accNum1;
		this.money = money;
		reports++;
		this.id = reports;
		this.reportType = "funds added";
	}
	
	public String getReportType(){
		return reportType;
	}
	public String getUser1() {
		return user1;
	}
	public String getUser2(){
		return user2;
	}
	public String getAccNum1(){
		return accNum1;
	}
	public String getAccNum2(){
		return accNum2;
	}
	public int getId() {
		return id;
	}
	public long getMoney(){
		return money;
	}
}