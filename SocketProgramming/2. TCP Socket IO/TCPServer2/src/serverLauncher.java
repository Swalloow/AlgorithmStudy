import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * �̹� ���������� TCP ���� �� ������ ���ڸ� �ְ� �޴� ������� �����ش�. 
 * �̸� ���� �Է� ���ۿ� ��� ���� ��ü�� �����ϰ�, ���ѷ����� ���� ������� �Ѵ�. 
 * ���� ���� �ÿ��� ���Ƿ� ��bye���� �Է��ϸ� Ŭ���̾�Ʈ���� ������ �Ŀ� ������ �����ϴ� ������ ����Ǹ�, 
 * �̶�, �Ϲ������� 4-way handshaking�� ���� ���Ḧ �ϸ�, �̸� ����� ����(Graceful close)��� �Ѵ�.
 */

public class serverLauncher {

	public static void main(String[] args) {
		Socket client = null;		//client socket
		ServerSocket server = null;	//server socket
		PrintWriter printWriter;		//��� ��� ��ü
		BufferedReader bufferedReader;	//�Է� ��� ��ü
		int port = 10790;			//local port ��ȣ

		try {
			server = new ServerSocket(port);	//server socket ����.
			client = server.accept();			//client ������ �޾Ƶ���.

			if (client != null) {			//���� ������ ���� ���.
				System.out.println(client.toString());
			}

			//client�κ����� �Է°� ��� ��ü ����.
			printWriter = new PrintWriter(client.getOutputStream(), true);
			bufferedReader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));

			while (true) {	//���ѷ����� ���� �����.

				String msg = bufferedReader.readLine();
				System.out.println("From Client : " + msg);
				if (msg.equals("bye")) {	//client�κ��� 'bye'�Է��� ������ ä�� ����
					System.out.println("disconnect");
					break;
				}
				printWriter.println("message(" + msg + ") is received.");
			}
			printWriter.println("server is disconnecing");
			client.close();	//client ����
			server.close();	//server ����
			
		} catch (IOException e) {	//���� �� ���� ó��.
			e.printStackTrace();
		} finally {			//���� �� ���� �߻��� ������ ����.
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
