package util;

public class Path {
    public static class Web {
        public static final String INDEX = "/";
        // ENCUESTAS
        public static final String FETCH_ENCUESTAS = "/encuestas";
        public static final String VER = "/encuesta";
        // USUARIOS
        public static final String FETCH_USUARIOS = "/usuarios";
        public static final String CREAR_EDITAR_USUARIO = "/usuario";
        public static final String ELIMINAR_USUARIO = "/eliminarUsuario";
        // LOGIN/OUT
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
    }

    public static class Template {
        public static final String LOGIN = "/publico/page-login.vm";
        public static final String VER = "/publico/encuesta.vm";
        public static final String INDEX = "/publico/index.vm";
        public static final String ERROR_400 = "/publico/page-error-400.vm";
        public static final String ERROR_403 = "/publico/page-error-403.vm";
        public static final String ERROR_404 = "/publico/page-error-404.vm";
        public static final String ERROR_500 = "/publico/page-error-500.vm";
        public static final String ERROR_503 = "/publico/page-error-503.vm";
        public static final String CREAR_EDITAR_USUARIO = "/publico/usuario.vm";
        public static final String FETCH_ENCUESTA = "/publico/tablaEncuesta.vm";
        public static final String FETCH_USUARIO = "/publico/tablaUsuario.vm";
    }
}