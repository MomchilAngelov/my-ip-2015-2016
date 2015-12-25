package my_pack;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class User implements Runnable {
	private static final String COMMAND_STOP_SERVER = "stopServer";

	private final Socket socket;

	private final CommandServer commandServer;

	public User(CommandServer commandServer, Socket socket) {
		this.socket = socket;
		this.commandServer = commandServer;
	}
	
	@Override
	public void run() {
		try {
			final PrintStream out = 
				new PrintStream(socket.getOutputStream());
			final Scanner scanner =
				new Scanner(socket.getInputStream());
			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				if (COMMAND_STOP_SERVER.equals(line)) {
					commandServer.stopServer();
					break;
				}
				
				String output = commandServer.execute(line);
				out.println(output);
			}
			scanner.close();
			out.close();
		} catch (IOException e) {
			// TODO check if closed before printing error
			e.printStackTrace();
		} finally {
			commandServer.onClientStopped(this);
		}
	}
	
	public void stopClient() throws IOException {
		socket.close();
		// TODO add variable closed
	}
}
