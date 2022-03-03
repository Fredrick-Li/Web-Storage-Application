package Fredrick.Li.Personal.Cloud.Storage.model;

public class Credentials {
    private Integer credentialId;
    private String url;
    private String userName;
    private String key;
    private String password;
    private Integer userId;

    public Credentials(Integer credentialID, String url, String userName, String key, String password, Integer userID){
        this.credentialId  =credentialID;
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.password = password;
        this.userId = userID;
    }

    public Credentials(String url, String userName, String password){
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public Integer  getCredentialID(){
        return credentialId;
    }
    public String getURL(){
        return url;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public Integer getUserID(){
        return userId;
    }
    public String getKey(){return key;}

    public void setCredentialID(Integer credentialID){
        this.credentialId = credentialID;
    }
    public void setURL(String url){
        this.url = url;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUserID(Integer userID){
        this.userId = userID;
    }
    public void setKey(String key){this.key = key;}
}
