package tinker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHolder {
	protected List<String> student = new ArrayList<String>();
	protected Map<String, Integer> students2count = new HashMap<String, Integer>();
	
	public boolean is_here(String student1){
		return student.contains(student1);
	}
	
	public void add(String student1){
		student.add(student1);
	}
	
	public boolean delete(String student1){
		return student.remove(student1);
	}
	
	public int count(String student1){
			return students2count.containsKey(student1) ? students2count.get(student1) : 0;
			
	}
	
	public void addToHash(String student1){
	//	int k = count(student1) > 0  ? students2count.put(student1, count(student1) + 1) : students2count.put(student1, 1);
		students2count.put(student1, count(student1) + 1);
	}
}
