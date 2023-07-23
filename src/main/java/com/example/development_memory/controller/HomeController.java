package com.example.development_memory.controller;

import com.example.development_memory.dto.PortfolioDTO;
import com.example.development_memory.service.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public String list(Model model){
        List<PortfolioDTO> portfolio = portfolioService.portfolioList();
        model.addAttribute("portfolio", portfolio);

        System.out.println(portfolio);

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
