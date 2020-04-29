package Atividade5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientSocketPort {
	public static void main(String[] args) throws Exception {
		InetAddress servidor = InetAddress.getLocalHost();
		
		DatagramSocket socket = new DatagramSocket();
		
		String msg = "Olaaaaa";
		
		while (!msg.equals("")) {
//			DatagramSocket socket = new DatagramSocket();
			byte[] dados = msg.getBytes("ASCII");
			
			int portaDestino = 1024;
			DatagramPacket pacote = new DatagramPacket(dados, dados.length, servidor, portaDestino);
			
			socket.send(pacote);
			
//			socket.close();
		}
		socket.close();
	}
}
