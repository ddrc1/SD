package Atividade2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class CipherWriter extends OutputStreamWriter{
	
	OutputStream os;
	private String vogais = "aeioua";
	private String consoantes = "bcdfghjklmnpqrstvwxyzb";
	
	public CipherWriter(OutputStream os) {
		super(os);
		this.os = os;
	}

	@Override
	public void write(int i) throws IOException {
		os.write(i);
	}

	private Character getNextChar(char c) {
		if(vogais.indexOf(c) != -1) {
			return vogais.charAt(vogais.indexOf(c) + 1);
		}else {
			return consoantes.charAt(consoantes.indexOf(c) + 1);
		}
	}
	
	public void write(String s) throws IOException {
		if (s == null) {
            throw new NullPointerException();
        } 
	    for (int i = 0; i < s.length() ; i++) {
	        write((int) getNextChar(s.charAt(i)));
	    }
	    os.flush();
	}
}
