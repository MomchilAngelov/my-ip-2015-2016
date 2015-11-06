package my_pack;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EchoServer {
	private final int port;
	private boolean running;
	private final List<ClientHandler> clients = Collections.synchronizedList(new LinkedList<ClientHandler>());
	public EchoServer(int port){
		this.port = port;
	}
	
	private synchronized void setRunning(){
		if (running){
			throw new IllegalStateException("Already running");
		} else {
			running = true;
		}
	}
	
	public synchronized void stopServer() throws IOException{
		running = false;
		
		for(ClientHandler next: clients){
			next.stopClient();
		}
		
		ServerSocket.close();
		ServerSocket = null;
	}
	
	public synchronized boolean isRunning(){
		return running;
	} 
	
	public void startServer() throws IOException{
		
		setRunning();
		ServerSocket serverSocket = new ServerSocket(port);
	
		while(isRunning()){
			final Socket socket = serverSocket.accept();
			
			final ClientHandler client = new ClientHandler(this, socket);
			new Thread(client).start();
			client.run();
		}
		serverSocket.close();
	}	
}
