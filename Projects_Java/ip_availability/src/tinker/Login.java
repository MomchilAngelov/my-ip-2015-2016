package tinker;

public class Login extends Command{
	Login(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public void execute(String[] command){
		data.add(command[0]);
		data.addToHash(command[0]);
		System.out.println("ok");
	}
}
