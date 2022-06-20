package com.example.demo.utility;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FileUtility {

    public static String FILE_PATH = "../frontend/src/assets/img/";

    public static String createFileAndReturnPath(MultipartFile multipartFile, String oldProfilePath){

        UUID uuid = UUID.randomUUID();
        String fileNameWithUUID = uuid + multipartFile.getOriginalFilename();

        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH + fileNameWithUUID);
            fos.write(multipartFile.getBytes());
            fos.close();

            if (!oldProfilePath.equals("default.png"))
                Files.delete(Path.of(FILE_PATH + oldProfilePath));
        }
        catch (IOException ioe){
            ioe.printStackTrace();
            System.out.println("Unable to update file");
        }
        return fileNameWithUUID;
    }
}
