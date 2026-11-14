package com.programacion2.proyecto_mvc.repositorio;

import java.util.List;

public interface IRepositorio<T> {

    void guardar(T objeto);

    void guardar(List<T> objetos);

    T consultar(Class<T> clase, int id);

    List<T> listar(Class<T> clase);

    List<T> buscarPorNombre(String nombre,Class<T> clase) ;

   void eliminar(Class<T> clase, int id);
}
