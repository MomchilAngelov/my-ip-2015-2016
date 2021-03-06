package onepager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OneInAll {
	public static void main(String[] args){
		Map<String, Student> total_info = new HashMap<String, Student>();
		Student Ivan = new Student("Ivan");
		Student Go6o = new Student("Go6o");
		Student Petar = new Student("Petar");
		
		total_info.put("Ivan", Ivan);
		total_info.put("Go6o", Go6o);
		total_info.put("Petar", Petar);
		
		System.out.println("Enter data in the format: <Student>:<command>");
		final Scanner in = new Scanner(System.in);
		while(true){
			final String student = in.next();
			if (!student.toLowerCase().contains(":")){
				if(student.equals("close")){
					break;
				}
				if(student.equals("all")){
					for (Map.Entry<String, Student> entry : total_info.entrySet()) {
					    System.out.println(entry);
					}
					continue;
				}
				System.out.println("Bad Input");
				continue;
			} 
			String[] some_info;
		//	Parser parse = new Parser();
		//	parse.parse(student);
			some_info = student.split(":");
			if(total_info.containsKey(some_info[0])){
				if( (some_info[1].equals("in")) ||(some_info[1].equals("out")) || (some_info[1].equals("info")) ){
					switch (some_info[1]){
						case "in":
							total_info.get(some_info[0]).in();
							break;
						case "out":
							total_info.get(some_info[0]).out();
							break;
						case "info":
							total_info.get(some_info[0]).info();
							break;
					}
				} else {
					System.out.println("No such command!");
				}
			} else {
				System.out.println("No such student!");
			}	
		}
		in.close();
		
		System.out.println("You have exited the app");
		
	}
}
