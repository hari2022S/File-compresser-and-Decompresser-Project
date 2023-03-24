package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompress {
    public static void main(String[] args) throws IOException{
        File path = new File("C:/Users/Harinath/Documents/nxt");
        method(path);
    }

    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/DecompressedFile");
        GZIPInputStream gzip = new GZIPInputStream(fis);

        byte[] arr = new byte[1024];
        int len;
        while((len=gzip.read(arr))!=-1){
            fos.write(arr,0,len);
        }

        gzip.close();
        fos.close();
        fis.close();
    }
}
