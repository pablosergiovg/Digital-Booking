package com.ProyectoIntegrador.ProyectoIntegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping
            (value={"/", "/home", "/productos/**"})

    public String welcome() { return "index"; }
}
