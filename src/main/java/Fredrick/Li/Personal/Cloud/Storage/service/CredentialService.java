package Fredrick.Li.Personal.Cloud.Storage.service;

import Fredrick.Li.Personal.Cloud.Storage.mapper.CredentialsMapper;
import Fredrick.Li.Personal.Cloud.Storage.mapper.UserMapper;
import Fredrick.Li.Personal.Cloud.Storage.model.Credentials;
import Fredrick.Li.Personal.Cloud.Storage.model.NoteForm;
import Fredrick.Li.Personal.Cloud.Storage.model.Notes;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CredentialService {
    private final CredentialsMapper credentialsMapper;
    private final UserMapper userMapper;

    public CredentialService(CredentialsMapper credentialsMapper, UserMapper userMapper){
        this.credentialsMapper = credentialsMapper;
        this.userMapper = userMapper;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating credentials bean.");
    }

    public void addCredential(String URL, String username, String credentialUsername, String key, String password){
        Integer userId = userMapper.getUser(username).getUserID();
        Credentials credential = new Credentials(0, URL, credentialUsername, key, password, userId);
        credentialsMapper.insert(credential);
    }
    public Credentials[] getAllCredentials(Integer userId){
        return credentialsMapper.getAllCredentials(userId);
    }

    public Credentials getCredential(Integer credentialId){
        return credentialsMapper.getCredential(credentialId);
    }
    public void deleteCredential(Integer credentialId){
        credentialsMapper.delete(credentialId);
    }

    public void updateCredential(Integer credentialId, String newUserName, String url, String key, String password) {
        credentialsMapper.updateCredential(credentialId, newUserName, url, key, password);
    }

}
