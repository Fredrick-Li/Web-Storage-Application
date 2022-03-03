package Fredrick.Li.Personal.Cloud.Storage.model;

public class Notes {
    private Integer noteId;
    private String noteTitle;
    private String noteDescription;
    private Integer userId;

    public Notes(Integer noteId, String noteTitle, String noteDescription, Integer userId){
        this.noteId = noteId;
        this.userId = userId;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
    }

    public Notes(String noteTitle, String noteDescription){
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
    }
    // get method
    public Integer getNoteId(){
        return noteId;
    }
    public Integer getUserID(){
        return userId;
    }
    public String getNoteTitle(){
        return noteTitle;
    }
    public String getNoteDescription(){
        return noteDescription;
    }

    // set method
    public void setNoteId(Integer noteID){
        this.noteId = noteID;
    }
    public void setUserId(Integer userID){
        this.userId = userID;
    }
    public void setNoteTitle(String noteTitle){
        this.noteTitle = noteTitle;
    }
    public void setNoteDescription(String noteDescription){
        this.noteDescription = noteDescription;
    }
}
