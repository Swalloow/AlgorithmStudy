import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class serverLauncher {

	public static void main (String []argv) {
		int port = 10789;
		int THREAD_CNT = 5;
		Socket client = null;		//client socket
		ServerSocket server = null;	//server socket
		clientThread thread;		//client의 입출력을 담당하는 thread
		ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);

		try {
			server = new ServerSocket(port);	//serversocket 생성.
			System.out.println("client의 접속을 기다리는 중...");
			while (true) {				//무한루프를 돌며 client의 접속을 받음.
				client = server.accept();
				System.out.println(client.toString());
				threadPool.execute(new clientThread(client));//접속을 받을 때마다 ThreadPool에서 관리하는 thread 생성
			}

		} catch (IOException e) {		//연결 중 예외 처리
			e.printStackTrace();
		} finally {			//예외 발생 시 client와 server socket 종료.		
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
