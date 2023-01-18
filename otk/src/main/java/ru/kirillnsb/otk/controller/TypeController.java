package ru.kirillnsb.otk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kirillnsb.otk.model.Type;

@Controller
public class TypeController {
    @GetMapping("/type")
    public String createCheckupForm(Type type){
        return "types";
    }
}
