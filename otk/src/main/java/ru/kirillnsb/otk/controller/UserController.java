package ru.kirillnsb.otk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kirillnsb.otk.model.User;
import ru.kirillnsb.otk.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "register";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("Reg req "+ user);
        User registeredUser = userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    public User authedUser;
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("Login req "+user);

        authedUser = userService.authUser(user.getLogin(), user.getPassword());
        if (authedUser == null){
            return "error_page";
        }else {
            model.addAttribute("userLogin", authedUser.getLogin() + " (ID:" + authedUser.getEmployee_id()+')');
            model.addAttribute("userCheckups", authedUser.getCheckupList());
            return "user_page";
        }
    }


}
