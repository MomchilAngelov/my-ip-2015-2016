package socketWork;

import java.net.Socket;

public class Logout extends Command{
	Logout(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public String execute(String[] command, Server server, Socket socket){
		if(data.isHere(command[0])){
			while(data.isHere(command[0])){
				data.users.get(command[0]).imOut();
			}
			return "ok";
		} else {
			return "error:notlogged";
		}
	}
}
