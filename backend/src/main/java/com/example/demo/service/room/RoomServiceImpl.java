package com.example.demo.service.room;

import com.example.demo.entity.room.Room;
import com.example.demo.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public void register(Room room, List<MultipartFile> files) throws Exception {
        List<String> filePathList = new ArrayList<>();
        try {
            if (files != null) {
                UUID uuid = UUID.randomUUID();

                for (MultipartFile multipartFile : files) {
                    log.info(multipartFile.getOriginalFilename());
                    String fileName = uuid + "_" + multipartFile.getOriginalFilename();
                    log.info(fileName);
                    FileOutputStream saveFile = new FileOutputStream(
                            "../frontend/src/assets/roomImg/" + fileName);
                    saveFile.write(multipartFile.getBytes());
                    saveFile.close();

                    filePathList.add(fileName);

                }
            }
        }catch (Exception e) {
            log.info("Upload Fail!!!");
        }

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


        roomRepository.save(room);
    }
}
