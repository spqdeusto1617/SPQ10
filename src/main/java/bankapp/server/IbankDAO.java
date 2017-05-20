package bankapp.server;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief Interface IbankDAO to set function names and params
 */
public interface IbankDAO {
	/**
	 * @brief function name and params
	 * @param username
	 * @return user
	 */
	public User getUser(String username);
	/**
	 * @brief function name and params
	 * @param user
	 */
	public void storeUser(User user);
	/**
	 * @brief function name and params
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * @brief function name and params
	 * @param acc
	 */
	public void storeAccount(Account acc);
	/**
	 * @brief function name and params
	 * @param acc
	 */
	public void updateAccount(Account acc);
}
