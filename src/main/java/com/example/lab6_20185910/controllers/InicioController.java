package com.example.lab6_20185910.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class InicioController {
    @GetMapping("")
    public String ind(){
        return "ind";
    }
}
