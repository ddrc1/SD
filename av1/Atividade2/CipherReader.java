package Atividade2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CipherReader extends InputStreamReader {
	
	private InputStream is;
	private String vogais = "uaeiou";
	private String consoantes = "zbcdfghjklmnpqrstvwxyz";
	
	public CipherReader(InputStream is) {
		super(is);
		this.is = is;
	}
	
	private Character getPreviousChar(char c) {
		if(vogais.indexOf(c) != -1) {
			return vogais.charAt(vogais.indexOf(c) - 1);
		}else {
			return consoantes.charAt(consoantes.indexOf(c) - 1);
		}
	}
	
	public int read() throws IOException {
		int c = is.read();
		if(c != -1) {
			return getPreviousChar((char) c);
		}else {
			return c;
		}
	}	
	
	public void read(String input) throws IOException {
		for (int i = 0; i < input.length(); i++) {
			int c = read();
		}
	}
}
