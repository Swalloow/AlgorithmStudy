import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clientLauncher {

	public static void main(String[] argv) {
		Socket server = null;		//server socket 접속.
		ListenerThread thread = null;	//server로부터의 입력을 받아들임.
		int serverPORT = 10789;		//local port 번호.
		String serverIP = "192.168.10.102";	//server ip 주소
		BufferedReader getMsgFromUser;	//키보드 입력 객체
		PrintWriter printWriter;		//서보로 출력 담당 객체

		try {
			server = new Socket(serverIP, serverPORT);	//server socket 연결.

			if (server != null) {			//연결 성공 시
				System.out.println(server.toString());	//상태 출력.
				//입출력 객체 생성.
				printWriter = new PrintWriter(server.getOutputStream(), true);
				getMsgFromUser = new BufferedReader(new InputStreamReader(
						System.in));

				//서버로 부터의 입력 담당 thread
				thread = new ListenerThread(server);
				thread.start();
				while (true) {	//무한 루프를 돌며 입력.
					String text = getMsgFromUser.readLine();
					printWriter.println(text);
				}
			}
			server.close();
		} catch (IOException e) {	//연결 주 예외 처리
			e.printStackTrace();
		} finally {					//예외 발생 시 접속 종료.
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
