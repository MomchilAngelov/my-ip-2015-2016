package testpack;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class CommandHandlerExample {
	private static Map<String, CommandHandler> Handlers = 
			new HashMap<String, CommandHandler>();
	public static void main(String[] args){
		Handlers.put("sum", new SumCommandHandle());
		System.out.println("Enter command");
		final Scanner in = new Scanner(System.in);
		final String command = in.next();
		final CommandHandler handler = parse(command);
		final int result = handler.execute(args);
		System.out.println("Result: "+ result);
		in.close();
	}
	private static CommandHandler parse(String command){
		final String[] split = command.split(":");
		final CommandHandler result = Handlers.get(split[0]);
		if (result == null){
			throw new IllegalArgumentException("Unknown command" + command);
		}
		
		return result;
	}
	public int run(){
		return 0;
	}
}