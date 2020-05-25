package Atividade6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {

	public static void main(String[] args) throws IOException {
		InetAddress servidor = InetAddress.getByName("all-systems.mcast.net");

//		DatagramSocket socket = new DatagramSocket();
		DatagramSocket socket = new DatagramSocket(40000);

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
