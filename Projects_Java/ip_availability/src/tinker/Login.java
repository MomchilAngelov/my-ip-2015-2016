package tinker;

public class Login extends Command{
	public void execute(String[] command){
	//	System.out.println("Login called again!");
		student.add(command[0]);
		if (students2count.containsKey(command[0])){
			students2count.put(command[0], students2count.get(command[0]) + 1);
		} else {
			students2count.put(command[0], 1);
		}
	}
}
