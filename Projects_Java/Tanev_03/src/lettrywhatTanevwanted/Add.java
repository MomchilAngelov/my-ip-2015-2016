package lettrywhatTanevwanted;

public class Add extends Basic_Calculator{
	public int execute(String[] args){
		return Integer.valueOf(args[1]) + Integer.valueOf(args[2]);
	}
}