package Fredrick.Li.Personal.Cloud.Storage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/result")
public class ResultController {

    @GetMapping()
    public String resultView() {
        return "result";
    }
}