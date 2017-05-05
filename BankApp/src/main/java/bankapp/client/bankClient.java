package bankapp.client;

import java.util.Scanner;

public class bankClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//keyboard input
		Scanner keyboard = new Scanner(System.in);
		//creation of the controller object with argument passing (ports and IP)
		bankController bController = new bankController(args[0], args[1], args[2]);
	    String username;
	    String pass;
	    //do while loop asking for account login
		do{
		System.out.println("Please insert username login");
	    username = keyboard.nextLine();
	    System.out.println("Please insert user pass");
	    pass = keyboard.nextLine();
		}while(bController.login(username, pass) == 'e');
		//if returns 'e', there was a login error and the loop restarts
		//if returns 'a', account is admin
		if(bController.login(username, pass) == 'a');
		//if returns 'u', account is user
		else if(bController.login(username, pass) == 'u');
	}
}
