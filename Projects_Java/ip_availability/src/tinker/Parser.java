package tinker;

import java.util.Map;


public class Parser extends Command{
	public void parse(String command){
		//for (Map.Entry<String, Command> entry : commander.entrySet()) {
		//    System.out.println(entry);
		//}
		if(command.contains(":")){
			String[] broken_command = command.split(":");
			boolean loged = false;
			if(student.contains(broken_command[0])){
				loged = true;
			}
			
			
			if ( (broken_command.length == 3) && (broken_command[1].equals("info")) ){
				if(loged){
					commander.get(broken_command[1]).execute(broken_command);
				} else {
					System.out.println("error:notlogged");
				}
			} else if (broken_command.length == 2){
				
				//CASE SPECIFIC!
				if("login".equals(broken_command[1])){
					commander.get(broken_command[1]).execute(broken_command);
					System.out.println("ok");
				} else {
				//If the students is loged
					if(loged){
						//if command exists
						if (commander.containsKey(broken_command[1])){
							commander.get(broken_command[1]).execute(broken_command);
							System.out.println("ok");
						} else {
							System.out.println("error:nocommand");
						}
					}else {
						System.out.println("error:notlogged");
					}
				}
			} else {
				System.out.println("Invalid input");
			}
			
		} else {
			System.out.println("Invalid input!");
		}
	}
}
