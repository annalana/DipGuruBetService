package com.dipguru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndexPage(Model model) {
        return "index";
    }
    @PostMapping("/register")
    public String registerUser(Model model) {
        return "redirect:/lk";
    }
    @PostMapping("/customer")
    public String getCustomerApp(Model model) {
        return "customer";
    }
    @PostMapping("/author")
    public String getAuthorApp(Model model) {
        return "author";
    }
}
