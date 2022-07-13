package com.example.demo.utility;

import com.example.demo.entity.hotel.HotelImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Slf4j
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



    public static void deleteImage(String imageName, String path){
            File file = new File("../frontend/src/assets/" + path + "/" + imageName);

            if (file.exists()){
                log.info("Deleting File: {}", file.toString());
                file.delete();
            } else{
                log.info("File does not exist: {}", file.toString());
            }
        }
}