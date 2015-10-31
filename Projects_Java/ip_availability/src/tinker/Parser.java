package tinker;

public class Parser extends Command{
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
