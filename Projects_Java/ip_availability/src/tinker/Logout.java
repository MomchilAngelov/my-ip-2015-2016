package tinker;

public class Logout extends Command{
	public void execute(String[] command){
		if(is_here(command[0])){
			delete(command[0]);
			System.out.println("ok");
		} else {
			System.out.println("error:notlogged");
		}
	}
}
