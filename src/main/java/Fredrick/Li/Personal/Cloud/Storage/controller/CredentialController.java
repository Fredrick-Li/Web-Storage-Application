package Fredrick.Li.Personal.Cloud.Storage.controller;

import Fredrick.Li.Personal.Cloud.Storage.model.*;
import Fredrick.Li.Personal.Cloud.Storage.service.CredentialService;
import Fredrick.Li.Personal.Cloud.Storage.service.EncryptionService;
import Fredrick.Li.Personal.Cloud.Storage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Base64;

@Controller
@RequestMapping("credential")
public class CredentialController {

    private final CredentialService credentialService;
    private final EncryptionService encryptionService;
    private final UserService userService;

    public CredentialController(CredentialService credentialService, EncryptionService encryptionService, UserService userService) {
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
        this.userService = userService;
    }

    @GetMapping
    public String getHomePage(
            Authentication authentication, @ModelAttribute("newFile") FileForm newFile,
            @ModelAttribute("newCredential") CredentialForm newCredential,
            @ModelAttribute("newNote") NoteForm newNote, Model model) {
        String userName = authentication.getName();
        User user = userService.getUser(userName);
        model.addAttribute("credentials", this.credentialService.getAllCredentials(user.getUserID()));
        model.addAttribute("encryptionService", encryptionService);

        return "home";
    }

    @PostMapping("add-credential")
    public String newCredential(
            Authentication authentication, @ModelAttribute("newFile") FileForm newFile,
            @ModelAttribute("newCredential") CredentialForm newCredential,
            @ModelAttribute("newNote") NoteForm newNote, Model model) {
        String userName = authentication.getName();
        String newUrl = newCredential.getURL();
        String credentialIdStr = newCredential.getCredentialId();
        String password = newCredential.getPassword();

        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(password, encodedKey);

        if (credentialIdStr.isEmpty()) {
            credentialService.addCredential(newUrl, userName, encodedKey, encryptedPassword);
        } else {
            Credentials existingCredential = getCredential(Integer.parseInt(credentialIdStr));
            credentialService.updateCredential(newUrl, encodedKey, encryptedPassword, newCredential.getUserName(), existingCredential.getCredentialID());
        }
        User user = userService.getUser(userName);
        model.addAttribute("credentials", credentialService.getAllCredentials(user.getUserID()));
        model.addAttribute("encryptionService", encryptionService);
        model.addAttribute("result", "success");

        return "result";
    }

    @GetMapping(value = "/get-credential/{credentialId}")
    public Credentials getCredential(@PathVariable Integer credentialId) {
        return credentialService.getCredential(credentialId);
    }

    @GetMapping(value = "/delete-credential/{credentialId}")
    public String deleteCredential(
            Authentication authentication, @PathVariable Integer credentialId,
            @ModelAttribute("newCredential") CredentialForm newCredential,
            @ModelAttribute("newFile") FileForm newFile,
            @ModelAttribute("newNote") NoteForm newNote, Model model) {
        credentialService.deleteCredential(credentialId);
        String userName = authentication.getName();
        User user = userService.getUser(userName);
        model.addAttribute("credentials", credentialService.getAllCredentials(user.getUserID()));
        model.addAttribute("encryptionService", encryptionService);
        model.addAttribute("result", "success");

        return "result";
    }
}