package bankapp.client;

import java.util.Scanner;

public class bankClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		bankController bController = new bankController(args[0], args[1], args[2]);
	    String username;
	    String pass;
		do{
		System.out.println("Please insert username login");
	    username = keyboard.nextLine();
	    System.out.println("Please insert user pass");
	    pass = keyboard.nextLine();
		}while(!bController.login(username, pass));

	}
}
