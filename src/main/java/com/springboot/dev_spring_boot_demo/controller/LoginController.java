package com.springboot.dev_spring_boot_demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.dev_spring_boot_demo.entity.Dance;
import com.springboot.dev_spring_boot_demo.service.DanceService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private DanceService danceService;
    
    public LoginController(DanceService danceService) {
        this.danceService = danceService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/system")
    public String system() {
        return "system";
    }

    @GetMapping("/product")
    public String product(Model model) {
        List<Dance> dances = danceService.findAll();
        model.addAttribute("dances", dances);
        return "default/product";
    }
  
    @GetMapping("/about")
    public String about() {
        return "default/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "default/contact";
    }

    @GetMapping("/promo")
    public String promo() {
        return "default/promo";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/detailDance")
    public String detailDance(@RequestParam("id") int id, Model model) {
        Dance dance = danceService.findById(id);
        model.addAttribute("dance", dance);
        return "detailDance";
    }
}