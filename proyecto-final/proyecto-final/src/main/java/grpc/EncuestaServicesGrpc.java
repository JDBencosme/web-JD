package grpc;

import encuestarn.EncuestaRnGrpc;
import encuestarn.EncuestaRnOuterClass;
import io.grpc.stub.StreamObserver;
import entidades.Encuesta;
import entidades.Foto;
import java.util.ArrayList;
import java.util.List;
import static org.pucmm.Main.*;



public class EncuestaServicesGrpc extends EncuestaRnGrpc.EncuestaRnImplBase {

    @Override
    public void listaEncuestaxUser(EncuestaRnOuterClass.EncuestaRequest request, StreamObserver<EncuestaRnOuterClass.ListaEncuesta> responseObserver) {
        List<Encuesta> Encuestas = encuestaServicios.getFormsByUser(usuarioServices.getUsuarioByUsername(request.getUsuario()).getId());
        List<EncuestaRnOuterClass.EncuestaResponse> EncuestaResponseList = new ArrayList<>();
        for(Encuesta e : Encuestas){
            EncuestaResponseList.add(convertir(e));
        }
        EncuestaRnOuterClass.ListaEncuesta build = EncuestaRnOuterClass.ListaEncuesta.newBuilder().addAllEncuesta(EncuestaResponseList).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }

    @Override
    public void crearEncuesta(EncuestaRnOuterClass.EncuestaResponse request, StreamObserver<EncuestaRnOuterClass.EncuestaResponse> responseObserver) {
        Encuesta e = encuestaServicios.crear(convertir(request));
        responseObserver.onNext(convertir(e));
        responseObserver.onCompleted();
    }

    @Override
    public void listaEncuesta(EncuestaRnOuterClass.Empty request, StreamObserver<EncuestaRnOuterClass.ListaEncuesta> responseObserver) {
        List<Encuesta> Encuestas = encuestaServicios.findAll();
        List<EncuestaRnOuterClass.EncuestaResponse> EncuestaResponseList = new ArrayList<>();
        for(Encuesta e : Encuestas){
            EncuestaResponseList.add(convertir(e));
        }
        EncuestaRnOuterClass.ListaEncuesta build = EncuestaRnOuterClass.ListaEncuesta.newBuilder().addAllEncuesta(EncuestaResponseList).build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }

    /**
     * @param Encuesta
     * @return
     */
    private EncuestaRnOuterClass.EncuestaResponse convertir(Encuesta Encuesta){
        return EncuestaRnOuterClass.EncuestaResponse.newBuilder()
                .setNombre(Encuesta.getNombre())
                .setSector(Encuesta.getSector())
                .setNivel(Encuesta.getNivelEscolar())
                .setFecha(Encuesta.getFecha())
                .setLatitude(Encuesta.getLatitude())
                .setLongitude(Encuesta.getLongitude())
                .setAccuracy(Encuesta.getAccuracy())
                .setUsuario(Encuesta.getUser().getUsuario())
                .setMimetype(Encuesta.getFoto().getMimeType())
                .setBase64(Encuesta.getFoto().getFotoBase64())
                .build();
    }

    /**
     *
     * @param e
     * @return
     */
    private Encuesta convertir(EncuestaRnOuterClass.EncuestaResponse e){
        Foto foto = fotoServices.crear(new Foto(e.getNombre(), e.getMimetype(), e.getBase64()));

        return new Encuesta(e.getNombre(), e.getSector(), e.getNivel(), usuarioServices.getUsuarioByUsername(e.getUsuario()), e.getLatitude(), e.getLongitude(), e.getAccuracy(), foto);
    }
}
