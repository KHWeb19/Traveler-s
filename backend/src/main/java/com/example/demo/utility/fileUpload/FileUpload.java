package com.example.demo.utility.fileUpload;

import com.example.demo.entity.room.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public abstract class FileUpload {

    public void fileUpload(List<MultipartFile> files, String filepath, List<String> filePathList) {

        try {
            if (files != null) {
                UUID uuid = UUID.randomUUID();

                for (MultipartFile multipartFile : files) {
                    log.info(multipartFile.getOriginalFilename());
                    String fileName = uuid + "_" + multipartFile.getOriginalFilename();
                    log.info(fileName);
                    FileOutputStream saveFile = new FileOutputStream(
                            "../frontend/src/assets/"+ filepath + "/" + fileName);
                    saveFile.write(multipartFile.getBytes());
                    saveFile.close();

                    filePathList.add(fileName);

                }
            }
        } catch (Exception e) {
            log.info("Upload Fail!!!");
        }

        }
    }

