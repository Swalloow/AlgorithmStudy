import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientLauncher {

	public static void main(String[] args) {
		Socket server = null;			//server socket
		int port = 10790;				//local port ��ȣ
		String ip = "192.168.0.9";	//server ip�ּ�
		BufferedReader getMsgFromUser;	//Ű����κ��� ������ �Է��� �޾Ƶ��̴� ��ü
		PrintWriter printWriter;		//������ ��� ��� ��ü
		BufferedReader bufferedReader;	//������ ������ �Է� ��� ��ü
		String msg = "";
		
		try {
			server = new Socket(ip, port);	//server socket�� ����
			// ����� ��ü ����.
			getMsgFromUser = new BufferedReader(new InputStreamReader(System.in));
			printWriter = new PrintWriter(server.getOutputStream(), true);	
			bufferedReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
			
			if (server != null) {	//���� ���� �� ���� ���.
				System.out.println(server.toString());
			}
			while (true) {			//���� ������ ���� �����.
				System.out.print("To Server : ");
				msg = getMsgFromUser.readLine();
				
				printWriter.println(msg);
				if (msg.equals("bye")) {	//bye �Է� �� ���� ����.
					msg = bufferedReader.readLine();
					break;
				}
 				msg = bufferedReader.readLine();
 				System.out.println(msg);
			}
			
			System.out.println(msg);
			System.out.println("Now client disconnect");
			server.close();		//���� ����
		} catch (UnknownHostException e) {	//���� �� ���� �߻� �� catch
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {				//���� �߻� �� ���� ����.
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
