package tinker;

public class ListAvailable extends Command {
	ListAvailable(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public void execute(String[] command){
		if(data.is_here(command[0])){
			for (String element : data.student) {
				System.out.println(element);
			}
		} else {
			System.out.println("error:notlogged");
		}
	}
}
