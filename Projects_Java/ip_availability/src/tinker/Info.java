package tinker;

public class Info extends Command {
	public void execute(String[] command){
		if (command.length == 3 && command[1].equals("info")){
			if (here(command[0])){
				String output = "ok:"+command[2];
				if(student.contains(command[2])){
					output += ":true";
				} else {
					output += ":false";
				}
				if(students2count.get(command[2]) == null){
					output += ":0";
				} else {
					int number = students2count.get(command[2]);
					output += ":" + number;
				} 
				System.out.println(output);
			} else {
				System.out.println("error:notlogged");
			}
		} else {
			System.out.println("Invalid input");
		}
	}
}