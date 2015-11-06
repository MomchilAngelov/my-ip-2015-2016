package tinker;

public class Info extends Command {
	Info(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public void execute(String[] command){
		if (command.length == 3 && command[1].equals("info")){
			if (data.is_here(command[0])){
				String output = "ok:"+command[2];
				if(data.is_here(command[2])){
					output += ":true:";
				} else {
					output += ":false:";
				}
				output += data.count(command[2]);
				System.out.println(output);
			} else {
				System.out.println("error:notlogged");
			}
		} else {
			System.out.println("Invalid input");
		}
	}
}
