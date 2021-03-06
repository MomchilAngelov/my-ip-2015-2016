package socketWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Server {
	private boolean running;
	private final int port;
	private Parser parser;
	private final List<ClientHandler> clients = new LinkedList<ClientHandler>();
	
	public Server(int port){
		this.port = port;
		this.parser = new Parser();
	}
	
	public void startServer() throws IOException{
		setRunning();
		final ServerSocket serverSocket = new ServerSocket(port);
		
		while(isRunning()){
			final Socket socket = serverSocket.accept();
			final ClientHandler client = new ClientHandler(socket,this);
			clients.add(client);
			new Thread(client).start();
		}

		serverSocket.close();
	}
	
	private synchronized void setRunning(){
		if(running){
			throw new IllegalStateException("Already Running");
		}
		running = true;
	}
	
	public synchronized String execute(String command, Server server, Socket socket){
		String responce = this.parser.parse(command, server, socket);
		return responce;
	}
	
	public synchronized boolean isRunning(){
		return running;
	}
	
	public synchronized void stopServer() throws IOException{
		running = false;
		
		for(ClientHandler next: clients){
			next.stopClient();
		}
	}
	
	public void onClientStopped (ClientHandler clientHandler){
		clients.remove(clientHandler);
	}
	
}
