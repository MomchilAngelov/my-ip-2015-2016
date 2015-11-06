package socketWork;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
	private final static String SHUTUP = "stopServer";
	private final Socket socket;
	
	ClientHandler(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
	try{
		final PrintStream out = new PrintStream(socket.getOutputStream());
		final Scanner scanner = new Scanner(socket.getInputStream());
		
		while(scanner.hasNextLine()){
			final String line = scanner.nextLine();
			if(SHUTUP.equals(line)){
				break;
			}
			out.println(line);
		}
		
		scanner.close();
		out.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

}
