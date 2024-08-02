package servicios;

import org.pucmm.Producto;
import org.pucmm.Usuario;
import org.pucmm.CarroCompras;
import org.pucmm.ventaProductos;
import util.NoExisteEstudianteException;
import util.RolesApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class FakeServices {

    private static FakeServices instancia;
    private List<Producto> listaProducto = new ArrayList();
    private List<Usuario> listaUsuarios = new ArrayList();

    private FakeServices() {
        this.listaProducto.add(new Producto(1,"Chocolate",49.99));
        this.listaUsuarios.add(new Usuario("admin", "admin", "admin", Set.of(RolesApp.ROLE_ADMIN, RolesApp.CUALQUIERA, RolesApp.LOGUEADO)));
        this.listaUsuarios.add(new Usuario("logueado", "logueado", "logueado", Set.of(RolesApp.CUALQUIERA)));
        this.listaUsuarios.add(new Usuario("usuario", "usuario", "1234", Set.of(RolesApp.ROLE_USUARIO)));
    }

    public static FakeServices getInstancia() {
        if (instancia == null) {
            instancia = new FakeServices();
        }

        return instancia;
    }

    public Usuario autheticarUsuario(String usuario, String password) {
        return new Usuario(usuario, "Usuario " + usuario, password);
    }

    public List<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }

    public List<Producto> listarProducto() {
        return this.listaProducto;
    }

    public Producto getProductoPorId(int id) {
        return listaProducto.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public Producto crearProducto(Producto Producto) {
        if (this.getProductoPorId(Producto.getId()) != null) {
            System.out.println("Producto registrado...");
            return null;
        } else {
            this.listaProducto.add(Producto);
            return Producto;
        }
    }


    public void crearUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }




}
