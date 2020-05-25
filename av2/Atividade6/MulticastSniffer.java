package Atividade6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSniffer {
	public static void main(String[] args) {
		InetAddress group = null;
		int port = 0;
		
		try {
			group = InetAddress.getByName("all-systems.mcast.net");//
			port = 40000;
		} catch (Exception e) {
			// Erro na leitura dos argumentos ou endere�o inv�lido
			System.err.println("Uso: java MulticastSniffer endere�o porta");
			e.printStackTrace();
			System.exit(1);
		}
		
		MulticastSocket ms = null;
		
		try {
			// Cria um socket associado ao endere�o do grupo
			ms = new MulticastSocket(port);
			ms.joinGroup(group);
			// Cria uma �rea de dados para receber conte�do dos pacotes
			byte[] buffer = new byte[80];
			// La�o para recebimento de pacotes e impress�o do conte�do
			while (true) {
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				ms.receive(dp);
				String s = new String(dp.getData());
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e);
		}finally {
			if (ms != null) {
				try {
					ms.leaveGroup(group);
					ms.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
