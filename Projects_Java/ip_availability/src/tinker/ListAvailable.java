package tinker;

public class ListAvailable extends Command {
	public void execute(String[] command){
		if(DataHolder.is_here(command[0])){
			for (String element : DataHolder.student) {
				System.out.println(element);
			}
		} else {
			System.out.println("error:notlogged");
		}
	}
}
