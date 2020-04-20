package Atividade2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class mainCipherReader {
	
	public static void main(String[] args) {
		File f = new File("D:\\Projetos\\Java\\Sistema Distribuido\\src\\Atividade2\\file.txt");
		
		try {
			FileInputStream fis = new FileInputStream(f);
			CipherReader cr = new CipherReader(fis);
			
			int r = cr.read();
			while(r != -1) {
				System.out.print((char) r);
				r = cr.read();
			}
			
			cr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
