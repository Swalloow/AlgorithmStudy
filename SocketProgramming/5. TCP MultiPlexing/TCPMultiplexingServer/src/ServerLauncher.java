import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ServerLauncher {

	//************************************
	// ServerSocketChannel은 기본적으로 ServerSocket과 동일한 동작을 한다.
	// serverSocket과의 차이점은 non-blocking mode로 동작이 가능하다는 것이다.
	// Channel 관련 class들은 생성자를 통해 만들어지지 않고, open() 이라는 정적 메소드를 이용한다.
	// bind를 위해 socket() 메소드를 제공한다.
	// non-blocking mode의 핵심이 되는 Selector class는
	// 등록된 channel들이 발생시킨 event를 적절한 핸들러로 분기시켜주는 역할을 한다.
	//************************************
	
	public static void main(String[] args) {
		ServerSocketChannel serverSocketChannel = null;
		SocketChannel client = null;
		ServerSocket serverSocket = null;
		Selector selector = null;
		int port = 10789;
		String ip = "127.0.0.1";

		try {
			// Server Initializing
			// selector/serverSocketChannel 생성.
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			// non-blocking mode로 설정.
			serverSocketChannel.configureBlocking(false);
			// address binding.
			serverSocket = serverSocketChannel.socket();
			serverSocket.bind(new InetSocketAddress(ip, port));
			// selector에 channel과 event를 등록시켜준다.
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("now expecting Connection...");

			// 무한루프를 돌며, client의 접속을 기다린다...
			while (true) {
				// selector.select()는 일종의 blocking 메소드이다.
				// client의 연결이 들어오면 SelectionKey 집합이 생성된다.
				// select() 메소드는 Selectionkey 집합이 생성될 때 까지 대기하는 메소드이다.
				// select() 결과가 존재하면, blocking이 끝나고, 다음 명령을 수행한다.
				selector.select();
				// SelectionKey 집합 만큼 반복.
				Iterator iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey key = (SelectionKey) iterator.next();

					// 등록한 Option을 체크해서 해당 이벤트를 핸들링한다.
					if (key.isAcceptable()) {
						client = ((ServerSocketChannel) key.channel()).accept();
						client.configureBlocking(false);
						client.register(selector, SelectionKey.OP_READ);
						System.out.println(client.toString());
					}
					// Selectionkey 집합은 이벤트가 발생했을 때, 생성되기 때문에, 사용한 key는 반드시 버려준다.
					iterator.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
