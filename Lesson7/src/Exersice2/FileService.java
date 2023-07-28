package Exersice2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileService implements Runnable{
    private static File file;
    private long startIndex;
    private long endIndex;
    private byte[] result;

    public FileService() {
    }

    public FileService(long startIndex, long endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public static void setFile(File file) {
        FileService.file = file;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(long endIndex) {
        this.endIndex = endIndex;
    }

    public byte[] getResult() {
        return result;
    }

    public void getBytesArray(long start, long end, File file) {
        result = new byte[(int) (end - start)];
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.skip(start);
            fis.read(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        getBytesArray(startIndex, endIndex, file);
    }
}
