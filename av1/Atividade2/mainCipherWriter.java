package Atividade2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class mainCipherWriter {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = System.out;
		CipherWriter cw = new CipherWriter(os);
		cw.write("olaaaaaaa");
	}

}
