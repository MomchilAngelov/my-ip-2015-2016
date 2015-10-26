package inheritance_example;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args){
		Map <String, Wolf> info = new HashMap<String, Wolf>();
		Animal ameba = new Animal();
		Wolf sharo = new Wolf("sharo");
		Wolf shara = new Wolf("shara");
		info.put("sharo", sharo);
		info.put("shara", shara);
		System.out.println(Wolf.count);
		
		ameba.talk();
		sharo.talk();
		ameba.fight();
		sharo.fight();
		//ameba.mate();
		info.put("offspring1",sharo.mate(shara));
		info.put("offspring2",sharo.mate(shara));
		info.put("offspring3",sharo.mate(shara));
		System.out.println(Wolf.count);
		
		for (Map.Entry<String, Wolf> entry : info.entrySet()) {
			System.out.println(entry);
		}
	}
}
