package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<User> users = us.userList();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        us.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String pageUpdateUser(@RequestParam int id, Model model) {
        model.addAttribute("user", us.getOneUser(id));
        return "update";
    }

    @PostMapping("/update")
    public String UpdateUser(@ModelAttribute("user") @Valid User userUpd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        us.updateUser(userUpd);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        us.removeUser(id);
        return "redirect:/";
    }

}