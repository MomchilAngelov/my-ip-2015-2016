package tinker;

public class Logout extends Command{
	public void execute(String[] command){
		if(here(command[0])){
			student.remove(command[0]);
			System.out.println("ok");
		} else {
			System.out.println("error:notlogged");
		}
	}
}
