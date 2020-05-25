package Atividade7;

import java.net.InetSocketAddress;
import java.net.Socket;

public class CheckTCPConn {
	public static void main(String[] args) {
		
		int count = 0;
		Socket socket;
		for (int i = 1; i < 5000; i++) {
			socket = new Socket();
			try {
				
				InetSocketAddress addr = new InetSocketAddress("127.0.0.1", i);
				socket.connect(addr, 100);
				
				count ++;
				System.out.println(count);
				
			} catch (Exception e) {
				System.out.println(e + " on port " + i);
			}
			
		}
		System.out.println("conexões estabelecidas: " + count);
		
	}
}
