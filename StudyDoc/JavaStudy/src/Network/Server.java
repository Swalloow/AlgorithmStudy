package Network;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by jwy on 2016. 8. 24..
 */
public class Server {
    ServerSocket m_serverSocket;
    Vector<Session> m_sessions;
    final int PORT = 8888;

    static Server g_server;
    static {
        g_server = new Server();
    }

    private Server() {
        init();
    }

    public static Server getInstance() {
        return g_server;
    }

    void init() {
        m_sessions = new Vector<>(100);
        new Thread(()->startServer()).start();
    }

    void startServer() {
        try {
            m_serverSocket = new ServerSocket(PORT);
            while(true) {
                Socket socket = m_serverSocket.accept();
                Session session = new Session(socket);
                m_sessions.add(session);
                System.out.println("Client accepted");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server destroyed");
    }

    void broadcast(String msg) {
        for(Session session : m_sessions) {
            session.send(msg);
        }
    }

    public static void main(String [] args) {
//        new Server();
        Server.getInstance();
        System.out.println("ServerMain");
    }
}
