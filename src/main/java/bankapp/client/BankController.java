package bankapp.client;

public class BankController {
	
	private RMIServiceLocator rsl;
	
	public BankController(String ip, String port, String serviceName){
		rsl = new RMIServiceLocator();
		//Ventanas
		//new Login(this);
		rsl.setService(ip, port, serviceName);
	}
	
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
