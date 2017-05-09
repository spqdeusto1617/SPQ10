package bankapp.client;

import java.util.Scanner;

public class bankClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Please insert username login");
		Scanner keyboard = new Scanner(System.in);
	    String username = keyboard.nextLine();
	    System.out.println("Please insert user pass");
	    String pass = keyboard.nextLine();
	    bankController bController = new bankController(args[0], args[1], args[2]);
	    bController.login(username, pass);
	}

}
