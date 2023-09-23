package com.example.lab6_20185910.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipos")
public class EquiposController {
    @GetMapping("/verEquipos")
    public String ind(){
        return "Equipos/equiposLista";
    }
}