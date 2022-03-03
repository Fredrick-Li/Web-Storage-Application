package Fredrick.Li.Personal.Cloud.Storage.service;

import Fredrick.Li.Personal.Cloud.Storage.mapper.CredentialsMapper;
import Fredrick.Li.Personal.Cloud.Storage.model.Credentials;
import Fredrick.Li.Personal.Cloud.Storage.model.NoteForm;
import Fredrick.Li.Personal.Cloud.Storage.model.Notes;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CredentialService {
    private final CredentialsMapper credentialsMapper;
    private final UserService userService;

    public CredentialService(CredentialsMapper credentialsMapper, UserService userService){
        this.credentialsMapper = credentialsMapper;
        this.userService = userService;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating credentials bean.");
    }

    public void addCredential(String URL, String username, String key, String password){
        Integer userId = userService.getUser(username).getUserID();
        Credentials credential = new Credentials(0, URL, username, key, password, userId);
        credentialsMapper.insert(credential);
    }
    public List<Credentials> getAllCredentials(Integer userId){
        return credentialsMapper.getAllCredentials(userId);
    }

    public Credentials getCredential(Integer credentialId){
        return credentialsMapper.getCredential(credentialId);
    }
    public void deleteCredential(Integer credentialId){
        credentialsMapper.delete(credentialId);
    }

    public void updateCredential(String URL, String key, String password, String username, Integer credentialId){
        credentialsMapper.updateCredential(URL, key, password, username, credentialId);
    }

}
