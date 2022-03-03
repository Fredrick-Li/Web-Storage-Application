package Fredrick.Li.Personal.Cloud.Storage.service;

import Fredrick.Li.Personal.Cloud.Storage.mapper.UserMapper;
import Fredrick.Li.Personal.Cloud.Storage.model.User;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Component
public class UserService {

    // we need UserMapper and HashMapper class to get/verify username and to create new user to insert into database
    private final UserMapper userMapper;
    private final HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService){
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean isUserNameAvailable(String username){
        return userMapper.getUser(username) == null;
    }

    public int createUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return userMapper.insert(new User(null, user.getUserName(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName()));
    }

    public User getUser(String userName){
        return userMapper.getUser(userName);
    }

    public User getUser(Integer userId){
        return userMapper.getUserById(userId);
    }


}
