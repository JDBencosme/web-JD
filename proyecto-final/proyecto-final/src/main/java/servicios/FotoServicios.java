package servicios;

import entidades.Foto;

/**
 *
 */
public class FotoServicios extends GestionDb<Foto> {

    private static FotoServicios instancia;

    private FotoServicios(){
        super(Foto.class);
    }

    public static FotoServicios getInstancia(){
        if(instancia==null){
            instancia = new FotoServicios();
        }
        return instancia;
    }

}