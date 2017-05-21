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
		//calls the service locator login method from the controller
		System.out.println("Controller calling -> RMIServiceLocator");
		return rsl.login(user, pass);
	}
	public void createUser(String user, String pass, String email){
		rsl.createUser(user, pass, email);
	}
	public void transaction(String user1, String user2, long money, String accNum1, String accNum2){
		rsl.transaction(user1, user2, money, accNum1, accNum2);
	}
	public int createBankAccount(String user){
		return rsl.createBankAccount(user);
	}
	public void addFunds(String user, String accNum, long money){
		rsl.addFunds(user, accNum, money);
	}
	public void deleteBankAccount(String user, String accNum1, String accNum2){
		rsl.deleteBankAccount(user, accNum1, accNum2);
	}
	public void deleteAccount(String user){
		rsl.deleteAccount(user);
	}
}
