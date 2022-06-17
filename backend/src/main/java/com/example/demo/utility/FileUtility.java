package com.example.demo.utility;

import com.example.demo.entity.member.User;
import com.example.demo.service.member.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class FileUtility {

    private final UserService userService;
    public static String FILE_PATH = "../frontend/src/assets/img/";

    public String createFilePath (MultipartFile multipartFile) {
        UUID uuid = UUID.randomUUID();
        String filePathWithName = FILE_PATH + uuid + multipartFile.getOriginalFilename();
        return filePathWithName;
    }

    public void createFile(MultipartFile multipartFile, String filePathWithName){
        try {
            FileOutputStream fos = new FileOutputStream(filePathWithName);
            fos.write(multipartFile.getBytes());
            // 기존에 있던 파일 삭제식
            fos.close();
        }
        catch (IOException ioe){
            System.out.println("Cannot create a file at: " + filePathWithName);
        }
    }

    public void replaceOldProfileWithNew() {
        try {
            String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<User> optionalUser = userService.findByEmail(email);
            if (optionalUser.isEmpty())
                throw new BadCredentialsException("There is no user with email: " + email);
            User user = optionalUser.get();
            // Pass a file and remove it
            String filePath = user.getProfile_path();
            removeFile(filePath);

        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void removeFile(String filename){
        File file = new File(FILE_PATH);
        try {
            boolean fileDeleted = Files.deleteIfExists(Paths.get(FILE_PATH));
            if (fileDeleted)
                ;
        } catch (IOException ioe){
            System.out.println("Cannot delete file");
        }
    }
}
