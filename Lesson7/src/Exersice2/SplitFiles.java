package Exersice2;

public class SplitFiles {
    public static long[] getFilesPartLength(long fileLength, int count) {
        long[] filesPartLength = new long[count];
        long length = fileLength / count;
        if(fileLength % count == 0) {
            for (int i = 0; i < count; i++) {
                filesPartLength[i] = length;
            }
        } else {
            for (int i = 0; i < count; i++) {
                if(i == 0) {
                    filesPartLength[i] = fileLength - length * count + length;
                } else {
                    filesPartLength[i] = length;
                }
            }
        }
        return filesPartLength;
    }
}
