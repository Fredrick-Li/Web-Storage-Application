package Fredrick.Li.Personal.Cloud.Storage.service;

import Fredrick.Li.Personal.Cloud.Storage.mapper.NotesMapper;
import Fredrick.Li.Personal.Cloud.Storage.mapper.UserMapper;
import Fredrick.Li.Personal.Cloud.Storage.model.Notes;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NoteService {
    private final NotesMapper notesMapper;
    private final UserMapper userMapper;

    public NoteService(NotesMapper notesMapper, UserMapper userMapper){
        this.notesMapper = notesMapper;
        this.userMapper = userMapper;
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating note bean.");
    }


    public void addNote(String noteTitle, String noteDescription, String userName){
        Integer userId = userMapper.getUser(userName).getUserID();
        Notes newNote = new Notes(0, noteTitle, noteDescription, userId);
        notesMapper.insert(newNote);
    }

    public List<Notes> getAllNote(Integer userId){
        return notesMapper.getNoteByUserId(userId);
    }
    public Notes getNote(Integer noteId){
        return notesMapper.getNoteById(noteId);
    }
    public void deleteNote(Integer noteId){
        notesMapper.delete(noteId);
    }
    public void updateNote(String noteTitle, String noteDescription, Integer noteId){
        notesMapper.updateNote(noteTitle, noteDescription, noteId);

    }


}
