package tinker;

public class Parser extends Command{
	Parser(){
		Command.commander.put("login", new Login());
		Command.commander.put("logout", new Logout());
		Command.commander.put("info", new Info());
		Command.commander.put("listavailable", new ListAvailable());
	}
	public void parse(String command){
		//for (Map.Entry<String, Command> entry : commander.entrySet()) {
		//    System.out.println(entry);
		//}
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
