package Exersice2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("E:\\Java Lessons\\OOP\\5\\GMT20230706-164008_Recording_1920x1080.mp4");
        long fileLength = file.length();
        int thrCount = 5;
        double progress = 0;
        long[] filePartsLength = SplitFiles.getFilesPartLength(fileLength, thrCount);

        FileService[] fileServices = new FileService[thrCount];
        Thread[] threads = new Thread[thrCount];
        FileService.setFile(file);
        for(int i = 0; i < thrCount; i++) {
            if(i == 0) {
                fileServices[i] = new FileService(0, filePartsLength[i]);
            } else {
                fileServices[i] = new FileService(filePartsLength[i - 1], filePartsLength[i] + filePartsLength[i - 1]);
            }
            threads[i] = new Thread(fileServices[i]);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            System.out.println(progress + "%");
            threads[0].join();
            progress += 100.0 / thrCount;
            System.out.println(progress + "%");
            threads[1].join();
            progress += 100.0 / thrCount;
            System.out.println(progress + "%");
            threads[2].join();
            progress += 100.0 / thrCount;
            System.out.println(progress + "%");
            threads[3].join();
            progress += 100.0 / thrCount;
            System.out.println(progress + "%");
            threads[4].join();
            progress += 100.0 / thrCount;
            System.out.println(progress + "%");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        File fileCopy = new File("copy." + file.getName().substring(file.getName().lastIndexOf(".") + 1));

        try (OutputStream fos = new FileOutputStream(fileCopy, true)) {
            for(int i = 0; i < thrCount; i++) {
                byte[] bytes = fileServices[i].getResult();
                fos.write(bytes);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
