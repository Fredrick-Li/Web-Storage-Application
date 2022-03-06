package Fredrick.Li.Personal.Cloud.Storage.mapper;

import Fredrick.Li.Personal.Cloud.Storage.model.Files;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {
    @Select("SELECT * FROM FILES WHERE filename = #{fileName}")
    Files getFile(String fileName);

    @Select("SELECT filename FROM FILES WHERE userid = #{userId}")
    String[] getAllFile(Integer userId);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) " +
            "VALUES(#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insert(Files file);

    @Delete("DELETE FROM FILES WHERE filename = #{fileName}")
    void deleteFile(String fileName);
}
