import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLauncher {

	public static void main(String[] args) {
		Socket client = null;					//client�� ����Ǵ� ����
		ServerSocket server = null;				//������ �޾Ƶ��̴� server socket
		int port = 10789;						//local port ��ȣ
		
		try {
			server = new ServerSocket(port);	//server socket ����
			client = server.accept();			//client�κ����� ������ �޾Ƶ���
			
			if(client!=null) {					//client�� ����� ���, ������¸� ���
				System.out.println(client.toString());
			}
			
			client.close();						//client socket�� ����
			server.close();						//server socket�� ����
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {								//���� �� ���� �߻� �� ������ ����
			if(client!=null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
