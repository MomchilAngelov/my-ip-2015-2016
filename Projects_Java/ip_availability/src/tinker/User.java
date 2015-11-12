package tinker;

import java.util.Map;
import java.util.Date;
import java.util.LinkedHashMap;

public class User {
	private String name;
	private boolean isIn;
	private Integer timesInClass = 0;
	private Date lastEntry; 
	private Map<String, String> dates = new LinkedHashMap<String, String>();
	
	User(String name){
		this.name = name;
	}
	
	public void increaseTimesInClass(){
		timesInClass++;
	}
	
	public Integer getTimesInClass(){
		return this.timesInClass;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void imIn(){
		Date date = new Date();
		dates.put(date.toString(), "");
		this.lastEntry = date;
		this.isIn = true;
	}
	
	public void imOut(){
		Date date = new Date();
		dates.put(lastEntry.toString(), date.toString());
		this.isIn = false;
	}
	
	public boolean isHere(){
		return this.isIn;
	}
	
	public Map<String, String> getMap(){
		return this.dates;
	}
}
