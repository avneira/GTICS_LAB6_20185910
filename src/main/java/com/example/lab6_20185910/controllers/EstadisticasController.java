package com.example.lab6_20185910.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


    @Controller
    @RequestMapping("/estadisticas")
    public class EstadisticasController {
        @GetMapping("/verEstadisticas")
        public String index(){
            return "Equipos/estadisticasLista";
        }
    }

