package tinker;

public class ListAvailable extends Command {
	public void execute(String[] command){
		if(is_here(command[0])){
			for (String element : student) {
				System.out.println(element);
			}
		} else {
			System.out.println("error:notlogged");
		}
	}
}
