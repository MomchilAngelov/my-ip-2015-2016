package socketWork;

import java.util.Map.Entry;

public class ListAbsent extends Command {

	ListAbsent(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	
	public String execute(String[] command){
		if(data.isHere(command[0])){
			String string = "ok";
			for(Entry <String, User> entry : data.users.entrySet()){
				if(!data.isHere(entry.getKey())){
					string += ":" + entry.getKey();
				}
			}
			return string;
		} else {
			return "error:notlogged";
		}
	}
}
