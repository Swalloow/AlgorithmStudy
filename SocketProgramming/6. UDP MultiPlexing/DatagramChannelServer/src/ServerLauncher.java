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
	
	public static void main(String []args){
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

			while (true) {
				SocketAddress clientAddress = datagramChannel.receive(buffer);
				buffer.limit(buffer.position());
				buffer.position(0);
				charBuffer = decoder.decode(buffer);
				String msg = charBuffer.toString();
				System.out.println("from client : " + msg);

				datagramChannel.send(ByteBuffer.wrap(msg.getBytes()), clientAddress);
				buffer.clear();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
