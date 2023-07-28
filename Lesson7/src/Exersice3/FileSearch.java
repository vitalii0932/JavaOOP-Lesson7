package Exersice3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch implements Runnable{
    private static File[] files;
    private String searchingFileName;
    private int startIndex;
    private int endIndex;
    private int directoryCount;
    private static List<String> searchingFiles;

    public FileSearch() {
        this.directoryCount = 0;
        searchingFiles = new ArrayList<>();
    }

    public FileSearch(String searchingFileName, int startIndex, int endIndex) {
        this.searchingFileName = searchingFileName;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        searchingFiles = new ArrayList<>();
        this.directoryCount = 0;
    }

    public static void setFiles(File[] files) {
        FileSearch.files = files.clone();
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public void setSearchingFileName(String searchingFileName) {
        this.searchingFileName = searchingFileName;
    }

    public List<String> getSearchingFiles() {
        return searchingFiles;
    }

    public void fileSearch(File[] files, String fileName) {
        if (files != null) {
            if(directoryCount == 0) {
                for (int i = startIndex; i < endIndex; i++) {
                    if (files[i].isDirectory()) {
                        directoryCount++;
                        fileSearch(files[i].listFiles(), fileName);
                    } else {
                        if (files[i].getName().equals(fileName)) {
                            searchingFiles.add(files[i].getAbsolutePath());
                        }
                    }
                }
            } else {
                for (File file : files) {
                    if (file.isDirectory()) {
                        fileSearch(file.listFiles(), fileName);
                    } else {
                        if (file.getName().equals(fileName)) {
                            searchingFiles.add(file.getAbsolutePath());
                        }
                        directoryCount--;
                    }
                }
            }

        }
    }

    @Override
    public void run() {
        fileSearch(files, searchingFileName);
    }
}
