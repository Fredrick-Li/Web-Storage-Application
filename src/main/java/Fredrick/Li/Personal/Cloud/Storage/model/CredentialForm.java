package Fredrick.Li.Personal.Cloud.Storage.model;

public class CredentialForm {
    private String url;
    private String username;
    private String credentialId;
    private String password;


    public void setURL(String URL){
        this.url = URL;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUserName(String username){
        this.username = username;
    }
    public void setCredentialId(String credentialId){
        this.credentialId = credentialId;
    }

    public String getURL(){
        return url;
    }
    public String getUserName(){
        return username;
    }
    public String getCredentialId(){
        return credentialId;
    }
    public String getPassword(){
        return password;
    }

}
