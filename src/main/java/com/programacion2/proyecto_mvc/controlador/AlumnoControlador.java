package com.programacion2.proyecto_mvc.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.programacion2.proyecto_mvc.dominio.Alumno;
import com.programacion2.proyecto_mvc.servicio.IServicio;

@Controller 
public class AlumnoControlador {

    private final IServicio<Alumno> servicio;

    public AlumnoControlador(IServicio<Alumno> servicio) {
        this.servicio = servicio;
    }
    @GetMapping ("/")
    public String principal() {
        return "principal";
    }

    @GetMapping ("/alumnos")
    public  String listar (Model model){
        model.addAttribute("alumnos", servicio.consultar());
        return "persona";
    }

    @GetMapping ("/alumnos/nuevo")
    public  String nuevo (Model model){
        model.addAttribute("alumno", new Alumno());

        return "nueva";
    }

    @PostMapping ("/alumnos")
    public  String guardar (@ModelAttribute ("alumno") Alumno alumno){

        servicio.guardar(alumno);
        return "redirect:/alumnos";

    }

}
