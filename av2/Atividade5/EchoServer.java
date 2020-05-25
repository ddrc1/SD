package atividade5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {
	public static void main(String[] args) throws Exception {
		int porta = 5002;
		byte[] buffer = new byte[1000];
		
		DatagramSocket socket = new DatagramSocket(porta);
		
		while (true) {
			DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
			socket.receive(pacote);
			
			String conteudo = new String(pacote.getData(), 0, pacote.getLength()).trim();
			
			System.out.println("Conteudo do pacote do cliente: " + conteudo);
			
			pacote = new DatagramPacket(pacote.getData(), conteudo.length(), pacote.getAddress(), pacote.getPort());
			socket.send(pacote);
		}
	}
}