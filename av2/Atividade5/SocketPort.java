package atividade5;

import java.net.DatagramSocket;

public class SocketPort {
	public static void main(String[] args) throws Exception {
		
		DatagramSocket socket = new DatagramSocket();
		for (int i = 0; i < 10; i++) {
			System.out.println(socket.getLocalPort());
		}
		socket.close();
		
		System.out.println("----------------------------");
		
		socket = null;
		for (int i = 0; i < 10; i++) {
			socket = new DatagramSocket();
			System.out.println(socket.getLocalPort());
			socket.close();
		}
		

	}
}
