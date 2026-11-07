package com.programacion2.proyecto_mvc.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion2.proyecto_mvc.dominio.Alumno;

import com.programacion2.proyecto_mvc.repositorio.IRepositorio;

@Service 
public class Servicio implements IServicio <Alumno> {

   @Autowired 
    private  IRepositorio <Alumno> repositorio ;

    @Override
    public void guardar(Alumno objeto) {
       repositorio.guardar(objeto);
    }

    @Override
    public List<Alumno> consultar() {
       return repositorio.listar(Alumno.class);
    }
}
