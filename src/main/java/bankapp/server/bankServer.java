package bankapp.server;

import java.rmi.Naming;

/**
 *@author BICHRI
 *@date 05-17-2017
 *@brief This is the bank server Class
 */
public class bankServer {
	/**
	 * @brief main function that will do the server hundling
	 * @param args
	 */
	public static void main(String args[]) {
		if (args.length != 3) {
			System.exit(0);
		}
		System.out.println(args[0]);
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IBManager EBServer = new BManager(args[0], args[1], args[2]);
			Naming.rebind(name, EBServer);
			System.out.println("- EasyBookingServer '" + name + "' active and waiting...");
            System.in.read();	
		} catch (Exception e) {
			System.err.println("$ EasyBookingServer exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}

