package bankapp.client;

public class bankController {
	
	private RMIServiceLocator rsl;
	
	public bankController(String ip, String port, String serviceName){
		rsl = new RMIServiceLocator();
		//Ventanas
		//new Login(this);
		rsl.setService(ip, port, serviceName);
	}
	
	public char login(String user, String pass){
		System.out.println("Controller calling -> RMIServiceLocator");
		return rsl.login(user, pass);
	}
}
