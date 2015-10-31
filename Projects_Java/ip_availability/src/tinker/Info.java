package tinker;

public class Info extends Command {
	public void execute(String[] command){
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
	}
}