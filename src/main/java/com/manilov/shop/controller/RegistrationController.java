package com.manilov.shop.controller;
import com.manilov.shop.domain.User;
import com.manilov.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("message", "");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        if(user.getUsername().contains(" ") || user.getUsername().equals("")){
            model.addAttribute("message", "Bad username");
            return "registration";
        }
        if(!userService.saveUser(user)) {
            model.addAttribute("message", "User exists");
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }
}