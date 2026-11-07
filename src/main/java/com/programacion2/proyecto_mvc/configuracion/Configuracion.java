package com.programacion2.proyecto_mvc.configuracion;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration 
@ComponentScan  (basePackages = {"com.programacion2.repositorio","com.programacion2.servicio"})
public class Configuracion {

    @Bean (destroyMethod = "close")
    public  PersistenceManagerFactory persistenceManagerFactory (){

        return JDOHelper.getPersistenceManagerFactory("Programacion2");

    }


}
