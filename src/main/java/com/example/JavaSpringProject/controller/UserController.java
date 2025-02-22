package com.example.JavaSpringProject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.JavaSpringProject.domain.User;
import com.example.JavaSpringProject.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<User> users = this.userService.getAllUsersByEmail("2003nguyenvanhung7612119@gmail.com");
        System.out.println(users);
        return "hello";
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("createUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("createUser") User user) {
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/{userId}")
    public String getUserPage(Model model, @PathVariable long userId) {
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "/admin/user/show";
    }

    @GetMapping("/admin/user/update/{userId}")
    public String getUpdateUserPage(Model model, @PathVariable long userId) {
        User user = this.userService.getUserById(userId);
        model.addAttribute("User", user);
        return "/admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String UpdateUserPage(Model model, @ModelAttribute("User") User user) {
        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser != null) {
            currentUser.setFullName(user.getFullName());
            currentUser.setAddress(user.getAddress());
            currentUser.setPhone(user.getPhone());

            this.userService.handleSaveUser(currentUser);
        }

        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{userId}")
    public String deleteUserPage(Model model, @PathVariable long userId) {
        System.out.println("checking id: " + userId);
        this.userService.deleteUserById(userId);
        return "redirect:/admin/user";
    }
}
