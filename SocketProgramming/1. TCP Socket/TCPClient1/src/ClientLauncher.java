import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientLauncher {

	public static void main(String[] args) {
		int serverPort = 10789;							//연결할 local port
		String serverIP = "127.0.0.1";					//server의 IP주소
		Socket server = null;							//server socket
		
		try {
			server = new Socket(serverIP, serverPort);	//server socket에 연결
			
			if(server!=null) {							//연결되면 접속상태 출력
				System.out.println(server.toString());
			}
			
			server.close();								//접속종료
			
		} catch (UnknownHostException e) {				//접속 중 예외 발생 시 catch
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {										//접속 중 예외 발생 시 연결을 종료
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
