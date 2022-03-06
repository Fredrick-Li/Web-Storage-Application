package Fredrick.Li.Personal.Cloud.Storage.mapper;

import Fredrick.Li.Personal.Cloud.Storage.model.Credentials;
import Fredrick.Li.Personal.Cloud.Storage.model.Files;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CredentialsMapper {
    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
    Credentials[] getAllCredentials(Integer userId);

    @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) " +
            "VALUES(#{url}, #{userName}, #{key}, #{password}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    int insert(Credentials credential);

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    Credentials getCredential(Integer credentialId);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    void delete(Integer credentialId);

    @Update("UPDATE CREDENTIALS SET url = #{url}, key = #{key}, password = #{password}, username = #{newUserName} WHERE credentialid = #{credentialId}")
    void updateCredential(Integer credentialId, String newUserName, String url, String key, String password);
}
