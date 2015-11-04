package tinker;

public class Logout extends Command{
	public void execute(String[] command){
		if(DataHolder.is_here(command[0])){
			while(DataHolder.is_here(command[0])){
				DataHolder.delete(command[0]);
			}
			System.out.println("ok");
		} else {
			System.out.println("error:notlogged");
		}
	}
}
