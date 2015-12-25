package socketWork;

import java.net.Socket;

public class Command {
	public String execute(String[] command, Server server, Socket socket){
		return "null";
	};
	protected DataHolder data;
	Command (DataHolder data){
		this.data = data;
	}
}
