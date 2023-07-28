package Exersice3;

public class SplitDirectory {
    public static int[] getFileCount(long directorySize, int count) {
        int[] directoryPartSize = new int[count];
        int size = (int) (directorySize / count);
        if(directorySize % count == 0) {
            for (int i = 0; i < count; i++) {
                directoryPartSize[i] = size;
            }
        } else {
            for (int i = 0; i < count; i++) {
                if(i == 0) {
                    directoryPartSize[i] = (int) (directorySize - size * count + size);
                } else {
                    directoryPartSize[i] = size;
                }
            }
        }
        return directoryPartSize;
    }
}
