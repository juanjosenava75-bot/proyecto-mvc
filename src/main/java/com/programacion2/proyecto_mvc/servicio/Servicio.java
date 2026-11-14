package com.programacion2.proyecto_mvc.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion2.proyecto_mvc.dominio.Alumno;

import com.programacion2.proyecto_mvc.repositorio.IRepositorio;

// Registra esta clase como un componente de la capa de servicios.
@Service
public class Servicio implements IServicio<Alumno> {

    // Spring inyecta el repositorio en este atributo.
    @Autowired
    private IRepositorio<Alumno> repositorio;

    // Anotación de Java: verifica que implementamos un método de IServicio.
    @Override
    public void guardar(Alumno objeto) {
        repositorio.guardar(objeto);
    }

    // Implementa el método de consulta definido en IServicio.
    @Override
    public List<Alumno> consultar() {
        return repositorio.listar(Alumno.class);
    }

    @Override
    public void actualizar(int id, Alumno datosFormulario) {
        // Recupera el alumno existente y lo devuelve separado al hacer commit.
        Alumno alumno = repositorio.consultar(Alumno.class, id);

        // Modifica el objeto separado con los datos del formulario.
        alumno.setNombre(datosFormulario.getNombre());
        alumno.setApellido(datosFormulario.getApellido());

        // makePersistent vuelve a adjuntar el alumno y el commit guarda los cambios.
        repositorio.guardar(alumno);
    }

    @Override
    public Alumno consultarPorId(int id) {
        return repositorio.consultar(Alumno.class, id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(Alumno.class, id);
    }
}