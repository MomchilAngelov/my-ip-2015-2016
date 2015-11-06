package tinker;

public class Gay extends Command{
	public void execute(String[] command){
		if(DataHolder.is_here(command[0])){
			if(command[0].equals("pepo")){
				System.out.println("is gay!");
			} else {
				System.out.println("is not gay!");
			}
		} else {
			System.out.println("error:notlogged");
		}
	}
}
