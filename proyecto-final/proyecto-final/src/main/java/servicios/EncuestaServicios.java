package servicios;


import dev.morphia.experimental.MorphiaSession;
import org.bson.types.ObjectId;
import entidades.Encuesta;

import java.util.List;

import static dev.morphia.query.experimental.filters.Filters.eq;

public class EncuestaServicios extends GestionDb<Encuesta> {

    private static EncuestaServicios instancia;

    private EncuestaServicios() {
        super(Encuesta.class);
    }

    public static EncuestaServicios getInstancia() {
        if (instancia == null) {
            instancia = new EncuestaServicios();
        }
        return instancia;
    }

    public List<Encuesta> getFormsByUser(ObjectId id) {
        try (MorphiaSession session = getDatastore().startSession()) {
            return session.find(Encuesta.class).filter(eq("user", id)).stream().toList();
        } catch (Exception e) {
            return null;
        }
    }

}
