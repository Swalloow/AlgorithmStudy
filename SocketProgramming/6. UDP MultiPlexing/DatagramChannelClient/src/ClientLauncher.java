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
		int serverPORT = 10789;
		String serverIP = "127.0.0.1";
		CharBuffer charBuffer = null;
		Charset charSet = Charset.defaultCharset();
		CharsetDecoder decoder = charSet.newDecoder();
		DatagramChannel datagramChannel = null;
		BufferedReader bufferedReader = null;
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

		try {
			datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			if (datagramChannel.isOpen()) {
				datagramChannel.setOption(StandardSocketOptions.SO_RCVBUF, 1024);
				datagramChannel.setOption(StandardSocketOptions.SO_SNDBUF, 1024);
				
				while (true) {
					System.out.print("> ");
					String msg = bufferedReader.readLine();
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
