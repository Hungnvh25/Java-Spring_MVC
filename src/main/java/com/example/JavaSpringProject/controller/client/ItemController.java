package com.example.JavaSpringProject.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    @GetMapping("/product/{productId}")
    public String getProductPage(Model model, @PathVariable long productId) {
        return "client/product/detail";
    }
}
