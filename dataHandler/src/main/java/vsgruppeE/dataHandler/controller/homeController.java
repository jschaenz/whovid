package vsgruppeE.dataHandler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    
    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("stats");
        return "homepage";
    }
}