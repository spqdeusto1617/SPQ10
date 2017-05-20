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
 * this an apllication to help users and managers to do their daily tasks easily 
 * 
 * @section compile_sec Compilation
 * know how to compile the code using maven 
 * 
 */

public class bankClient {

	@SuppressWarnings("resource")
	/**
	 * @brief main fuction that will print outputs and get inputs to identify the user
	 * @param args
	 */
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
