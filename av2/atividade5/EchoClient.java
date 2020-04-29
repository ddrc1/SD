package atividade5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		InetAddress servidor = InetAddress.getLocalHost();
		
		DatagramSocket socket = new DatagramSocket();
		
		String msg = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggg"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkklllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnoooooooooooooooooooooooooooppppppppppppppppppppp"
				+ "qqqqqqqqqqqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrssssssssssssssssssssssstttttttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvvvvvvvvvvvvvvvvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyy"
				+ "zzzzzzzzzzzzzzzzzzzzzz12345";
		
		byte[] dados = msg.getBytes("ASCII");
		int tamanhoPacote = 10;
		int bytesEnviados = 0;
		
		int portaDestino = 5002;
		while (bytesEnviados <= dados.length && tamanhoPacote != 0) {
			DatagramPacket pacote = new DatagramPacket(dados, bytesEnviados, tamanhoPacote, servidor, portaDestino);
			
			socket.send(pacote);
			
			bytesEnviados += tamanhoPacote;
			System.out.println(dados.length - bytesEnviados + "<=" + tamanhoPacote);
			if((dados.length - bytesEnviados) < tamanhoPacote) {
				tamanhoPacote = dados.length - bytesEnviados;
			}
			
			socket.receive(pacote);
			String conteudo = new String(pacote.getData(), 0, pacote.getData().length);
			
			System.out.println("Conteudo do pacote: " + conteudo);
			
			if (conteudo.equals(new String(dados, bytesEnviados, tamanhoPacote))) {
				System.out.println("Conteudo IGUAL");
			}else {
				System.out.println("conteudo DIFERENTE");
			}
		}
			
		socket.close();
	}
}
