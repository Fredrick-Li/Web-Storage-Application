package Fredrick.Li.Personal.Cloud.Storage.mapper;

import Fredrick.Li.Personal.Cloud.Storage.model.Notes;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface NotesMapper {

    @Select("SELECT * FROM NOTES")
    List<Notes> getAllNote();

    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    List<Notes> getNoteByUserId(Integer userId);

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteId}")
    Notes getNoteById(Integer noteId);

    @Insert("INSERT INTO NOTES(notetitle, notedescription, userid) VALUES(#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty  ="noteId")
    int insert(Notes note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    void delete(Integer noteId);

    @Update("UPDATE NOTES SET notetitle = #{title}, notedescription = #{description} WHERE noteid = #{noteId}")
    void updateNote(String Title, String description, Integer noteId);
}

