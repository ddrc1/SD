package Atividade1;

import java.io.IOException;
import java.io.InputStream;

public class InvertedInputStream extends InputStream{

	InputStream is;
	
	public InvertedInputStream(InputStream is) {
		this.is = is;
	}
	
	@Override
	public int read() throws IOException {
		return is.read();
	}
	
	public int read(byte b[]) throws IOException {
        return read(b, 0, b.length);
    }
	
	public int read(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }
        int i = len - 1;
        try {
            for (; i >= off ; i--) {
                int c = read();
                if (c == -1) {
                    break;
                }
                b[off + i] = (byte)c;
            }
        } catch (IOException ee) {
        }
        return i;
    }
	
	public void close() throws IOException {
		is.close();
	}
	
	

}
