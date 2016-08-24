package Network;


import java.io.*;
import java.net.*;

/**
 * Created by jwy on 2016. 8. 24..
 */
public class Session extends Thread {

    Socket socket;
    InputStream is;
    OutputStream os;
    BufferedReader br;
    public Session(Socket socket) {
        this.socket = socket;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader( is ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    public void run() {
        System.out.println("Session started");
        boolean isAlive = true;
        try {
            while(isAlive) {
                String str = br.readLine();
                analyze(str);
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    void send(String msg) {
        try {
            msg += "\n";
            os.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void analyze(String protocol) {
        System.out.println(protocol);

        if("exit".equals(protocol)) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        else if(protocol.startsWith("site|")) {
            String address = protocol.substring(5);
            byte data[] = requestHttp(address);
            Server.getInstance().broadcast( new String(data) );
        }
        else {
//        send(protocol);
            Server.getInstance().broadcast(protocol);
        }
    }

    byte[] requestHttp(String address) {
        try {
            URL url = new URL(address);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            int length = con.getContentLength();
            System.out.println("content length :" +length);
            byte read[] = new byte[length];
            InputStream is = con.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            dis.readFully(read);
            dis.close();
            return read;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
