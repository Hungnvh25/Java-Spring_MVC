package com.example.JavaSpringProject.controller.client;

import org.springframework.stereotype.Controller;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String getHomePage() {
        return "client/homepage/show";
    }
}
