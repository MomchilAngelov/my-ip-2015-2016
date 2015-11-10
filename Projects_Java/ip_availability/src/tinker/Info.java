package tinker;

public class Info extends Command {
	Info(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public String execute(String[] command){
		if (command.length == 3 && command[1].equals("info")){
			if (data.is_here(command[0])){
				String output = "ok:"+command[2];
				if(data.is_here(command[2])){
					output += ":true:";
				} else {
					output += ":false:";
				}
				output += data.count(command[2]);
				return output;
			} else {
				return "error:notlogged";
			}
		} else {
			return "Invalid Input";
		}
	}
}
