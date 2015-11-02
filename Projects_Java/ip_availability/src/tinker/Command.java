package tinker;

import java.util.HashMap;
import java.util.Map;

public class Command extends DataHolder{
	
	
	static Map<String, Command> commander = new HashMap<String, Command>();
	public void execute(String[] command){};
}
