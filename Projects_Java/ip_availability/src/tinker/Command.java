package tinker;

import java.util.HashMap;
import java.util.Map;

public class Command{
	
	static Map<String, Command> commander = new HashMap<String, Command>();
	public void execute(String[] command){};
}
