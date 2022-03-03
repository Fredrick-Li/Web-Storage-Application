package Fredrick.Li.Personal.Cloud.Storage.mapper;

import Fredrick.Li.Personal.Cloud.Storage.model.Files;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE userid = #{userId}")
    List<Files> getAllFile(Integer userId);

    @Select("SELECT * FROM FILES WHERE filename = #{fileName}")
    Files getFile(String fileName);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) VALUES(#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insert(Files file);

    @Delete("DELETE FROM NOTES WHERE filename = #{fileName}")
    void delete(String fileName);

}
