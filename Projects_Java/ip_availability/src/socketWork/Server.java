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
		setRunning();
		final ServerSocket serverSocket = new ServerSocket(port);
		
		while(isRunning()){
			final Socket socket = serverSocket.accept();
			final ClientHandler client = new ClientHandler(socket,this);
			client.run();
		}

		serverSocket.close();
	}
	
	private synchronized void setRunning(){
		if(running){
			throw new IllegalStateException("Already Running");
		}
		running = true;
	}
	
	public synchronized boolean isRunning(){
		return running;
	}
	
	public synchronized void stopServer(){
		running = false;
	}
}
