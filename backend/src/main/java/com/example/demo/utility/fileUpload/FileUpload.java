package com.example.demo.utility.fileUpload;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.hotel.HotelImage;
import com.example.demo.entity.room.Room;
import com.example.demo.entity.room.RoomImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
public abstract class FileUpload {

    public void fileUpload(List<MultipartFile> files, String filepath, List<String> filePathList) {

        try {
            if (files != null) {

                for (MultipartFile multipartFile : files) {
                    UUID uuid = UUID.randomUUID();

                    log.info(multipartFile.getOriginalFilename());
                    String fileName = uuid + "_" + multipartFile.getOriginalFilename();
                    log.info(fileName);
                    FileOutputStream saveFile = new FileOutputStream(
                            "../frontend/src/assets/" + filepath + "/" + fileName);
                    saveFile.write(multipartFile.getBytes());
                    saveFile.close();

                    filePathList.add(fileName);

                }
            }
        } catch (Exception e) {
            log.info("Upload Fail!!!");
        }

    }

    public void fileRemove(String fileName, String path) {

        File file = new File("../frontend/src/assets/" + path + "/" + fileName);

        if (file.exists()) {
            file.delete();
        }
    }


    public void roomImgPathRemove (Room room, String path) {

        List<RoomImage> imagesToRemove = new ArrayList<>();

        room.getRoomImages().forEach(f -> {
                    imagesToRemove.add(f);
                    fileRemove(f.getPath(), path);
                });
        imagesToRemove.forEach(image -> room.removeRoomImageFromRoom(image));

    }
    public void addRoomImgPath(Room room, List<String> filePathList) {

        List<RoomImage> roomImages =
                filePathList.stream().map(f -> RoomImage.builder().path(f).room(room).build()).collect(Collectors.toList());

        roomImages.forEach(image -> room.addRoomImageToRoom(image));
        }


    public void addHotelImgPath(Hotel hotel, List<String> filePathList) {
        List<HotelImage> hotelImages = filePathList.stream().map(f -> HotelImage.builder().path(f).hotel(hotel).build()).collect(Collectors.toList());
        hotelImages.forEach(image -> hotel.addHotelImageToHotel(image));
    }


    public void hotelImgPathRemove(Hotel hotel, String path) {
        List<HotelImage> imagesToRemove = new ArrayList<>();

        hotel.getHotelImages().forEach(f -> {
                    imagesToRemove.add(f);
                    fileRemove(f.getPath(), path);
                });
        imagesToRemove.forEach(image -> hotel.removeHotelImageFromHotel(image));

    }
}

