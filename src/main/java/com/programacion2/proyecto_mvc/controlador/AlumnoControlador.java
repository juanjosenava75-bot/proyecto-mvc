package com.programacion2.proyecto_mvc.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.programacion2.proyecto_mvc.dominio.Alumno;
import com.programacion2.proyecto_mvc.servicio.IServicio;

// Registra esta clase como un controlador de Spring MVC.
@Controller
public class AlumnoControlador {

    private final IServicio<Alumno> servicio;

    // Spring inyecta el servicio por el único constructor, sin usar @Autowired.
    public AlumnoControlador(IServicio<Alumno> servicio) {
        this.servicio = servicio;
    }

    // Atiende GET / y devuelve la vista principal.html.
    @GetMapping("/")
    public String principal() {
        return "principal";
    }

    // Atiende GET /alumnos y muestra la lista en persona.html.
    @GetMapping("/alumnos")
    public String listar(Model model) {
        // Deja la lista disponible para Thymeleaf con el nombre "alumnos".
        model.addAttribute("alumnos", servicio.consultar());
        return "persona";
    }

    // Atiende GET /alumnos/nuevo y abre el formulario nueva.html.
    @GetMapping("/alumnos/nuevo")
    public String nuevo(Model model) {
        // Proporciona un objeto vacío para vincularlo con el formulario.
        model.addAttribute("alumno", new Alumno());
        return "nueva";
    }

    // Atiende POST /alumnos cuando se envía el formulario.
    @PostMapping("/alumnos")
    public String guardar(
            // Vincula los campos enviados con las propiedades de Alumno.
            @ModelAttribute("alumno") Alumno alumno) {

        servicio.guardar(alumno);

        // Hace que el navegador vuelva a pedir el listado con un GET.
        return "redirect:/alumnos";
    }
}