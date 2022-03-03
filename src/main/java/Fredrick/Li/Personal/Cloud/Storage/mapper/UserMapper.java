package Fredrick.Li.Personal.Cloud.Storage.mapper;

import Fredrick.Li.Personal.Cloud.Storage.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;


@Mapper
public interface UserMapper {

    // we define methods to interact with the database: getUser and insert user information
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    @Select("SELECT * FROM USERS WHERE userid = #{userId}")
    User getUserById(Integer uerId);

    @Insert("INSERT INTO USERS(username, salt, password, firstname, lastname) VALUES (#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

}
