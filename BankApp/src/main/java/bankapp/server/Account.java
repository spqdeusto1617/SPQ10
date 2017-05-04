package bankapp.server;

import javax.jdo.annotations.*;


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
public class Account {
	@PrimaryKey
	private String username;
	private String pass;
	public Account(String username, String pass){
		this.username = username;
		this.pass = pass;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPass() {
		return this.pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String toString(){
		return username;
	}
}
