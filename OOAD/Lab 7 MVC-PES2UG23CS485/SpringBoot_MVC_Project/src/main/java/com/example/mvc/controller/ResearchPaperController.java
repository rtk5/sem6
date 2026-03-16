package com.example.mvc.controller;

import com.example.mvc.model.ResearchPaper;
import com.example.mvc.service.ResearchPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResearchPaperController {

    @Autowired
    private ResearchPaperService service;

    // GET / → Display home page with form and list
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("paper", new ResearchPaper());
        model.addAttribute("papers", service.getAllPapers());
        return "index";
    }

    // POST /save → Save research paper
    @PostMapping("/save")
    public String savePaper(@ModelAttribute ResearchPaper paper, Model model) {
        String result = service.savePaper(paper);
        if (!result.equals("success")) {
            model.addAttribute("error", result);
            model.addAttribute("paper", paper);
            model.addAttribute("papers", service.getAllPapers());
            return "index";
        }
        return "redirect:/";
    }
}