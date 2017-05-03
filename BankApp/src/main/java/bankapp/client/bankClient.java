package bankapp.client;

import java.util.Scanner;

public class bankClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Are you the admin?");
		Scanner keyboard = new Scanner(System.in);
		String answer = keyboard.nextLine();
		if(answer=="yes"){
			System.out.println("Please insert admin login");
		    String username = keyboard.nextLine();
		    System.out.println("Please insert admin pass");
		    String pass = keyboard.nextLine();
		    bankController bController = new bankController(args[0], args[1], args[2]);
		    bController.loginAdmin(username, pass);
		}else{
			System.out.println("Please insert username login");
		    String username = keyboard.nextLine();
		    System.out.println("Please insert user pass");
		    String pass = keyboard.nextLine();
		    bankController bController = new bankController(args[0], args[1], args[2]);
		    bController.login(username, pass);
		}
		
	}

}
