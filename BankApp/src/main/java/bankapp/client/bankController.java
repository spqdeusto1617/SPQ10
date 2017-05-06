package bankapp.client;

public class bankController {
	
	private RMIServiceLocator rsl;

	public RMIServiceLocator getRsl() {
		return rsl;
	}

	public void setRsl(RMIServiceLocator rsl) {
		this.rsl = rsl;
	}

	public bankController(String ip, String port, String serviceName){
		rsl = new RMIServiceLocator();
		//Ventanas
		//new Login(this);
		rsl.setService(ip, port, serviceName);
	}
	
	public boolean login(String user, String pass){
		System.out.println("Controller calling -> RMIServiceLocator");
		if(rsl.login(user, pass)){
			//new Booking_Search(this);
			System.out.println("Login Successfull");
			return true;
		}
		else{
			System.out.println("Login Unsuccessfull");
			return false;
		}
	

	}
}
