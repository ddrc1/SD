package Atividade7;

import java.net.*;
import java.io.*;

public class CheckHttpConn {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket ("www.weevil.info", 80);
		
		OutputStream out = socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
		bw.write("GET introduction-weevils.html HTTP/1.1\r\n\n");
		bw.flush();
		
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
         
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
         
        bw.close();
        br.close();
		
        socket.close();
	}

}
