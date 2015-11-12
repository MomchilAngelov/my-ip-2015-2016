package tinker;

import java.util.Map;
import java.util.Map.Entry;

public class Info extends Command {
	Info(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public String execute(String[] command){
		if (command.length == 3 && command[1].equals("info")){
			if (data.isHere(command[0])){
				String output = "ok:"+command[2];
				if(data.isHere(command[2])){
					output += ":true:";
				} else {
					output += ":false:";
				}
				output += data.users.get(command[2]).getTimesInClass().toString();
				
				Map<String, String> myMap = data.users.get(command[2]).getMap();
				for( Entry<String, String> entry : myMap.entrySet()){
					output += ":" + entry.getKey() + ":" + entry.getValue();
				}
				return output;
			} else {
				return "error:notlogged";
			}
		} else {
			return "Invalid Input";
		}
	}
}
