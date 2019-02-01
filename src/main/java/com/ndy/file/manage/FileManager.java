package com.ndy.file.manage;

import java.io.File;

public class FileManager {

    public static File mkdir(File benchMarkFolder, String folderName) {
        File folder;

        if(benchMarkFolder == null) {
            folder = new File(folderName);
        }else {
            if(!benchMarkFolder.exists()) mkdir(benchMarkFolder);

            folder = new File(benchMarkFolder, folderName);
        }

        return mkdir(folder);
    }

    private static File mkdir(File file) {
        file.mkdir();

        return file;
    }

}
