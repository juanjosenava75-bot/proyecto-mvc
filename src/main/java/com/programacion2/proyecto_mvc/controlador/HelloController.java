package com.programacion2.proyecto_mvc.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "nombre", defaultValue = "Word") 
    String nombre , Model model) {

        model.addAttribute("nombre", nombre);
        return "hello";
    }

}
