package tinker;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args){
		System.out.println("Starting!");
		Parser parse = new Parser();
		Command.commander.put("login", new Login());
		Command.commander.put("logout", new Logout());
		Command.commander.put("info", new Info());
		Command.commander.put("listavailable", new ListAvailable());
		
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
