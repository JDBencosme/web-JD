package org.pucmm;

import java.util.List;

public class CarroCompras {
    int id;
    Usuario owner;
    List<Producto> listaProducto;

    public int getId() {
        return id;
    }

    public Usuario getOwner() {
        return owner;
    }

    public void setOwner(Usuario owner) {
        this.owner = owner;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public CarroCompras(int id, Usuario owner, List<Producto> listaProducto) {
        this.id = id;
        this.owner = owner;
        this.listaProducto = listaProducto;
    }
}
