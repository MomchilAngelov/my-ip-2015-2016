package tinker;

public class Logout extends Command{
	Logout(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public void execute(String[] command){
		if(data.is_here(command[0])){
			while(data.is_here(command[0])){
				data.delete(command[0]);
			}
			System.out.println("ok");
		} else {
			System.out.println("error:notlogged");
		}
	}
}
