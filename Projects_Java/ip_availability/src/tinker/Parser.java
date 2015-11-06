package tinker;

import java.util.HashMap;
import java.util.Map;

public class Parser{
	private Map<String, Command> commander = new HashMap<String, Command>();
	Parser(){
		DataHolder data = new DataHolder();
		commander.put("login", new Login(data));
		commander.put("logout", new Logout(data));
		commander.put("info", new Info(data));
		commander.put("listavailable", new ListAvailable(data));
	}
	
	public void parse(String command){
		if(command.contains(":")){
			String[] broken_command = command.split(":");
			if (commander.containsKey(broken_command[1])){
				commander.get(broken_command[1]).execute(broken_command);
			} else {
				System.out.println("error:nocommand");
			}
		} else {
			System.out.println("Invalid input!");
		}
	}
}
