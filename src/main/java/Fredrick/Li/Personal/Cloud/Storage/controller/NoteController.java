package Fredrick.Li.Personal.Cloud.Storage.controller;

import Fredrick.Li.Personal.Cloud.Storage.model.*;
import org.springframework.web.bind.annotation.*;
import Fredrick.Li.Personal.Cloud.Storage.service.NoteService;
import Fredrick.Li.Personal.Cloud.Storage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;


@Controller()
@RequestMapping("note")
public class NoteController {
    private final UserService userService;
    private final NoteService noteService;

    public NoteController(UserService userService, NoteService noteService){
        this.userService =userService;
        this.noteService = noteService;
    }

    public Integer getUserId(Authentication authentication){
        String userName = authentication.getName();
        User user  = userService.getUser(userName);
        return user.getUserID();
    }

    @GetMapping(value= "/get-note/{noteId}")
    public Notes getNote(@PathVariable Integer noteId){
        return noteService.getNote(noteId);
    }

    @GetMapping(value ="/delete-note/{noteId}")
    public String deleteNote(Authentication authentication,@PathVariable Integer noteId, @ModelAttribute("newFile")FileForm newFile,
                              @ModelAttribute("newNote") NoteForm newNote,
                              @ModelAttribute("newCredential") CredentialForm newCredential, Model model){
        noteService.deleteNote(noteId);
        Integer userId = getUserId(authentication);
        model.addAttribute("Note", noteService.getAllNote(userId));
        model.addAttribute("result", "successfully deleted");

        return "result";

    }


    // display all existing notes
    @GetMapping
    public String getAllNote(Authentication authentication, @ModelAttribute("newFile") FileForm newFile,
                              @ModelAttribute("newNote") NoteForm newNote,
                              @ModelAttribute("newCredential") CredentialForm newCredential, Model model){
        Integer userId = getUserId(authentication);
        model.addAttribute("notes", this.noteService.getAllNote(userId));

        return "home";
    }

    // add note then display all
    @PostMapping("add-note")
    public String addNote(Authentication authentication, @ModelAttribute("newFile")FileForm newFile,
                          @ModelAttribute("newNote") NoteForm newNote,
                          @ModelAttribute("newCredential") CredentialForm newCredential, Model model){
        String userName = authentication.getName();;
        String noteTitle = newNote.getTitle();
        String noteDescription = newNote.getDescription();
        String noteId = String.valueOf(newNote.getNoteId());

        // if note has not been stored in database then it won't have an ID, simply add new one
        if(noteId.isEmpty()){
            noteService.addNote(noteTitle, noteDescription, userName);
        }else{
            // if there has already been an ID, then it's modification (optional)
            Notes oldNote = noteService.getNote(Integer.parseInt(noteId));
            noteService.updateNote(noteTitle, noteDescription, oldNote.getNoteId());
        }
        Integer userId = getUserId(authentication);
        model.addAttribute("notes", noteService.getAllNote(userId));
        model.addAttribute("result", "success");

        return "result";

    }


}