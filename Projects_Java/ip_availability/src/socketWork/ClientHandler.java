package socketWork;

import tinker.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
	private final static String SHUTUP = "stopServer";
	private final Socket socket;
	private final Server server;
	
	ClientHandler(Socket socket, Server server){
		this.socket = socket;
		this.server = server;	
	}
	
	public void run() {
		try{
			final PrintStream out = new PrintStream(socket.getOutputStream());
			final Scanner scanner = new Scanner(socket.getInputStream());
			Parser parser = new Parser();
			
			while(scanner.hasNextLine()){
				final String line = scanner.nextLine();
				if(SHUTUP.equals(line)){
					server.stopServer();
					break;
				}
				String mystr = parser.parse(line);
				out.println(mystr);
			}
			
			scanner.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			server.onClientStopped(this);
		}
	}

	public void stopClient() throws IOException {
		// TODO Auto-generated method stub
		socket.close();
	}

}
