package mythread;

public class myThread extends Thread{
	int i;
	myThread(int number){
		i = number;
	}
	public void run(){
		System.out.println("Hello from thread " + i);
	}
}
