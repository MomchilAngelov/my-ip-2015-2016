package lettrywhatTanevwanted;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static String[] parse(String command){
		String[] numbers = new String[3];
		if(command.matches("\\w+\\:\\d+:\\d+")){
			System.out.println("Valid format");
			numbers = command.split(":");
			return numbers;
		}
		numbers[0] = "Invalid";
		
		return numbers;
	}
	
	
	public static void main(String[] args){
		Map <String, Object> mapper = new HashMap<String, Object>(); 
		mapper.put("sum", new Add());
		mapper.put("sub", new Sub());
		mapper.put("mul", new Mul());
		mapper.put("div", new Div());
		String[] numbers_from_command;
		
		System.out.println("command:value1:value2");
		final Scanner in = new Scanner(System.in);
		
		while(true){
			int result;
			final String name = in.next();
			if("close".equals(name)){
				break;
			}
			numbers_from_command = parse(name);
			if(numbers_from_command[0].equals("Invalid")){
				continue;
			}
			if(mapper.get(numbers_from_command[0]) == null){
				continue;
			}
			result = ((Basic_Calculator) mapper.get(numbers_from_command[0])).execute(numbers_from_command);
			System.out.println(result);
		}
		
		
		in.close();
		
		System.out.println("You have exited my little applet!");
	}
}
