package tinker;

public class ListAvailable extends Command {
	ListAvailable(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public String execute(String[] command){
		String myStr = "";
		if(data.isHere(command[0])){
			for (String element : data.student) {
				myStr += element+"\n";
			}
			return myStr;
		} else {
			return "error:notlogged";
		}
	}
}
