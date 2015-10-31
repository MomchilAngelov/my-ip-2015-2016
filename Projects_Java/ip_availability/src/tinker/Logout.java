package tinker;

public class Logout extends Command{
	public void execute(String[] command){
		student.remove(command[0]);
	}
}
