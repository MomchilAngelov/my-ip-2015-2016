package socketWork;

import java.util.Map.Entry;

public class ListAvailable extends Command {
	ListAvailable(DataHolder data) {
		super(data);
	}

	public String execute(String[] command){
		String myStr = "ok";
		if(data.isHere(command[0])){
			for (Entry<String, User> entry: data.users.entrySet()) {
				if (entry.getValue().isHere()){
					myStr += ":" + entry.getKey();
				}
			}
			return myStr;
		} else {
			return "error:notlogged";
		}
	}
}
