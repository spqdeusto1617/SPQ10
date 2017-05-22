package bankapp.server;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief Interface IbankDAO to set function names and params
 */
public interface IBankDAO {
	/**
	 * @brief function name and params
	 * @param username
	 * @return Account
	 */
	public Account getAccount(String username); 
	/**
	 * @brief function name and params
	 * @param acc
	 */
	public void storeAccount(Account acc);
	/**
	 * @brief function name and params
	 * @param rep
	 */
	public void storeReport(Report rep);
	/**
	 * @brief function name and params
	 * @param acc
	 */
	public void deleteAccount(String username);
}
