package s;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args){
		String time = getCurrentTimeStamp();
		System.out.println(time);
	}
	
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-d'T'HH_mm_ss.SSSZ");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
}
