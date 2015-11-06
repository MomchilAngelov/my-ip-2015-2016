package socketWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private boolean running;
	private final int port;
	
	public Server(int port){
		this.port = port;
	}
	
	public void startServer() throws IOException{
		running = true;
		final ServerSocket serverSocket = new ServerSocket(port);
		
		while(running){
			final Socket socket = serverSocket.accept();
			final ClientHandler client = new ClientHandler(socket,this);
			client.run();
		}

		serverSocket.close();
	}
	
	public void stopServer(){
		running = false;
	}
}
