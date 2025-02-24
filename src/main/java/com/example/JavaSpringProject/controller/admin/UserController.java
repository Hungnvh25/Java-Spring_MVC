package com.example.JavaSpringProject.controller.admin;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.JavaSpringProject.domain.Role;
import com.example.JavaSpringProject.domain.User;
import com.example.JavaSpringProject.service.UploadService;
import com.example.JavaSpringProject.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("createUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model,
            @ModelAttribute("createUser") @Valid User user,
            BindingResult newUserBindingResult,
            @RequestParam("avatarFile") MultipartFile file) {

        // validate
        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>>>>" + error.getField() + " - " + error.getDefaultMessage());
        }

        if (newUserBindingResult.hasErrors()) {
            return "admin/user/create";
        }

        String avatar = this.uploadService.handleSaveUploatFile(file, "avatars");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setAvatar(avatar);
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/{userId}")
    public String getUserPage(Model model, @PathVariable long userId) {
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "/admin/user/detail";
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
