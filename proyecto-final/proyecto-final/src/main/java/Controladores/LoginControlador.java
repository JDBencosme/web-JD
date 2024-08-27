package controladores;

import io.javalin.http.Handler;
import java.util.Map;

import org.jasypt.util.text.BasicTextEncryptor;
import entidades.Usuario;
import util.RequestUtil;
import util.ViewUtil;
import util.Path;
import static org.pucmm.Main.*;

public class LoginControlador {
    public static boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Usuario user = usuarioServices.getUsuarioByUsername(username);
        if (user == null) {
            return false;
        }
        return password.equals(user.getClave());
    }
    public static Handler serveLoginPage = ctx -> {
        Map<String, Object> model = ViewUtil.baseModel(ctx);
        model.put("authenticationFailed", ctx.sessionAttribute("authenticationFailed"));
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPasswordCharArray("some-random-data".toCharArray());
        model.put("ckUser", textEncryptor.decrypt(ctx.cookie("user")));
        model.put("ckPwd", textEncryptor.decrypt(ctx.cookie("pwd")));
        ctx.sessionAttribute("authenticationFailed", null);
        ctx.render(Path.Template.LOGIN, model);
    };

    public static Handler handleLoginPost = ctx -> {
        if (!authenticate(RequestUtil.getQueryLoginUsername(ctx).toLowerCase(), RequestUtil.getQueryLoginPassword(ctx))) {
            ctx.sessionAttribute("authenticationFailed", true);
            ctx.redirect(Path.Web.LOGIN);
        } else {
            String user = RequestUtil.getQueryLoginUsername(ctx).toLowerCase();
            ctx.sessionAttribute("currentUser", user);
            usuarioActual = user;
            if(RequestUtil.getQueryLoginCookie(ctx)){
                BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
                textEncryptor.setPasswordCharArray("some-random-data".toCharArray());
                ctx.cookie("user", textEncryptor.encrypt(user), 604800);
                ctx.cookie("pwd", textEncryptor.encrypt(RequestUtil.getQueryLoginPassword(ctx)), 604800);
            } else{
                ctx.removeCookie("user");
                ctx.removeCookie("pwd");
            }
            ctx.redirect(Path.Web.INDEX);
        }
    };

    public static Handler handleLogoutPost = ctx -> {
        ctx.sessionAttribute("currentUser", null);
        usuarioActual = null;
        ctx.sessionAttribute("authenticationFailed", null);
        ctx.redirect(Path.Web.LOGIN);
    };


}
