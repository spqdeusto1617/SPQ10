package bankapp.server;

import javax.jdo.JDOHelper;import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the bank DAO Class
 */
public class bankDAO implements IbankDAO {
	/**
	 * @brief Private variable type PersistenceManagerFactory 
	 */
	private PersistenceManagerFactory pmf;
	/**
	 * @brief Constractore for class bankDAO
	 */
	public bankDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
}

	@Override
	/**
	 * @brief Function to get user identified by a username giving as a param
	 * @param username
	 * @return user 
	 */
	public User getUser(String username) {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		User user = null;
			System.out.println("   * Retrieving an Extent for User.");
			
			tx.begin();
			System.out.println("Retrieving User: " + username);
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE username == '" + username + "'");
	    	query.setUnique(true);
	    	user = (User)query.execute();
			tx.commit();			
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    				
		return user;
	}

	@Override
	/**
	 * @brief Store a new user 
	 * @param user
	 */
	public void storeUser(User user) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing user: " + user);
	       pm.makePersistent(user);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing user: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}
	
	@Override
	/**
	 * @brief update a existing user 
	 * @param user
	 */
	public void updateUser(User user) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(user);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error updating User : " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}

	@Override
	/**
	 * Store a new amount
	 * @param acc
	 */
	public void storeAccount(Account acc) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing user: " + acc);
	       pm.makePersistent(acc);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing user: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}

	@Override
	/**
	 * @brief update an existing amount
	 * @param acc
	 */
	public void updateAccount(Account acc) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(acc);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("   $ Error updating User : " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}
}
