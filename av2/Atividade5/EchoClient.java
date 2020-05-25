package atividade5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		InetAddress servidor = InetAddress.getLocalHost();
		byte[] buffer = new byte[1000];
		
		DatagramSocket socket = new DatagramSocket();
		
		String msg = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggg"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkklllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnoooooooooooooooooooooooooooppppppppppppppppppppp"
				+ "qqqqqqqqqqqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrssssssssssssssssssssssstttttttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvvvvvvvvvvvvvvvvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyy"
				+ "zzzzzzzzzzzzzzzzzzzzzz12345";
		
		int tamanhoPacote = 10;
		String msgComId = new String("");
		int id = 0;
		for (int i = 0; i < msg.length(); i++) {
			if(i % (tamanhoPacote - 4) == 0) {
				String idString = String.valueOf(id);
				while (idString.length() < 3) {
					idString = "0" + idString;
				}
				msgComId += idString + ":";
				id ++;
			}
			msgComId += Character.toString(msg.charAt(i));
		}
		msg = msgComId;
		System.out.println(msg);
		
		byte[] dados = msg.getBytes("ASCII");
		int bytesEnviados = 0;
		
		int portaDestino = 5002;
		DatagramPacket pacote = null;
		DatagramPacket pacoteRcv = null;
		
		List<String> listaEnviados = new ArrayList<String>();
		while (bytesEnviados <= dados.length && tamanhoPacote != 0) {
			pacote = new DatagramPacket(dados, bytesEnviados, tamanhoPacote, servidor, portaDestino);
			socket.send(pacote);
			String enviado = new String(dados, bytesEnviados, tamanhoPacote).trim();
			System.out.println("conteudo enviado " + enviado);
			listaEnviados.add(enviado);
			
			pacoteRcv = new DatagramPacket(buffer, buffer.length);
			socket.receive(pacoteRcv);
//			System.out.println(pacoteRcv.getLength());
			String recebido = new String(pacoteRcv.getData(), 0, pacoteRcv.getLength()).trim();
			
			System.out.println("Conteudo do pacote do servidor: " + recebido);
			
			if (recebido.trim().equals(enviado)) {
				System.out.println("Conteudo IGUAL");
			}else {
				System.out.println("conteudo DIFERENTE");
			}
			
			bytesEnviados += tamanhoPacote;
			if((dados.length - bytesEnviados) < tamanhoPacote) {
				tamanhoPacote = dados.length - bytesEnviados;
			}
			
			listaEnviados.remove(recebido);
		}
		
		if(listaEnviados.isEmpty()) {
			System.out.println("Nenhum pacote foi perdido");
		}else {
			System.out.print("Pacotes perdidos: ");
			for (String item : listaEnviados) {
				System.out.println(item + " ");
			}
		}
		socket.close();
	}
}