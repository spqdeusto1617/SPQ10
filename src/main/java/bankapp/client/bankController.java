package bankapp.client;
/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the bank controller and hundler Class
 */
public class bankController {
	/**
	 * @brief private variable type RMIServiceLocator
	 */
	private RMIServiceLocator rsl;
	/**
	 * @brief Constructor set the service for the RMI
	 * @param ip
	 * @param port
	 * @param serviceName
	 */
	public bankController(String ip, String port, String serviceName){
		rsl = new RMIServiceLocator();
		//Ventanas
		//new Login(this);
		rsl.setService(ip, port, serviceName);
	}
	/**
	 * @brief Login Function Allow or Deny access to the application
	 * @param user
	 * @param pass
	 * @return true
	 */
	public boolean login(String user, String pass){
		System.out.println("Controller calling -> RMIServiceLocator");
		if(rsl.login(user, pass)){
			//new Booking_Search(this);
			System.out.println("Login Succesfull");
			return true;
		}
		else{
			System.out.println("Login Unsuccessfull");
			return false;
		}
	

	}
}
