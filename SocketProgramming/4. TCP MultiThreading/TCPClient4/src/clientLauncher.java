import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientLauncher {

	public static void main(String[] argv) {
		Socket server = null;			//server socket
		PrintWriter printWriter = null;		//출력 담당 객체
		BufferedReader bufferedReader = null;	//키보드 입력 객체
		ListenerThread thread = null;		//서버로 부터의 입력을 thread로 관리
		int serverPORT = 10789;			//local port 번호
		String serverIP = "192.168.0.133";		//server의 ip 주소
		String msg;
		
		try {
			server = new Socket(serverIP, serverPORT);	//server에 연결.
			if (server != null) {			//연결 성공 시
				System.out.println(server.toString());
				// 서버로의 출력 객체와 키보드 입력 객체 생성.
				printWriter = new PrintWriter(server.getOutputStream(), true);
				bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				
				// 서버로부터의 수신을 담당하는 thread 생성.
				thread = new ListenerThread(server);
				thread.start();
				
				while (true) {	//무한 루프를 돌며 키보드 입력을 받고, 서버로 송신.
					msg = bufferedReader.readLine();
					printWriter.println(msg);
				}
			}
			bufferedReader.close();
			printWriter.close();
			server.close();

		} catch (UnknownHostException e) {	//연결 중 예외 발생 시 처리.
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {				//예외 방생 시 출력 객체와 socket을 종료.
			printWriter.close();
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