package my_pack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CommandServer {
	private final int port;
	private boolean running;
	private final Map<String,User> testclients =
		Collections.synchronizedMap(
			new HashMap<String, User>());
	private final List<User> clients =
			Collections.synchronizedList(
				new LinkedList<User>());

	public CommandServer(int port) {
		this.port = port;
	}

	public void startServer() throws IOException {
		setRunning();
		final ServerSocket serverSocket =
			new ServerSocket(port);
		
		// to synchronize access to the variable 'running'
		while(isRunning()) {
			final Socket socket = serverSocket.accept();
			
			final User client =
				new User(this, socket);
			//clients.add(client);
			new Thread(client).start();
		}
		serverSocket.close();
	}

	private synchronized void setRunning() {
		if (running) {
			throw new IllegalStateException("Already running");
		}
		running = true;
	}
	
	public synchronized boolean isRunning() {
		return running;
	}
	
	public synchronized String execute(String commands){
		return commands;
	}

	public synchronized void stopServer() throws IOException {
		running = false;
		
		for (User next : clients) {
			next.stopClient();
		}
	}

	public void onClientStopped(User user) {                             
		clients.remove(user);
	}
}
