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
	private final Map<String, User> users = new HashMap<String, User>();
	
	public Server(int port){
		this.port = port;
		parser = new Parser();
	}
	
	public void startServer() throws IOException{
		setRunning();
		final ServerSocket serverSocket = new ServerSocket(port);
		
		while(isRunning()){
			final Socket socket = serverSocket.accept();
			final ClientHandler client = new ClientHandler(socket,this);
			clients.add(client);
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
	
	public synchronized String execute(String command){
		String responce = this.parser.parse(command);
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
	
	public void putUser(String name, User user){
		users.put(name, user);
	}
	
	public void removeUser(String name){
		users.remove(name);
	}
	
	public User getUser(String name){
		return users.get(name);
	}
}
