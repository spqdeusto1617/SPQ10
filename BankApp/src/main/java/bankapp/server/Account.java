package bankapp.server;

import javax.jdo.annotations.*;
//JDO Persistence, use one table for storing both Account (superclass)
//User, and Admin (inherited classes)
@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
@Discriminator(strategy=DiscriminatorStrategy.CLASS_NAME)
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
