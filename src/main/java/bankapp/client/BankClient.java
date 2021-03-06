package bankapp.client;

import java.util.Scanner;

/**
 * @author BICHRI
 * 
 * @date 05-17-2017
 * 
 * @brief This is the main Login Class
 * 
 * @mainpage Bank application as a project for SOFTWARE PROCESS AND QUALITY 
 * 
 * @warning This code is Just a school project, not for professional use 
 * 
 * @copyright Free license 
 * 
 * @section intro_sec Introduction
 * 
 * this an apllication to help users and managers do their banking tasks easily 
 * 
 * @section compile_sec Compilation
 * know how to compile the code using maven 
 * 
 */

public class BankClient {

@SuppressWarnings("resource")
	public static void main(String[] args) {
		//keyboard input
		Scanner keyboard = new Scanner(System.in);
		//creation of the controller object with argument passing (ports and IP)
		BankController bController = new BankController(args[0], args[1], args[2]);
	    String username;
	    String pass;
	    long timeBlock = 0;
	    char loginchar;
	    int counter = 0;
	    //do while loop asking for account login
		do{
		counter++;
		System.out.println("Please insert username login");
	    username = keyboard.nextLine();
	    System.out.println("Please insert user pass");
	    pass = keyboard.nextLine();
		if(counter < 4){
	    loginchar = bController.login(username, pass);
		}
		//if user reaches fourth number of tries, timeblock activates
		else if(counter == 4){
			timeBlock = System.currentTimeMillis();
			System.out.println("Too many login tries. Try again in 20 seconds");
			loginchar = 'e';
		}
		//if user keeps trying to log in after the try limit, he will be shown the waiting time
		else{
			if(System.currentTimeMillis() - timeBlock > 20000)
				counter = 0;
			else System.out.println("Too many login tries Try again in " + (20 - ((System.currentTimeMillis() - timeBlock)/1000)) + " seconds");
			loginchar = 'e';	    	
		}
		}while(loginchar == 'e');
		//if returns 'e', there was a login error and the loop restarts
		//if returns 'a', account is admin
		if(loginchar == 'a'){
			System.out.println("user is admin");
			bController.createUser("user", "pass", "user@mail.com");
			bController.createUser("user1", "pass1", "user1@mail.com");
			
		}
		//if returns 'u', account is user
		else if(loginchar == 'u'){
			System.out.println("user is standard user");
			System.out.println("created bank account with number: " + bController.createBankAccount(username));
			System.out.println("created bank account with number: " + bController.createBankAccount(username));
			bController.addFunds(username, "2", 55);
		}
	}
}

