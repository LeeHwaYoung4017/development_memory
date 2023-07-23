package com.example.development_memory.controller;

import com.example.development_memory.dto.PortfolioDTO;
import com.example.development_memory.service.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final PortfolioService portfolioService;

    public HomeController (PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/list")
    public String list(){
        return "list";
    }

    @RequestMapping("/insert")
    public String insert(){
        return "insert";
    }

    @PostMapping("/saveInsert")
    public String saveInsert(@ModelAttribute PortfolioDTO portfolioDTO) {
        portfolioService.saveInsert(portfolioDTO);

        return "redirect:list";
    }

}
