package Exersice3;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\User\\Documents");
        File[] files = directory.listFiles();
        String searchingFiles = "text.txt";

        int directoryLength = directory.listFiles().length;
        int thrCount = 5;
        int[] directoryPartsLength = SplitDirectory.getFileCount(directoryLength, thrCount);

        FileSearch[] fileSearches = new FileSearch[thrCount];
        Thread[] threads = new Thread[thrCount];
        for(int i = 0; i < thrCount; i++) {
            if(i == 0) {
                fileSearches[i] = new FileSearch(searchingFiles, 0, directoryPartsLength[i]);
            } else {
                fileSearches[i] = new FileSearch(searchingFiles, directoryPartsLength[i - 1] * i, directoryPartsLength[i] * i + directoryPartsLength[i - 1]);
            }
            threads[i] = new Thread(fileSearches[i]);
        }
        FileSearch.setFiles(files);

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            threads[0].join();
            threads[1].join();
            threads[2].join();
            threads[3].join();
            threads[4].join();
        } catch (InterruptedException e){
        }

        String[] searchingElementsPath = fileSearches[0].getSearchingFiles().toArray(new String[0]);
        System.out.println(Arrays.toString(searchingElementsPath));
    }
}
