package modelo;

import java.time.LocalDateTime;
//import java.util.ArrayList;


public class RespuestaEncuesta {
    private int id;
    private Encuesta encuesta;
    private LocalDateTime fechaRespuesta;
//    private ArrayList<Respuesta> respuestas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

//    public ArrayList<Respuesta> getRespuestas() {
//        return respuestas;
//    }
//
//    public void setRespuestas(ArrayList<Respuesta> respuestas) {
//        this.respuestas = respuestas;
//    }

    
    
}
