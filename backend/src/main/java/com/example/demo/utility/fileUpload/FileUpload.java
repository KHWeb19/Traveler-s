package com.example.demo.utility.fileUpload;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public void fileRemove(String fileName, String path){

        File file = new File("../frontend/src/assets/" + path + "/" + fileName);

        if (file.exists()) {
            file.delete();
        }
    }

    public void roomImgPathRemove (Optional<Room> roomInfo, String path) {

        if(roomInfo.get().getRoomImgPath1() != null){fileRemove(roomInfo.get().getRoomImgPath1(), path);}
        if(roomInfo.get().getRoomImgPath2() != null){fileRemove(roomInfo.get().getRoomImgPath2(), path);}
        if(roomInfo.get().getRoomImgPath3() != null){fileRemove(roomInfo.get().getRoomImgPath3(), path);}
        if(roomInfo.get().getRoomImgPath4() != null){fileRemove(roomInfo.get().getRoomImgPath4(), path);}
        if(roomInfo.get().getRoomImgPath5() != null){fileRemove(roomInfo.get().getRoomImgPath5(), path);}
        if(roomInfo.get().getRoomImgPath6() != null){fileRemove(roomInfo.get().getRoomImgPath6(), path);}
        if(roomInfo.get().getRoomImgPath7() != null){fileRemove(roomInfo.get().getRoomImgPath7(), path);}
        if(roomInfo.get().getRoomImgPath8() != null){fileRemove(roomInfo.get().getRoomImgPath8(), path);}
        if(roomInfo.get().getRoomImgPath9() != null){fileRemove(roomInfo.get().getRoomImgPath9(), path);}

    }
    public void addRoomImgPath(Room room , List<String> filePathList) {
        for(int i = 0; i < filePathList.size(); i++) {
            switch (i){
                case 0:
                    room.setRoomImgPath1(filePathList.get(i));
                    break;
                case 1:
                    room.setRoomImgPath2(filePathList.get(i));
                    break;
                case 2:
                    room.setRoomImgPath3(filePathList.get(i));
                    break;
                case 3:
                    room.setRoomImgPath4(filePathList.get(i));
                    break;
                case 4:
                    room.setRoomImgPath5(filePathList.get(i));
                    break;
                case 5:
                    room.setRoomImgPath6(filePathList.get(i));
                    break;
                case 6:
                    room.setRoomImgPath7(filePathList.get(i));
                    break;
                case 7:
                    room.setRoomImgPath8(filePathList.get(i));
                    break;
                case 8:
                    room.setRoomImgPath9(filePathList.get(i));
                    break;
            }

        }
    }

    public void addHotelImgPath (Hotel hotel , List<String> filePathList) {
        for(int i = 0; i < filePathList.size(); i++) {
            switch (i){
                case 0:
                    hotel.setHotelImgPath1(filePathList.get(i));
                    break;
                case 1:
                    hotel.setHotelImgPath2(filePathList.get(i));
                    break;
                case 2:
                    hotel.setHotelImgPath3(filePathList.get(i));
                    break;
                case 3:
                    hotel.setHotelImgPath4(filePathList.get(i));
                    break;
                case 4:
                    hotel.setHotelImgPath5(filePathList.get(i));
                    break;
                case 5:
                    hotel.setHotelImgPath6(filePathList.get(i));
                    break;
                case 6:
                    hotel.setHotelImgPath7(filePathList.get(i));
                    break;
                case 7:
                    hotel.setHotelImgPath8(filePathList.get(i));
                    break;
                case 8:
                    hotel.setHotelImgPath9(filePathList.get(i));
                    break;
            }

        }
    }

    public void hotelImgPathRemove(Optional<Hotel> hotelInfo, String path) {
        if(hotelInfo.get().getHotelImgPath1() != null){fileRemove(hotelInfo.get().getHotelImgPath1(), path);}
        if(hotelInfo.get().getHotelImgPath2() != null){fileRemove(hotelInfo.get().getHotelImgPath2(), path);}
        if(hotelInfo.get().getHotelImgPath3() != null){fileRemove(hotelInfo.get().getHotelImgPath3(), path);}
        if(hotelInfo.get().getHotelImgPath4() != null){fileRemove(hotelInfo.get().getHotelImgPath4(), path);}
        if(hotelInfo.get().getHotelImgPath5() != null){fileRemove(hotelInfo.get().getHotelImgPath5(), path);}
        if(hotelInfo.get().getHotelImgPath6() != null){fileRemove(hotelInfo.get().getHotelImgPath6(), path);}
        if(hotelInfo.get().getHotelImgPath7() != null){fileRemove(hotelInfo.get().getHotelImgPath7(), path);}
        if(hotelInfo.get().getHotelImgPath8() != null){fileRemove(hotelInfo.get().getHotelImgPath8(), path);}
        if(hotelInfo.get().getHotelImgPath9() != null){fileRemove(hotelInfo.get().getHotelImgPath9(), path);}
    }
}

