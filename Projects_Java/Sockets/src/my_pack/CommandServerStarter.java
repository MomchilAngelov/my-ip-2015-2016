package my_pack;

import java.io.IOException;

public class CommandServerStarter {
	private static final int SERVER_PORT = 31111;

	public static void main(String[] args) throws IOException {
		final CommandServer server = new CommandServer(SERVER_PORT);
		server.startServer();
	}
}
