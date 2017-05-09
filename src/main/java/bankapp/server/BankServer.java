package bankapp.server;

import java.rmi.Naming;


public class bankServer {
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
			System.out.println("- BankServer '" + name + "' active and waiting...");
            System.in.read();	
		} catch (Exception e) {
			System.err.println("$ BankServer exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}

