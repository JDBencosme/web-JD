package org.pucmm;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.pucmm.Usuario;
import servicios.FakeServices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;
import static util.RolesApp.ROLE_ADMIN;


public class Main {
    public static void main(String[] args) {
        //Ejemplo hola mundo
        String mensaje = "Hola Mundo en Javalin :-D";
        System.out.println(mensaje);

        //Creando la instancia del servidor y configurando.
        Javalin app = Javalin.create(config -> {
            //configurando los documentos estaticos.
            config.staticFiles.add(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/static";
                staticFileConfig.location = Location.CLASSPATH;
                staticFileConfig.precompress = false;
                staticFileConfig.aliasCheck = null;
            });

            config.fileRenderer(new JavalinThymeleaf());

        }).start(7070);

        Usuario usuario = new Usuario();

        app.get("/", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("Inicio", "Inicio");
            ctx.sessionAttribute("usuario", usuario);
            modelo.put("usuario", usuario);
            ctx.render("static/index.html", modelo);
        });

        app.get("/tienda", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("Tienda", "Tienda");
            modelo.put("nombre", ctx.sessionAttribute("nombre"));
            modelo.put("rol", ctx.sessionAttribute("rol"));
            ctx.render("static/products.html", modelo);
        });

        app.get("/login", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("Login", "Login");
            modelo.put("nombre", ctx.sessionAttribute("nombre"));
            modelo.put("rol", ctx.sessionAttribute("rol"));
            ctx.render("static/login.html", modelo);
        });

        app.post("/login", ctx -> {
            String username = ctx.formParam("username");
            String name = ctx.formParam("name");
            String password = ctx.formParam("password");
            Map<String, Object> modelo = new HashMap<>();

            if (username != null && password != null) {
                ctx.sessionAttribute("nombre", username);
                if(username.equals("admin")){
                    ctx.sessionAttribute("rol", ROLE_ADMIN);
                }
                Usuario nuevoUsuario = FakeServices.getInstancia().autheticarUsuario(username, name);
                FakeServices.getInstancia().crearUsuario(usuario);
                ctx.redirect("/");
            } else {
                ctx.redirect("/login?error=Invalid username or password");
            }
        });


    }


}