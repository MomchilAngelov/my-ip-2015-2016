package tinker;

public class Login extends Command{
	public void execute(String[] command){
		add(command[0]);
		addToHash(command[0]);
		System.out.println("ok");
	}
}
