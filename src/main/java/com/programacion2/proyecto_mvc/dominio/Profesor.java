package com.programacion2.proyecto_mvc.dominio;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable (detachable = "true")
public class Profesor extends Persona{

    @Persistent(mappedBy = "profesor",defaultFetchGroup = "true")
    private Materia materia;
    String especialidad;

    public Profesor() {
        super();
    }

    public Profesor(String nombre, String apellido, String especialidad) {
       super(nombre,apellido);
       this.especialidad = especialidad;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

        @Override
    public String toString() {
        return "Profesor{" +
                "id=" + getId() +
                ", nombre='" +getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", materia=" +
                (materia != null ? materia.getNombre() : "sin materia") +
                '}';
    }

}
