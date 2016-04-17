import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 이번 예제에서는 기초적인 threading 기법을 이용해, 입출력을 분리하는 것을 보여준다. 
 * 클라이언트 측에 서버로부터의 입력을 받아들이는 thread를 만들어 thread에서 입력을 받아들이고, 원래의 프로세스에서는 서버로의 출력을 담당하게 된다. 
 * 이전까지의 예제에서는 서버나 클라이언트나 모두 입출력을 번갈아 수행했기 때문에 실질적인 의미로는 실시간 입출력이라고 할 수 없었다. 
 * 하지만, 이런 방식으로 입출력을 분리 하게 되면, 입출력의 순서에 관계 없이 실시간으로 통신이 가능하게된다.
 */

public class serverLauncher {

	public static void main (String []argv) {
		Socket client = null;		//client socket
		ServerSocket server = null;	//server socket
		BufferedReader bufferedReader = null;	//입력 담당 객체
		PrintWriter printWriter = null;			//출력 담당 객체
		int port = 10789;			//local port 번호
		String msg = "";

		try {
			server = new ServerSocket(port);	//server socket 생성.
			client = server.accept();			//client 접속을 받아들임.

			if (client != null) {	//접속 성공 시
				System.out.println(client.toString());	//접속 상태 출력.
				//입출력 객체 생성.
				bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				printWriter = new PrintWriter(client.getOutputStream(), true);

				while (true) {				//무한 루프를 돌며 입출력.
					msg = bufferedReader.readLine();
					System.out.println("From client : " + msg);
					if (msg.equals("bye")) {	//client로 부터 'bye'입력 시 접속 종료.
						System.out.println("Disconnect");
						printWriter.println("bye");
						break;
					}
					printWriter.println("msg("+msg+") is received");
				}
			}

			client.close();			//client 종료
			server.close();			//server 종료
		} catch (IOException e) {	//연결 중 예외 처리
			e.printStackTrace();
		} finally {					//예외 발생 시 접속을 종료
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
