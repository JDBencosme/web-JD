package org.pucmm;

import java.math.BigDecimal;

public class Producto {
    private int id;
    private String nombre;
    private Double precio;


    public Producto(){}


    public Producto(int id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;

    }

    public void mezclar(Producto e){
        id = e.getId();
        nombre = e.getNombre();
        precio = e.getPrecio();
    }


    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
