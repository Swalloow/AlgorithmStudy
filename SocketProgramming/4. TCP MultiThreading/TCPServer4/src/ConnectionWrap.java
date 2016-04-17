import java.net.Socket;

public class ConnectionWrap implements Runnable {
	
	private Socket socket = null;
	
	public ConnectionWrap(Socket client) {
		this.socket = client;
	}

	@Override
	public void run() {
		
	}
}
