package Fredrick.Li.Personal.Cloud.Storage.controller;

import Fredrick.Li.Personal.Cloud.Storage.model.User;
import Fredrick.Li.Personal.Cloud.Storage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller()
@RequestMapping("/signup")

public class SignupController {
    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signUpView(){
        return "signup";
    }

    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String signupError = null;

        if (!userService.isUserNameAvailable(user.getUserName())){
            signupError = "The username already exists.";
        }

        // add user into database
        if (signupError == null) {
            int rowsAdded = userService.createUser(user);
            if (rowsAdded < 0) {
                signupError = "Please try again.";
            }
        }


        if (signupError == null) {
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", signupError);
        }

        return "signup";
    }
}
