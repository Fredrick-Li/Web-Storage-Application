package Fredrick.Li.Personal.Cloud.Storage.service;

import Fredrick.Li.Personal.Cloud.Storage.mapper.FileMapper;
import Fredrick.Li.Personal.Cloud.Storage.mapper.UserMapper;
import Fredrick.Li.Personal.Cloud.Storage.model.Files;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class FileService {
    private final UserMapper userMapper;
    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper, UserMapper userMapper){
        this.fileMapper = fileMapper;
        this.userMapper = userMapper;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating file bean.");
    }

    public boolean isNoteDuplicated(String fileName) {
        return fileMapper.getFile(fileName) == null;
    }
    public List<Files> getAllFile(Integer userId){
        return fileMapper.getAllFile(userId);
    }
    public void addFile(MultipartFile file, String userName) throws IOException {
        int segment = 0;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        InputStream inputStream = file.getInputStream();
        while((segment = inputStream.read(data, 0, data.length)) != -1){
            buffer.write(data, 0, segment);
        }
        buffer.flush();
        byte[] fileReady = buffer.toByteArray();

        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        String fileSize = String.valueOf(file.getSize());
        Integer userId = userMapper.getUser(userName).getUserID();

        Files newFile = new Files(0, fileName, contentType, fileSize, userId, fileReady);
        fileMapper.insert(newFile);
    }

    public Files getFile(String fileName){
        return fileMapper.getFile(fileName);
    }

    public void deleteFile(String fileName){
        fileMapper.delete(fileName);
    }
}
