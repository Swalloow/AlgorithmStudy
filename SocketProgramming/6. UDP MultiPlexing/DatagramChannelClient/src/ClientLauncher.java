import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ClientLauncher {

	public static void main(String[] args) {
		//********************************************
		// SocketChannel의 예제에서와 달라진 점은 SocketChannel 대신
		// DatagramChannel class를 사용한다.
		// ByteBuffer : Channel 관련 class들의 입출력 buffer
		// CharBuffer : 문자(char)용 buffer
		// Charset : 16bit 유니코드와 바이트 sequence를 매핑 시킨다.
		// CharsetDecoder : byte sequence를 16bit 유니코드 sequence로 변환 한다.
		//********************************************
		int serverPORT = 10789;
		String serverIP = "127.0.0.1";
		CharBuffer charBuffer = null;
		Charset charSet = Charset.defaultCharset();
		CharsetDecoder decoder = charSet.newDecoder();
		DatagramChannel datagramChannel = null;
		BufferedReader bufferedReader = null;
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		
		try {
			// datagramChannel을 IPv4로 생성하고, 키보드 입력 객체를 생성한다.
			datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			
			if (datagramChannel.isOpen()) {
				// channel이 정상적으로 open 됐다면,
				// 입출력 버퍼를 설정한다.
				datagramChannel.setOption(StandardSocketOptions.SO_RCVBUF, 1024);
				datagramChannel.setOption(StandardSocketOptions.SO_SNDBUF, 1024);
				
				// 무한 루프를 돌며, 입출력을 한다.
				// 방법은 server 측과 다르지 않다.
				while (true) {
					System.out.print("> ");
					String msg = bufferedReader.readLine();
			// 주의 할 점은 보내는 패킷에 자신(client)의 주소 정보를 입력해 주는 것이다.
			// 이 주소를 입력함으로써, server측에서 패킷에 대한 적절한 응답을 할 수 있다.
			datagramChannel.send(ByteBuffer.wrap(msg.getBytes()), new InetSocketAddress(serverIP, 
					serverPORT));
					if (msg != null) {
						msg = null;
						datagramChannel.receive(buffer);
						buffer.limit(buffer.position());
						buffer.position(0);
						charBuffer = decoder.decode(buffer);
						System.out.println("from server : " + charBuffer.toString());
						buffer.clear();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
