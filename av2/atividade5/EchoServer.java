package atividade5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {
	public static void main(String[] args) throws Exception {
		int porta = 5002;
		byte[] buffer = new byte[1000];
		
		DatagramSocket socket = new DatagramSocket(porta);
		DatagramPacket pacote;
		String conteudo; 
		while (true) {
			pacote = new DatagramPacket(buffer, buffer.length);
			socket.receive(pacote);
			
			conteudo = new String(pacote.getData(), 0, pacote.getLength());
			
			System.out.println("Conteudo do pacote: " + conteudo);
			
			pacote = new DatagramPacket(pacote.getData(), pacote.getData().length, pacote.getAddress(), pacote.getPort());
			socket.send(pacote);
		}
	}
}
