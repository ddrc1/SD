package Atividade3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compressor extends Thread {

    private String path;
    private File file;
    private boolean isDir;

    public Compressor(String path){
        this.path = path;
        this.file = new File(path);
        this.isDir = file.isDirectory();
    }

    public void run() {
        try {
            FileOutputStream fos = new FileOutputStream(this.path + ".zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            for (String file : file.list()) {
                File fileToZip = new File(file);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }
            zipOut.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        mainCompressor.updateTerminatedCount(this.isDir);
    }
}
