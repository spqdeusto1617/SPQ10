package bankapp.server;

import org.hibernate.validator.constraints.Email;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class User {
	@PrimaryKey
	private String username;
	private String pass;
	@Email
	private String email;

	public User(String username, String pass, String email){
		this.username = username;
		this.pass = pass;
		this.email = email;
	}

	/* Default contructor */
	public User() {

    }

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString(){
		return username;
	}
}
