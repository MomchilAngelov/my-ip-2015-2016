package onepager;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Student{
	String name;
	int age;
	boolean is_in = false;
	boolean been_there = false;
	LocalDateTime time_in;
	LocalDateTime time_out;
	LocalDateTime time_there;
	long minutes;
	long hours;
	long seconds;
	
	public Student(String name){
		this.name = name;
	}
	
	public void info(){
		Map<String, String> myMap = new HashMap<String, String>();
		if(been_there){
			myMap.put("Entered class: ", time_in.toString());
			if(is_in){
				myMap.put("Status for " + name + " age of " + age + " is: ","In Class");
			} else {
				myMap.put("Left class: ", time_out.toString());
				myMap.put("Status for " + name + " age of " + age + " is: ","Elvis has left the building");
				seconds = ChronoUnit.SECONDS.between(time_in, time_out);
				minutes = ChronoUnit.MINUTES.between(time_in, time_out);
				hours = ChronoUnit.HOURS.between(time_in, time_out);
				myMap.put("Time there: ",hours+"h " + minutes + "m " + seconds + "s");
			}
		} else {
			myMap.put("Status for " + name + " age of " + age + " is: ", "The student was non-precent in class!");
		}
		for (Map.Entry<String, String> entry : myMap.entrySet()) {
		    System.out.printf("%s%s \n",entry.getKey(), entry.getValue());
		}
	}
	
	public void in(){
		is_in = true;
		been_there = true;
		time_in = LocalDateTime.now();
	}
	
	public void out(){
		is_in = false;
		time_out = LocalDateTime.now();
	}
	
	public void set_name(String name){
		this.name = name;
	}
	
	public void set_age(int age){
		this.age = age;
	}	
}
