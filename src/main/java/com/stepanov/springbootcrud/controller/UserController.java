package com.stepanov.springbootcrud.controller;

import com.stepanov.springbootcrud.entity.User;
import com.stepanov.springbootcrud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listAllUsers(Model model) {

        model.addAttribute("users", userService.findAll());

        return "/users/list-users";
    }

    @GetMapping("/new")
    public String showFormForNewUser(Model model) {

        model.addAttribute("user", new User());

        return "/users/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.save(user);

        return "redirect:/users";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("userId") int id, Model model) {

        model.addAttribute(userService.findById(id));

        return "users/user-form";
    }

    @DeleteMapping(value = "/delete")
    public String delete(@RequestParam("userId") int id) {

        userService.deleteById(id);

        return "redirect:/users";
    }
}
