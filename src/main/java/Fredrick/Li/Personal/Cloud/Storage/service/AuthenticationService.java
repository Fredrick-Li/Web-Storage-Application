package Fredrick.Li.Personal.Cloud.Storage.service;

import Fredrick.Li.Personal.Cloud.Storage.mapper.UserMapper;
import Fredrick.Li.Personal.Cloud.Storage.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AuthenticationService implements AuthenticationProvider{
    private final HashService hashService;
    private final UserMapper userMapper;

    public AuthenticationService(UserMapper userMapper, HashService hashService){
        this.hashService = hashService;
        this.userMapper = userMapper;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userMapper.getUser(userName);
        if(user != null){
            String hashedPassword = hashService.getHashedValue(password, user.getSalt());
            if(user.getPassword().equals(hashedPassword)){
                return new UsernamePasswordAuthenticationToken(userName, password, new ArrayList<>());
            }

        }
        return null;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
