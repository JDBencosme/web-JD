package controladores;


import io.javalin.http.Handler;
import entidades.Encuesta;
import util.Path;
import util.RequestUtil;
import util.RolesApp;
import util.ViewUtil;
import java.util.Map;



import static org.pucmm.Main.encuestaServicios;
import static org.pucmm.Main.usuarioServices;

public class EncuestaControlador {
    public static Handler serveVerPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        Encuesta form = encuestaServicios.find(RequestUtil.getParamId(ctx));
        if(form != null){
            if(form.getUser().getUsuario().equalsIgnoreCase(RequestUtil.getSessionCurrentUser(ctx)) || usuarioServices.getUsuarioByUsername(RequestUtil.getSessionCurrentUser(ctx)).getRol().equals(RolesApp.ROLE_ADMIN)){
                model.put("form", form);
                ctx.render(Path.Template.VER, model);
            }else{
                ctx.sessionAttribute("encuestaFailed", true);
                ctx.sessionAttribute("mensaje","No puede ver esta encuesta porque no fue usted quien lo envio al servidor.");
                ctx.redirect(Path.Web.FETCH_ENCUESTAS);
            }
        } else{
            ctx.sessionAttribute("encuestaFailed", true);
            ctx.sessionAttribute("mensaje","Encuesta no encontrada.");
            ctx.redirect(Path.Web.FETCH_ENCUESTAS);
        }
    };

    public static Handler fetchAllEncuestas = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        if(usuarioServices.getUsuarioByUsername(RequestUtil.getSessionCurrentUser(ctx)).getRol().equals(RolesApp.ROLE_ADMIN)){
            model.put("forms", encuestaServicios.findAll());
        }else{
            model.put("forms", encuestaServicios.getFormsByUser(usuarioServices.getUsuarioByUsername(RequestUtil.getSessionCurrentUser(ctx)).getId()));
        }
        model.put("encuestaFailed", ctx.sessionAttribute("encuestaFailed"));
        model.put("mensaje", ctx.sessionAttribute("mensaje"));
        ctx.sessionAttribute("encuestaFailed", null);
        ctx.sessionAttribute("mensaje",null);
        ctx.render(Path.Template.FETCH_ENCUESTA, model);
    };
}