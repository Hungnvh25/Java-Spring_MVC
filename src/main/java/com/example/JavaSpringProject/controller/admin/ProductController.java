package com.example.JavaSpringProject.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.JavaSpringProject.domain.Product;
import com.example.JavaSpringProject.domain.User;

@Controller
public class ProductController {

    @GetMapping("/admin/product")
    public String getProduct() {
        return "/admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("createProduct", new Product());
        return "admin/product/create";
    }
    
    @PostMapping(value = "/admin/product/create")
    public String createProductPage(Model model,
            @ModelAttribute("createProduct") Product product,
            @RequestParam("avatarFile") MultipartFile file) {

        // String avatar = this.uploadService.handleSaveUploatFile(file, "avatars");
        // user.setAvatar(avatar);
        // user.setPassword(hashPassword);
        // user.setRole(this.userService.getRoleByName(user.getRole().getName()));
        // this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }
 
}
