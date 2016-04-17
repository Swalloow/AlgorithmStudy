import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListenerThread extends Thread {
	private Socket server;			//server socket
	private BufferedReader bufferedReader;	//서버로부터의 입력 담당 객체
	private String msg;

	public ListenerThread(Socket server) {
		this.server = server;		//server socket을 전달 받음.

		try {
			//server로 부터 입력 담당하는 객체 생성.
			bufferedReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			while (true) {	//무한루프를 돌며 입력을 받아들임.
				msg = bufferedReader.readLine();
				System.out.println("From server : " + msg);
				if (msg.equals("bye")) {
					System.out.println("now disconnted");
					break;
				}
			}
			bufferedReader.close();
			server.close();
			System.exit(0);
		} catch (IOException e) {	//연결 중 예외 발생 시 처리
			e.printStackTrace();
		} finally {			//예외 발생 시 입력 객체와 socket 종료.
			try {
				bufferedReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
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
