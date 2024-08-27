package servicios;

import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.experimental.MorphiaSession;
import dev.morphia.query.Query;
import org.bson.types.ObjectId;
import java.util.List;

import static dev.morphia.query.experimental.filters.Filters.eq;

/**
 * Created by vacax on 03/06/16.
 */
public class GestionDb<T> {

    private static Datastore datastore;
    private final Class<T> claseEntidad;



    public GestionDb(Class<T> claseEntidad) {
        if(datastore == null) {
            datastore = Morphia.createDatastore(MongoClients.create("mongodb+srv://prueba2:deZfy9olGIvEl9hK@proyecto-final.fbm5h.mongodb.net/?retryWrites=true&w=majority&appName=Proyecto-final&ssl=true"), "final");
            datastore.getMapper().mapPackage("entidades");
            datastore.ensureIndexes();
        }
        this.claseEntidad = claseEntidad;
    }

    public Datastore getDatastore(){
        if(datastore == null) {
            datastore = Morphia.createDatastore(MongoClients.create("mongodb+srv://prueba2:deZfy9olGIvEl9hK@proyecto-final.fbm5h.mongodb.net/?retryWrites=true&w=majority&appName=Proyecto-final&ssl=true"), "final");
            datastore.getMapper().mapPackage("entidades");
            datastore.ensureIndexes();
        }
        return datastore;
    }


    public T crear(T entidad) throws IllegalArgumentException{

        try (MorphiaSession session = getDatastore().startSession()) {
            session.startTransaction();
            session.save(entidad);
            session.commitTransaction();
        }
        return entidad;
    }


    public T editar(T entidad){
        try (MorphiaSession session = getDatastore().startSession()) {
            session.startTransaction();
            session.merge(entidad);
            session.commitTransaction();
        }catch (Exception e){
            return null;
        }
        return entidad;
    }


    public boolean eliminar(T entidad){
        boolean ok = false;
        try {
            MorphiaSession session = getDatastore().startSession();
            try {
                session.startTransaction();
                session.delete(entidad);
                session.commitTransaction();
                ok = true;
            }finally {
                session.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ok;
    }


    public T find(String id) {
        try (MorphiaSession session = getDatastore().startSession()) {
            Query<T> objetos = session.find(claseEntidad).filter(eq("_id", new ObjectId(id)));
            return objetos.first();
        } catch (Exception e) {
            return null;
        }
    }


    public List<T> findAll(){
        try (MorphiaSession session = getDatastore().startSession()) {
            return session.find(claseEntidad).stream().toList();
        } catch (Exception e) {
            return null;
        }
    }
}