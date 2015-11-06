package my_pack;

import java.io.IOException;

public class EchoServerStarter {
	private static final int _SERVER_PORT = 12345;

	public static void main(String[] args) throws IOException{
		final EchoServer server = new EchoServer(_SERVER_PORT);
		server.startServer();
	}
}