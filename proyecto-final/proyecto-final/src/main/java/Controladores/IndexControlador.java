package Controladores;

import io.javalin.http.Handler;
import entidades.Encuesta;
import entidades.Usuario;
import util.Path;
import util.RolesApp;
import util.ViewUtil;

import java.util.List;
import java.util.Map;

import static org.pucmm.Main.encuestaServicios;
import static org.pucmm.Main.usuarioServices;

public class IndexControlador {
    public static Handler serveIndexPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        List<Usuario> users = usuarioServices.findAll();
        List<Encuesta> forms = encuestaServicios.findAll();
        long admins = users.stream().filter(p -> p.getRol().equals(RolesApp.ROLE_ADMIN)).count();
        long usuarios = users.size();
        model.put("cantUsers",usuarios);
        model.put("cantAdmins", admins);
        model.put("cantAutor", usuarios-admins);
        model.put("cantForms", forms.size());
        model.put("forms", forms);
        ctx.render(Path.Template.INDEX, model);
    };
}
