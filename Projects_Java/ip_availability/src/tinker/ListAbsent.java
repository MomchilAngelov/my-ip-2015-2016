package tinker;


public class ListAbsent extends Command {

	ListAbsent(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	
	public String execute(String[] command){
		if(data.isHere(command[0])){
			String string = "ok";
			for(String student : data.students2count.keySet()){
				if(!data.isHere(student)){
					string += ":" + student;
				}
			}
			return string;
		} else {
			return "error:notlogged";
		}
	}
}
