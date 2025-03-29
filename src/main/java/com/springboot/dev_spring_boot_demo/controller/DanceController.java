package com.springboot.dev_spring_boot_demo.controller;

import com.springboot.dev_spring_boot_demo.entity.Dance;
import com.springboot.dev_spring_boot_demo.service.DanceService;
import com.springboot.dev_spring_boot_demo.service.UploadService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/dances")
public class DanceController {
    private final DanceService danceService;
 private final UploadService uploadService;

 public DanceController(DanceService danceService, UploadService uploadService) {
    this.danceService = danceService;
    this.uploadService = uploadService;
}
   
    @PostMapping("/save")
    public String saveDance(@Valid @ModelAttribute("dance") Dance dance, BindingResult result,
                            @RequestParam("imageDance") MultipartFile file) {
        if (result.hasErrors()) {
            return "admin/dances/dance-form";
        }

        if (!file.isEmpty()) {
            String danceImage = uploadService.handleSaveUploadFile(file, "img");
            dance.setImageUrl(danceImage);
        }

        danceService.save(dance);
        return "redirect:/admin/dances/list";
    }

    

    @GetMapping("/list")
    public String listDances(Model model) {
        List<Dance> dances = danceService.findAll();
        model.addAttribute("dances", dances);
        return "admin/dances/dance-list";
    }

    @GetMapping("/form-insert")
    public String showInsertForm(Model model) {
        model.addAttribute("dance", new Dance());
        return "admin/dances/dance-form";
    }

    @GetMapping("/form-update")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Dance dance = danceService.findById(id);
        model.addAttribute("dance", dance);
        return "admin/dances/dance-form";
    }

    @GetMapping("/delete")
    public String deleteDance(@RequestParam("id") int id) {
        danceService.deleteById(id);
        return "redirect:/admin/dances/list";
    }
}
