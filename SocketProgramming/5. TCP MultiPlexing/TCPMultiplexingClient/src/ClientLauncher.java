import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class ClientLauncher {

	// **************************************
	// client는 server에 연결한 후,read/write 동작을 수행하기 때문에
	// 이에 대한 selector를 등록해준다.
	// socketChannel은 기본적으로 Socket class와 비슷한 동작을 한다.
	// socketChannel class도 생성자를 사용하지 않고, open() 메소드를 사용한다.
	// *************************************
	
	public static void main(String[] args) {
		int serverPORT = 10789;
		String serverIP = "127.0.0.1";
		Selector selector = null;
		SocketChannel socketChannel = null;

		try {
			// Selector와 socketChannel을 생성한다.
			// socketChannel은 생성과 동시에 바인딩 해준다.(생성과 바인딩을 분리할 수도 있다.)
			selector = Selector.open();
			// 주소 바인딩을 했기 때문에 server에 연결을 하게 된다.
			socketChannel = SocketChannel.open(new InetSocketAddress(serverIP, serverPORT));
			// selector에 등록하기 위해서는 non-blocking mode로 설정해 준다.
			// selector에 socketchannel과 option을 등록한다.
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);

			if (socketChannel != null) {
				System.out.println(socketChannel.toString());
			}
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
