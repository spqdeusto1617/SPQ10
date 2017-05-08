package bankapp.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;


//Class in charge of communications with the database
public class bankDAO implements IbankDAO {
	private PersistenceManagerFactory pmf;
	public bankDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
}

	//gets account information from the db with the username
	@Override
	public Account getAccount(String username) {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Account account = null;
			System.out.println("   * Retrieving an Extent for User.");
			
			tx.begin();
			System.out.println("Retrieving account: " + username);
			Query<?> query = pm.newQuery("SELECT FROM " + Account.class.getName() + " WHERE username == '" + username + "'");
	    	query.setUnique(true);
	    	account = (Account)query.execute();
			tx.commit();			
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close();    				
		return account;
	}

	//stores account object in the database
	public void storeAccount(Account acc) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing account" + acc);
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
	
	public void storeReport(Report rep){
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing report");
	       pm.makePersistent(rep);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing report: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}

	@Override
	public void deleteAccount(String username) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Account account = null;
			System.out.println("   * Retrieving an Extent for User.");
			
			tx.begin();
			System.out.println("Retrieving account: " + username);
			Query<?> query = pm.newQuery("SELECT FROM " + Account.class.getName() + " WHERE username == '" + username + "'");
	    	query.setUnique(true);
	    	account = (Account)query.execute();
			tx.commit();			
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
	    	pm.deletePersistent(account);
    		pm.close();
		
	}

}
