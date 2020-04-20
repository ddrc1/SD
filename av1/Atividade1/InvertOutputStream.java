package Atividade1;

import java.io.IOException;
import java.io.OutputStream;

public class InvertOutputStream extends OutputStream{

	private OutputStream os;
	
	public InvertOutputStream(OutputStream os) {
		this.os = os;
	}
	
	@Override
	public void write(int b) throws IOException {
		os.write(b);		
	}
	
	public void write(byte[] b) throws IOException {
		write(b, 0, b.length);
	}
	
	public void  write(byte[] b, int off, int len) throws IOException {
		if (b == null) {
            throw new NullPointerException();
        } else if ((off < 0) || (off > b.length) || (len < 0) ||
                   ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
	    for (int i = len - 1; i >= off ; i--) {
	        write(b[i]);
	    }
	}
	
	public void flush() throws IOException {
		os.flush();
	}
}
