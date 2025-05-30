package com.jonas.springdemo.controller;

import com.jonas.springdemo.model.User;
import com.jonas.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }

    @GetMapping("/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("isNew", true);
        return "users/form";
    }

    @PostMapping
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String viewUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "users/view";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        model.addAttribute("isNew", false);
        return "users/form";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id); // 确保ID正确设置
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/deactivate")
    public String deactivateUser(@PathVariable Long id) {
        userService.deactivateUser(id);
        return "redirect:/users";
    }
}