package Atividade1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class mainInvertedInputStream {

	public static void main(String[] args) {
		File f = new File("D:\\Projetos\\Java\\Sistema Distribuido\\src\\Atividade1\\file.txt");
		
		try {
			FileInputStream fos = new FileInputStream(f);
			InvertedInputStream iis = new InvertedInputStream(fos);
			
			byte[] text = new byte[(int)f.length()];
			iis.read(text);
			
			for (byte b : text) {
				System.out.print((char)b);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
