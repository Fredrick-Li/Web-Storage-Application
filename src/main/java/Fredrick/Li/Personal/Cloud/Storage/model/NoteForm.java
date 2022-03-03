package Fredrick.Li.Personal.Cloud.Storage.model;

public class NoteForm {
    private String noteId;
    private String title;
    private String description;

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setNoteId(String noteId){this.noteId = noteId;}

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getNoteId(){return noteId;}
}
