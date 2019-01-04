package com.lakazambia.selfcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value="/")
    public String index(){
        return "index";
    }

    @GetMapping(value="/registration")
    public String register(){
        return "registration";
    }

    @GetMapping(value="/login")
    public String login(){
        return "login";
    }

   

}
