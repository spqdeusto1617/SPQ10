package bankapp.server;

import javax.jdo.annotations.*;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the Admin Class extends Account
 */
@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
public class Admin extends Account{
	/**
	 * @brief Constructor
	 * @param username
	 * @param pass
	 */
	public Admin(String username, String pass){
		super();
	}
}
