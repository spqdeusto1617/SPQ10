package bankapp.client;

public class bankController {
	
	private RMIServiceLocator rsl;
	
	public bankController(String ip, String port, String serviceName){
		rsl = new RMIServiceLocator();
		rsl.setService(ip, port, serviceName);
	}
	
	public char login(String user, String pass){
		//calls the service locator login method from the controller
		System.out.println("Controller calling -> RMIServiceLocator");
		return rsl.login(user, pass);
	}
}
