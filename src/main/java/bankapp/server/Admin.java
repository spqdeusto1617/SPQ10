package bankapp.server;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
public class Admin extends Account{
	public Admin(String username, String pass){
		super(username, pass);
	}
}