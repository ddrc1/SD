package Atividade1;

import java.io.IOException;
import java.io.OutputStream;

public class mainInvertOutputStream {

	public static void main(String[] args) {
		
		OutputStream os = System.out;
		InvertOutputStream ios = new InvertOutputStream(os);
		
		String s = "olaaaaaaa";
		byte[] b = s.getBytes();
		
		try {
			ios.write(b);
			ios.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
