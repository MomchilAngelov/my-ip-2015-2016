package socketWork;

import java.net.Socket;

public class Login extends Command{
	Login(DataHolder data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public String execute(String[] command, Server server, Socket socket){
		if(data.users.containsKey(command[0])){
			if(data.users.get(command[0]).isHere()){
				return "";
			} else {
				data.users.get(command[0]).imIn();
				data.users.get(command[0]).increaseTimesInClass();
				return "ok";
			}
		}
		data.createUser(command[0],server,socket);
		data.users.get(command[0]).imIn();
		data.users.get(command[0]).increaseTimesInClass();
		return "ok";
	}
}
