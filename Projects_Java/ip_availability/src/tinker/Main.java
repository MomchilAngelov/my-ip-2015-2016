package tinker;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args){
		System.out.println("Starting!");
		Parser parse = new Parser();
		final Scanner in = new Scanner(System.in);
		
		while(true){
			final String name = in.next();
			if(name.equals("close")){
				break;
			}
			parse.parse(name);
		}
		
		in.close();
		System.out.println("Exited my app!");
	}
}
