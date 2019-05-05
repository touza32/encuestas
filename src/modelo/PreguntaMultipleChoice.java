package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PreguntaMultipleChoice extends Pregunta{

    public PreguntaMultipleChoice(int id, String descripcion, LocalDateTime fechaAlta, LocalDateTime fechaUltimaModificacion, boolean activa, ArrayList<Opcion> opciones) {
        super(id, descripcion, fechaAlta, fechaUltimaModificacion, activa, opciones);
    }

    PreguntaMultipleChoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarRespuesta(Respuesta respuesta) {
        return contarOpcionesElegidas(respuesta) == 1;
    }
    
}
