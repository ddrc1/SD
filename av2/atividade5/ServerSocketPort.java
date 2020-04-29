package atividade5;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServerSocketPort {

	public static void main(String[] args) throws Exception{
		int porta = 1024;
		byte[] buffer = new byte[100];
		
		DatagramSocket socket = new DatagramSocket(porta);
		DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
		
		while (true) {
			socket.receive(pacote);
			
			String conteudo = new String(pacote.getData(), 0, pacote.getLength());
			
			System.out.println("Porta do pacote: " + pacote.getPort());
			System.out.println("Conteudo do pacote: " + conteudo);
		}
		
	}

}
