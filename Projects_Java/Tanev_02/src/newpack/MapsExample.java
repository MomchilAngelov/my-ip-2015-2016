package newpack;

import java.util.HashMap;
import java.util.Map;

public class MapsExample {
	public static void main(String[] args){
		final Map<String, Integer> nameToCountMap =
				new HashMap<String, Integer>();
		
		nameToCountMap.put("Ivan", 1);
		
		System.out.print(nameToCountMap.get("Ivan"));
		
		
	}
}
