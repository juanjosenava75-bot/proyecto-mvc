package com.programacion2.proyecto_mvc.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("accionFormulario", "/alumnos");
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

    @GetMapping("/alumnos/{id}/editar")
    public String editar(@PathVariable("id") int id, Model model) {
        model.addAttribute("alumno", servicio.consultarPorId(id));
        model.addAttribute("accionFormulario", "/alumnos/" + id + "/editar");
        return "nueva";
    }

    @PostMapping("/alumnos/{id}/editar")
    public String actualizar(@PathVariable("id") int id,
            @ModelAttribute("alumno") Alumno datos) {
        servicio.actualizar(id, datos);

        return "redirect:/alumnos";
    }

    @PostMapping("/alumnos/{id}/eliminar")
    public String eliminar(@PathVariable("id") int id) {
        servicio.eliminar(id);
        return "redirect:/alumnos";
    }
}