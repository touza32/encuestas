package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PreguntaMultiple extends Pregunta{
    private int cantidadMaximaRespuestas;

    public PreguntaMultiple() {
        
    }

    public PreguntaMultiple(int id, String descripcion, LocalDateTime fechaAlta, LocalDateTime fechaUltimaModificacion, boolean activa, ArrayList<Opcion> opciones, int cantidadMaximaRespuestas) {
        super(id, descripcion, fechaAlta, fechaUltimaModificacion, activa, opciones);
        this.cantidadMaximaRespuestas = cantidadMaximaRespuestas;
    }

    public int getCantidadMaximaRespuestas() {
        return cantidadMaximaRespuestas;
    }

    public void setCantidadMaximaRespuestas(int cantidadMaximaRespuestas) {
        this.cantidadMaximaRespuestas = cantidadMaximaRespuestas;
    }

    @Override
    public boolean validarRespuesta(Respuesta respuesta) {
        return contarOpcionesElegidas(respuesta) <= cantidadMaximaRespuestas;
        
    }
    
    
}
