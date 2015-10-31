package inheritance_example;

public class Wolf extends Animal{
	static int count = 0;
	
	public Wolf(String name){
		this.name = name;
		count += 1;
	}
	
	public void talk(){
		System.out.println("Howlllllll");
	}
	
	public void fight(){
		System.out.println("-5 hp faggot");
	}
	
	public Wolf mate(Wolf other){
		String name = this.name + other.name + count;
		Wolf offspring = new Wolf(name);
		return offspring;
	}
}
