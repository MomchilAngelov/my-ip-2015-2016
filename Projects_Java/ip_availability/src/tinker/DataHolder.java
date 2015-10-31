package tinker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHolder {
	static List<String> student = new ArrayList<String>();
	static Map<String, Integer> students2count = new HashMap<String, Integer>();
	
	boolean is_here(String student1){
		return student.contains(student1);
	}
	
	void add(String student1){
		student.add(student1);
	}
	
	boolean delete(String student1){
		if(student.contains(student1)){
			student.remove(student1);
			return true;
		}
		return false;
	}
	
	int count(String student1){
			int value = students2count.containsKey(student1) ? students2count.get(student1) : 0;
			return value;
	}
	
	void addToHash(String student1){
		if (students2count.containsKey(student1)){
			students2count.put(student1, students2count.get(student1) + 1);
		} else {
			students2count.put(student1, 1);
		}
	}
}
