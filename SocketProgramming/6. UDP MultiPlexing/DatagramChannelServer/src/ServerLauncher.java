import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ServerLauncher {
	public void main (String []argv){
		//		SocketChannel과 달라진 점은 DatagramChannel을 사용한다는 것
		int port = 10789;
		String IP = "127.0.0.1";
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		DatagramChannel datagramChannel = null;
		CharBuffer charBuffer = null;
		Charset charSet = Charset.defaultCharset();
		CharsetDecoder decoder = charSet.newDecoder();

		try {
			// StandardProtocolFamily.INET : IPv4
			// StandardProtocolFamily.INET6: IPv6
			datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
			if(datagramChannel.isOpen())
				System.out.println("DatagramChannel is opened!");
			datagramChannel.setOption(StandardSocketOptions.SO_RCVBUF, 1024);
			datagramChannel.setOption(StandardSocketOptions.SO_SNDBUF, 1024);
			datagramChannel.bind(new InetSocketAddress(IP, port));

			// 무한 루프를 돌며, client로부터 data를 송수신하는데,
			// 이 예제에서는 datagramChannel을 비연결지향으로 설정했기 때문에
			// 송수신 메소드는 send()/receive()이다.
			// 연결 지향은 다음 예제에서 살펴보도록 하겠다.
			while (true) {
				// client로부터의 data를 수신하고,
				// SocketAddress class로 client 정보를 저장한다.
				SocketAddress clientAddress = datagramChannel.receive(buffer);
				buffer.limit(buffer.position());
				buffer.position(0);
				charBuffer = decoder.decode(buffer);
				String msg = charBuffer.toString();
				System.out.println("from client : " + msg);

				// clientAddress에는 data를 보냈던 client의 정보가 담겨있다.
				datagramChannel.send(ByteBuffer.wrap(msg.getBytes()), clientAddress);
				buffer.clear();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
