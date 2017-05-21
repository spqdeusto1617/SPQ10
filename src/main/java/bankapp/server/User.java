package bankapp.server;

import java.util.HashMap;
import javax.jdo.annotations.*;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the User 
 */
public class User {
	private String email;
	@Persistent(defaultFetchGroup="true")
	@Join
	private HashMap<String, bankAccount> accounts;
	/**
	 * @brief constractor
	 * @param username
	 * @param pass
	 * @param email
	 */
	public User(String username, String pass, String email){
		super(username, pass);
		this.email = email;
		this.accounts = new HashMap<>();
	}
	/**
	 * @brief get the user name
	 * @return username
	 */
	
	public String getUsername() {
		return username;
	}
	/**
	 * @brief set the user name 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @brief get the user password 
	 * @return pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @brief set the user password 
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * @brief get user email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @brief set the user email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @brief get the user name
	 * @return username
	 */
	public String toString(){
		return username;
	}
}
