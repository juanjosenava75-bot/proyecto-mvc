package com.programacion2.proyecto_mvc.configuracion;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


// Indica que esta clase contiene configuración de Spring.
@Configuration

// @ComponentScan indica en qué paquetes buscar componentes de Spring.
// Acá es opcional: @SpringBootApplication ya escanea los subpaquetes.
// @ComponentScan(basePackages = {
//     "com.programacion2.proyecto_mvc.repositorio",
//     "com.programacion2.proyecto_mvc.servicio"
// })
public class Configuracion {

    // Registra la fábrica de persistencia como un bean de Spring.
    // destroyMethod indica que Spring debe llamar a close() al cerrar la aplicación.
    @Bean(destroyMethod = "close")
    public PersistenceManagerFactory persistenceManagerFactory() {
        return JDOHelper.getPersistenceManagerFactory("Programacion2");
    }
}