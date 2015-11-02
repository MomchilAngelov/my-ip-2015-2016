package mythread;

public class Main {
	public static void main (String args[]){
		int value = 0;	
		(new myThread(1)).start();
		(new myThread(2)).start();
		(new myThread(3)).start();
		(new myThread(4)).start();
	}
}
