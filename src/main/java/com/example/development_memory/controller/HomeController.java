package com.example.development_memory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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

}
