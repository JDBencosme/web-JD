package REST;

import io.javalin.http.Handler;
import javalinjwt.JavalinJWT;
import Controladores.LoginControlador;
import entidades.Encuesta;
import entidades.Foto;
import entidades.Usuario;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Optional;
import static org.pucmm.Main.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestControlador {

    public static Handler formsXuser = ctx -> {
        Optional<DecodedJWT> decodedJWT = JavalinJWT.getTokenFromHeader(ctx)
                .flatMap(provider::validateToken);

        if (!decodedJWT.isPresent()) {
            ctx.status(401).result("Missing or invalid token");
        }
        else {
            try {
                String user =  ctx.queryParam("usuario");
                if (user == null) {
                    ctx.json(encuestaServicios.findAll());
                }else{
                    Usuario usuario = usuarioServices.getUsuarioByUsername(user.toLowerCase());
                    if(usuario != null){
                        ctx.json(encuestaServicios.getFormsByUser(usuario.getId()));
                    }else{
                        ctx.result("Este usuario no existe");
                    }
                }
            } catch (Exception e) {
                ctx.result("Ocurrio un error inesperado");
            }
        }
    };

    public static Handler crearForm = ctx -> {
        Optional<DecodedJWT> decodedJWT = JavalinJWT.getTokenFromHeader(ctx)
                .flatMap(provider::validateToken);

        if (!decodedJWT.isPresent()) {
            ctx.status(401).result("Missing or invalid token");
        }
        else {
            try {
                //parseando la informacion del POJO debe venir en formato json.
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(ctx.body());

                Foto foto = fotoServices.crear(new Foto(jsonNode.get("nombre").toString().replaceAll("\"", ""), jsonNode.get("mimetype").toString().replaceAll("\"", ""), jsonNode.get("base64").toString().replaceAll("\"", "")));

                Encuesta form = encuestaServicios.crear(new Encuesta(jsonNode.get("nombre").toString().replaceAll("\"", ""), jsonNode.get("sector").toString().replaceAll("\"", ""), jsonNode.get("nivel").toString().replaceAll("\"", ""), usuarioServices.getUsuarioByUsername(decodedJWT.get().getClaim("name").asString()), jsonNode.get("latitude").toString().replaceAll("\"", ""), jsonNode.get("longitude").toString().replaceAll("\"", ""), jsonNode.get("accuracy").toString().replaceAll("\"", ""), foto));

                if(form != null){
                    ctx.json(encuestaServicios.crear(form));
                } else{
                    ctx.result("No se pudo crear el Encuesta");
                }
            } catch (Exception e) {
                ctx.result("Ocurrio un error inesperado; No se pudo crear el Encuesta");
            }
        }
    };

    public static Handler loginPost = ctx -> {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(ctx.body());
            if(LoginControlador.authenticate(jsonNode.get("usuario").toString().toLowerCase().replaceAll("\"", ""), jsonNode.get("clave").toString().replaceAll("\"", ""))){
                Usuario user = usuarioServices.getUsuarioByUsername(jsonNode.get("usuario").toString().replaceAll("\"", ""));
                // generate a token for the user
                String token = provider.generateToken(user);
                ctx.json(new JWTResponse(token));
            }else{
                ctx.result("Login incorrecto");
            }
        } catch (Exception e) {
            ctx.result("Ocurrio un error inesperado");
        }
    };



}
