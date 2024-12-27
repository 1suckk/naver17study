package day1227;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex8SocketServer extends Thread{
	
	ServerSocket serverSocket;
	
	@Override
	public void run() {
		System.out.println("서버 소켓을 생성해보자");
		try {
			serverSocket= new ServerSocket(6000);
			System.out.println("서버 소켓 성공");
			
			//멀티스레드이기 때문에 무한루프에 걸리지 않음
			while(true)
			{
				Socket socket = serverSocket.accept();
				System.out.println("점속한 클라이언트의 IP:" +
				socket.getInetAddress().getHostAddress());
			}
			
		} catch (IOException e) {
			System.out.println("서버 소켓 생성 실패: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex8SocketServer server = new Ex8SocketServer();
		server.start(); //run method 호출
	}

}
