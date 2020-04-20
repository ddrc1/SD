package Atividade3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mainCompressor {

    private static int numThreads;
    private static int terminatedThreads = 0;
    private static long start;

    public static void main(String[] args) throws IOException {
        String path = "./pasta";
        File dir = new File(path);
        List<String> listFiles = Arrays.asList(dir.list());
        Compressor compressor = new Compressor(path);

        List<Compressor> compressors = new ArrayList<>();
        numThreads = listFiles.size();
        for (int i = 0; i < numThreads; i++) {
            compressors.add(new Compressor(path + "/" + listFiles.get(i)));
        }

        start = System.currentTimeMillis();
        System.out.println("Execução single thread");

        compressor.start();

        System.out.println("Execução multi thread");

        for (Compressor comp: compressors) {
            comp.start();
        }

    }

    public static void updateTerminatedCount(boolean isFstPart){
        if(isFstPart){
            long end = System.currentTimeMillis();
            long total = end - start;

            System.out.println("Tempo total single thread: " + total);
        }else{
            terminatedThreads ++;
            if(terminatedThreads == numThreads){
                long end = System.currentTimeMillis();
                long total = end - start;

                System.out.println("Tempo total multi thread: " + total);
            }
        }
    }

}
