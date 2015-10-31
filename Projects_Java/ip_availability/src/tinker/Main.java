package tinker;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args){
		System.out.println("Starting!");
		Command commander = new Command();
		Parser parse = new Parser();
		commander.commander.put("login", new Login());
		commander.commander.put("logout", new Logout());
		commander.commander.put("info", new Info());
		commander.commander.put("listavailable", new ListAvailable());
		
		final Scanner in = new Scanner(System.in);
		
		while(true){
			final String name = in.next();
			if(name.equals("close")){
				break;
			}
			parse.parse(name);
			//All in the parse!
		}
		
		in.close();
		System.out.println("Exited my app!");
	}
}
