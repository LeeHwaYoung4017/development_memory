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
    public String list(Model model) {
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

    @GetMapping("/view/{num}")
    public String view(Model model, @PathVariable("num") String num) {
        PortfolioDTO portfolioDTO = portfolioService.readView(num);
        portfolioService.readCountUp(num);
        model.addAttribute("portfolio",portfolioDTO);

        return "view";
    }

    @RequestMapping("/delete/{num}")
    public String delete(@PathVariable("num") String num, Model model) {
        portfolioService.deletePortfolio(num);

        List<PortfolioDTO> portfolio = portfolioService.portfolioList();
        model.addAttribute("portfolio", portfolio);

        return "redirect:../list";
    }

    @RequestMapping("/update/{num}")
    public String update(@PathVariable("num") String num, Model model) {

        PortfolioDTO portfolioDTO = portfolioService.readView(num);
        model.addAttribute("portfolioDTO", portfolioDTO);

        return "update";
    }

    @PostMapping("/updateSuccess")
    public String updateSuccess(@ModelAttribute PortfolioDTO portfolioDTO){
        portfolioService.updateSuccess(portfolioDTO);

        return "redirect:list";
    }
}
