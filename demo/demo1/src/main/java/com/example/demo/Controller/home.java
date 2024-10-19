package com.example.demo.Controller;

import com.example.demo.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home { // Rename the class to HomeController

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/user")
    public String details(Model model) { // Corrected method name from detals to details
        model.addAttribute("userName", "Nguyen Tan Quang");
        return "user";
    }
    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
//        System.out.println("firstName" + user.getFirstName());
//        System.out.println("lastName" + user.getLastName());
        model.addAttribute("userName", user.getFirstName() + " " + user.getLastName());
        return "addUser";

    }
}
