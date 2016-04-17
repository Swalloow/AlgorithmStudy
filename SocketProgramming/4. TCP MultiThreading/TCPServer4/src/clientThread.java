import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clientThread extends Thread {
	private Socket client;			//client socket
	private PrintWriter printWriter;		//출력 객체
	private BufferedReader bufferedReader;	//입력 객체
	private String msg;

	public clientThread(Socket client) {
		this.client = client;	//연결된 client socket을 전달 받음.

		try {
			//입출력 객체 생성.
			printWriter = new PrintWriter(client.getOutputStream(), true);
			bufferedReader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while (true) {	//무한 루프를 돌며 입출력
				msg = bufferedReader.readLine();
				System.out.println("From client : " + msg);
				if (msg.equals("bye")) {
					printWriter.println(msg);
					break;
				}
				printWriter.println("msg(" + msg+ ") is received");
			}
		} catch (IOException e) {		//연결 중 예외 발생 시 처리
			e.printStackTrace();
		} finally {			//예외 발생 시 입출력 객체및 client socket 종료.
			printWriter.close();
			try {
				bufferedReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
