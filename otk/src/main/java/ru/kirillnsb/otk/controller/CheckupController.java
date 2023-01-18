package ru.kirillnsb.otk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kirillnsb.otk.model.Checkup;
import ru.kirillnsb.otk.service.CheckupService;
import ru.kirillnsb.otk.service.UserService;

import java.util.List;

//import javax.validation.Valid;

@Controller
//@RequestMapping("/checkups")
public class CheckupController {

    private final CheckupService checkupService;
    private final UserService userService;
    @Autowired
    public CheckupController(CheckupService checkupService, UserService userService) {
        this.checkupService = checkupService;
        this.userService = userService;
    }
//    @GetMapping()
//    public String index(@ModelAttribute User currentUser, Model model) {
//        //UserService currentUser = (User)authedUser;
//        model.addAttribute("userLogin", currentUser);
//        return "checkup_page";
//    }
//    @GetMapping("/new")
//    public String newCheckup(Model model) {
//        return "new_checkup";
//    }

    @GetMapping("/checkups")
    public String findAll(Model model){
        List<Checkup> checkups = checkupService.findAll();
        model.addAttribute("checkups", checkups);
        return "checkup_page";
    }

    @GetMapping("/new-checkup")
    public String createCheckupForm(Checkup checkup){
        return "new_checkup";
    }

    @PostMapping("/new-checkup")
    public String createCheckup(Checkup checkup){
        checkupService.saveCheckup(checkup);
        return "redirect:/checkups";
    }

    @GetMapping("checkup-delete/{id}")
    public String deleteCheckup(@PathVariable("id") Long id){
        checkupService.deleteById(id);
        return "redirect:/checkups";
    }

    @GetMapping("/checkup-update/{id}")
    public String updateCheckupForm(@PathVariable("id") Long id, Model model){
        Checkup checkup = checkupService.findById(id);
        model.addAttribute("checkup", checkup);
        return "checkup_update";
    }

    @PostMapping("/checkup-update")
    public String updateCheckup(Checkup checkup){
        checkupService.saveCheckup(checkup);
        return "redirect:/checkups";
    }

}
