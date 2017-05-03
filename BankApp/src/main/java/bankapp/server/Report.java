package bankapp.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Report {
	@PrimaryKey
	private User user;
	private Account acc;
	private int id;
	
	public Report(User user, Account acc, int id){
		this.user = user;
		this.acc = acc;
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Account getAccount() {
		return acc;
	}
	public void setPass(Account acc) {
		this.acc = acc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 public String toString(){
		return user;
	}
	*/
}
