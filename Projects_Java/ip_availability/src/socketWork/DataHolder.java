package socketWork;

import java.util.HashMap;
import java.util.Map;

public class DataHolder {
	protected Map<String, User> users = new HashMap<String, User>();
	
	public boolean isHere(String student1){
		if (users.containsKey(student1)){
			return users.get(student1).isHere();
		} else {
			return false;
		}
	}
	
	public void createUser(String student){
		users.put(student, new User(student));
	}
}
