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
    private final FileMapper fileMapper;
    private final UserMapper userMapper;

    public FileService(FileMapper fileMapper, UserMapper userMapper) {
        this.fileMapper = fileMapper;
        this.userMapper = userMapper;
    }

    public String[] getAllFile(Integer userId) {
        return fileMapper.getAllFile(userId);
    }

    public void addFile(MultipartFile multipartFile, String userName) throws IOException {
        InputStream fis = multipartFile.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = fis.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        byte[] fileData = buffer.toByteArray();

        String fileName = multipartFile.getOriginalFilename();
        String contentType = multipartFile.getContentType();
        String fileSize = String.valueOf(multipartFile.getSize());
        Integer userId = userMapper.getUser(userName).getUserID();
        Files file = new Files(0, fileName, contentType, fileSize, userId, fileData);
        fileMapper.insert(file);
    }

    public Files getFile(String fileName) {
        return fileMapper.getFile(fileName);
    }

    public void deleteFile(String fileName) {
        fileMapper.deleteFile(fileName);
    }
}
