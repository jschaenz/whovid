package vsgruppeE.dataHandler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vsgruppeE.dataHandler.service.dataHandlerService;

@Controller
public class homeController {
    
    @Autowired
    dataHandlerService handler;

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("stats",handler.data());
        return "homepage";
    }
}
