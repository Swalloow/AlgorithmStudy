import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListenerThread extends Thread {
	private Socket server;			//server socket
	private BufferedReader bufferedReader;	//서버로부터 입력 담당 객체
	private String msg;

	//ListenerThread constructor
	public ListenerThread(Socket s) {	//생성시 socket 객체를 받아옴.
		this.server = s;
		try {
			//입력 객체 생성.
			bufferedReader = new BufferedReader(new InputStreamReader(
					server.getInputStream()));
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
			System.exit(0);
		} catch (IOException e) {	//연결 중 예외 처리
			e.printStackTrace();
		} finally {			//연결 중 예외 발생 시 접속 종료.
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
