import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLauncher {

	public static void main(String[] args) {
		Socket client = null;					//client와 연결되는 소켓
		ServerSocket server = null;				//접속을 받아들이는 server socket
		int port = 10789;						//local port 번호
		
		try {
			server = new ServerSocket(port);	//server socket 생성
			client = server.accept();			//client로부터의 접속을 받아들임
			
			if(client!=null) {					//client가 연결된 경우, 연결상태를 출력
				System.out.println(client.toString());
			}
			
			client.close();						//client socket을 닫음
			server.close();						//server socket을 닫음
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {								//접속 중 예외 발생 시 연결을 종료
			if(client!=null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(server!=null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
