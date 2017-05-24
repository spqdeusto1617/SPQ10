package bankapp.server;

import java.util.ArrayList;
import java.util.List;

/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief Interface IbankDAO to set function names and params
 */
public interface IBankDAO {
	/**
	 * @brief Gets account with the passed username from the database
	 * @param username
	 * @return Account
	 */
	public Account getAccount(String username); 
	/**
	 * @brief Stores account passed through parameters into the database
	 * @param acc
	 */
	public void storeAccount(Account acc);
	/**
	 * @brief Stores report passed through parameters into the database
	 * @param rep
	 */
	public void storeReport(Report rep);
	/**
	 * @brief Deletes account with the passed username from the database
	 * @param username
	 */
	public void deleteAccount(String username);
	/**
	 * @brief Gets reports from the account that has the number entered as parameters
	 * @param accNum
	 * @return ArrayList
	 */
	public ArrayList<Report> getReports(int accNum);
	/**
	 * @brief Gets a list of all users from the database
	 * @return ArrayList
	 */
	public List<Account> getUsers();
}
