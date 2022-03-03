package Fredrick.Li.Personal.Cloud.Storage.model;

public class User {
    private Integer userId;
    private String username;
    private String salt;
    private String password;
    private String firstName;
    private String lastName;


    // constructor
    public User(Integer userId, String username, String salt, String password, String firstName, String lastName){
        this.userId = userId;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // get method
    public Integer getUserID(){
        return userId;
    }
    public String getUserName(){
        return username;
    }
    public String getSalt(){
        return salt;
    }
    public String getPassword(){
        return password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    // set method
    public void setUserID(Integer userID){
        this.userId = userID;
    }
    public void setUserName(String userName){
        this.username = userName;
    }
    public void setSalt(String salt){
        this.salt = salt;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }


}
