package Fredrick.Li.Personal.Cloud.Storage.model;

public class Files {
    private int fileId;
    private String fileName;
    private String contentType;
    private String fileSize;
    private Integer userId;
    private byte[] fileData;

    public Files (int fileId, String fileName, String contentType, String fileSize, Integer userID, byte[] fileData){
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userID;
        this.fileData = fileData;
    }

    public int getFileIdID(){
        return fileId;
    }
    public String getFileName(){
        return fileName;
    }
    public String getContentType(){
        return contentType;
    }
    public String getFileSize(){
        return fileSize;
    }
    public Integer getUserID(){
        return userId;
    }
    public byte[] getFileData(){
        return fileData;
    }

    public void setFileIdID(int fileId){
        this.fileId = fileId;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public void setContentType(String contentType){
        this.contentType = contentType;
    }
    public void setFileSize(String fileSize){
        this.fileSize =fileSize;
    }
    public void setUserID(Integer userID){
        this.userId = userID;
    }
    public void setFileData(byte[] fileData){
        this.fileData =fileData;
    }

}
