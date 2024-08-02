package org.pucmm;




//import javax.annotation.PostConstruct;
import util.RolesApp;

import java.util.Collections;
import java.util.Set;

public class Usuario {
    private String usuario;
    private String nombre;
    private String password;
    Set<RolesApp> rol;

    public Usuario(){}

    public Usuario(String usuario, String nombre, String password) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;
    }

    public Usuario(String usuario, String nombre, String password, Set<RolesApp> rol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
