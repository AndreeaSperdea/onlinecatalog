package com.andreea.onlinecatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/")
    //home- localhost 8080- returneaza un tip string. cand apelam 8080 ne afiseaza pagina index.html din templates
    public String index() {
        return "index";
    }
}
