package tinker;

public class Logout extends Command{
	Logout(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public String execute(String[] command){
		if(data.isHere(command[0])){
			while(data.isHere(command[0])){
				data.delete(command[0]);
			}
			return "ok";
		} else {
			return "error:notlogged";
		}
	}
}
