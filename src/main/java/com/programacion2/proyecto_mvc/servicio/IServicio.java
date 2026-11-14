package com.programacion2.proyecto_mvc.servicio;

import java.util.List;

public interface IServicio<T> {

    void  guardar (T objeto);
    List <T> consultar ();
    void actualizar(int id,T datosFormularios);
    T consultarPorId (int id);
    void eliminar(int id);

}
