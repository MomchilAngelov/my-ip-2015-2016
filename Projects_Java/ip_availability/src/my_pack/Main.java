package my_pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Parse in a separate method
//Commands in separate classes that extend some basic one


public class Main {
	
	public static void main(String[] args){
		List<String> currently_loged_users = new ArrayList<String>();
		Map <String, Integer> mapper = new HashMap<String, Integer>(); 
	
		final Scanner in = new Scanner(System.in);
		
		while(true){
			int my_val = 0;
			System.out.println("Username:command");
			final String name = in.next();
			String[] full_string = name.split(":");
			if(!(full_string.length > 1)){
				System.out.println("Invalid input");
				continue;
			}
			
			if(full_string[1].equals("shutdown")){
				break;
			}
			
			//add to hashmap
			if(mapper.containsKey(full_string[0])){
				int value = mapper.get(full_string[0]);
				mapper.put(full_string[0], value+1);
			} else {
				mapper.put(full_string[0], 1);
			}
			
			if(full_string[1].equals("login")){
				my_val = 1;
				System.out.println("ok");
				currently_loged_users.add(full_string[0]);
			}
			if(full_string[1].equals("logout")){
				my_val = 1;
				if(currently_loged_users.contains(full_string[0])){
					System.out.println("ok");
					currently_loged_users.remove(full_string[0]);
					continue;
				}
				System.out.println("error:notlogged");
			}
			if( (full_string[1].equals("info"))&& (full_string.length == 3) ){
				my_val = 1;
				if(currently_loged_users.contains(full_string[0])){
					//System.out.println("Stuff works!");
					if(currently_loged_users.contains(full_string[0])){
						String myString = "ok:" + full_string[2];
						if(currently_loged_users.contains(full_string[2])){
							myString += ":true:";
							int val = mapper.get(full_string[2]);
							myString += val;
						} else {
							myString += ":false:";
							int val = mapper.get(full_string[2]);
							myString += val;
						}
						System.out.println(myString);
					}
				} else {
					System.out.println("error:notlogged");
				}
			}
			
			if(full_string[1].equals("listavailable")){
				my_val = 1;
				if(currently_loged_users.contains(full_string[0])){
					System.out.print("ok");
					for (String element : currently_loged_users) {
						System.out.print(":"+element);
					}
					System.out.print("\n");
				} else {
					System.out.println("error:notlogged");
				}
				continue;
			}
			
			if(my_val == 0){
				System.out.println("error:unknowncommand");
			}
		}
		
		
		in.close();
		
		System.out.println("You have exited my little applet!");
	}
	
	
			
}
