package servicios;

import encapsulaciones.Compras;
import org.pucmm.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para encapsular los metodos de CRUD
 * Created by vacax on 30/04/16.
 */
public class ComprasServices {

    /**
     * Listado de los productos.
     * @return
     */
    public List<Producto> listaProducto() {
        List<Producto> lista = new ArrayList<>();
        Connection con = null; //objeto conexion.
        try {
            //
            String query = "select * from producto";
            con = DataBaseService.getInstancia().getConexion(); //referencia a la conexion.
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                Producto est = new Producto();
                est.setId(rs.getInt("Id"));
                est.setNombre(rs.getString("nombreProducto"));
                est.setPrecio(rs.getDouble("Precio"));


                lista.add(est);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

    /**
     * Retorna un producto dado su id
     * @param id
     * @return
     */
    public Producto getproducto(int id) {
        Producto est = null;
        Connection con = null;
        try {
            //utilizando los comodines (?)...
            String query = "select * from producto where matricula = ?";
            con = DataBaseService.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setInt(1, id);
            //Ejecuto...
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                est = new Producto();
                est.setId(rs.getInt("Id"));
                est.setNombre(rs.getString("nombre"));
                est.setPrecio(rs.getDouble("Precio"));


            }

        } catch (SQLException ex) {
            Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return est;
    }

    /**
     *
     * @param est
     * @return
     */
    public boolean crearproducto(Producto est){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "insert into producto(matricula, nombre, apellido, telefono, carrera) values(?,?,?,?,?)";
            con = DataBaseService.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setInt(1, est.getId());
            prepareStatement.setString(2, est.getNombre());
            prepareStatement.setDouble(3, est.getPrecio());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

    public boolean actualizarproducto(Producto est){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "update producto set nombre=?, apellido=?, carrera=?, telefono=? where matricula = ?";
            con = DataBaseService.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, est.getNombre());
            prepareStatement.setDouble(2, est.getPrecio());
            //Indica el where...
            prepareStatement.setInt(5, est.getId());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

    public boolean borrarproducto(int matricula){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "delete from producto where matricula = ?";
            con = DataBaseService.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);

            //Indica el where...
            prepareStatement.setInt(1, matricula);
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

}