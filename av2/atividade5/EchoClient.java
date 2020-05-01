package atividade5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map.Entry;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		InetAddress servidor = InetAddress.getLocalHost();
		DatagramSocket socket = new DatagramSocket();

		String msg = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggg"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkklllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnoooooooooooooooooooooooooooppppppppppppppppppppp"
				+ "qqqqqqqqqqqqqqqqqqqqqqqqqqqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrssssssssssssssssssssssstttttttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvvvvvvvvvvvvvvvvvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwxxxxxxxxxxxxxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyyyyyy"
				+ "zzzzzzzzzzzzzzzzzzzzzz12345";
		String conteudo, conteudoOld;

		byte[] buffer = new byte[1000];
		byte[] dados = msg.getBytes("ASCII");
		int tamanhoPacote = 10;
		int bytesEnviados = 0;
		DatagramPacket pacote, pacoteR;
		int portaDestino = 5002;
		boolean ordemCorreta = true;
		HashMap<Integer, String> pacotesEnviados = new HashMap<Integer, String>();
		HashMap<Integer, String> pacotesRecebidos = new HashMap<Integer, String>();
		int contPacotes = 0;
		while (bytesEnviados <= dados.length && tamanhoPacote != 0) {
			pacote = new DatagramPacket(dados, bytesEnviados, tamanhoPacote, servidor, portaDestino);

			// System.out.println(socket.getInetAddress());
			socket.send(pacote);
			contPacotes++;

			bytesEnviados += tamanhoPacote;
			// System.out.println(dados.length - bytesEnviados + "<=" + tamanhoPacote);
			if ((dados.length - bytesEnviados) < tamanhoPacote) {
				tamanhoPacote = dados.length - bytesEnviados;
			}
			pacoteR = new DatagramPacket(buffer, buffer.length);
			socket.receive(pacoteR);
			conteudo = new String(pacoteR.getData());
			conteudo = conteudo.trim();
			pacotesEnviados.put(contPacotes, conteudo);

			// System.out.println("Conteudo do pacote: " + conteudo);
			conteudoOld = new String(dados, bytesEnviados - tamanhoPacote, tamanhoPacote);
			pacotesRecebidos.put(contPacotes, conteudoOld);

		}

		for (int i = 1; i < pacotesEnviados.size(); i++) {
			try {
				if (!pacotesRecebidos.get(i).trim().equals(pacotesEnviados.get(i).trim())) {
					System.out.println("conteudo do Pacote Recebido"+pacotesRecebidos.get(i));
					System.out.println("conteudo do Pacote Enviado"+pacotesEnviados.get(i));
					ordemCorreta = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("erro no item "+i);
				e.printStackTrace();
			}

		}
		if (ordemCorreta)
			System.out.println("Conteudo chegou na ordem correta.");
		else
			System.out.println("Conteudo não chegou na ordem correta.");

		socket.close();
	}
}
