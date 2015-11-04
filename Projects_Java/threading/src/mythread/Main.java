package mythread;

public class Main {
	public static void main (String args[]){
		int value = 0;	
		(new myThread(++value)).start();
		(new myThread(++value)).start();
		(new myThread(++value)).start();
		(new myThread(++value)).start();
		System.out.println(value);
	}
}
