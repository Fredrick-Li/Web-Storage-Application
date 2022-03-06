package Fredrick.Li.Personal.Cloud.Storage.model;

public class Credentials {
    private Integer credentialid;
    private String url;
    private String userName;
    private String key;
    private String password;
    private Integer userid;

    public Credentials(Integer credentialID, String url, String userName, String key, String password, Integer userID){
        this.credentialid  =credentialID;
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.password = password;
        this.userid = userID;
    }

    public Credentials(String url, String userName, String password){
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public Integer  getCredentialID(){
        return credentialid;
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
        return userid;
    }
    public String getKey(){return key;}

    public void setCredentialID(Integer credentialID){
        this.credentialid = credentialID;
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
        this.userid = userID;
    }
    public void setKey(String key){this.key = key;}
}
