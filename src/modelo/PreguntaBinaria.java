package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PreguntaBinaria extends Pregunta{

    public PreguntaBinaria() {
        
    }
    public PreguntaBinaria(int id, String descripcion, LocalDateTime fechaAlta, LocalDateTime fechaUltimaModificacion, boolean activa, ArrayList<Opcion> opciones) {
        super(id, descripcion, fechaAlta, fechaUltimaModificacion, activa, opciones);
    }

    @Override
    public boolean validarRespuesta(Respuesta respuesta) {
        return contarOpcionesElegidas(respuesta) == 1;
    }
    
}
