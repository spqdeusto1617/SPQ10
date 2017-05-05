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
	    long timeBlock = 0;
	    char loginchar;
	    //do while loop asking for account login
	    int counter = 0;
		do{
		counter++;
		System.out.println("Please insert username login");
	    username = keyboard.nextLine();
	    System.out.println("Please insert user pass");
	    pass = keyboard.nextLine();
		if(counter < 4){
	    loginchar = bController.login(username, pass);
		}
		else if(counter == 4){
			timeBlock = System.currentTimeMillis();
			System.out.println("Too many login tries. Try again in 20 seconds");
			loginchar = 'e';
		}
		else{
			if(System.currentTimeMillis() - timeBlock > 20000)
				counter = 0;
			else System.out.println("Too many login tries Try again in " + (20 - ((System.currentTimeMillis() - timeBlock)/1000)) + " seconds");
			loginchar = 'e';	    	
		}
		}while(loginchar == 'e');
		//if returns 'e', there was a login error and the loop restarts
		//if returns 'a', account is admin
		if(loginchar == 'a') System.out.println("user is admin");
		//if returns 'u', account is user
		else if(loginchar == 'u') System.out.println("user is standard user");
	}
}
