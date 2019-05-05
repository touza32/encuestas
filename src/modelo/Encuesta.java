package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Encuesta {
    private int             id;
    private String          descripcion;
    private LocalDateTime   fechaAlta;
    private LocalDateTime   fechaUltimaModificacion;
    private boolean         activa;
    
    private ArrayList<Pregunta> preguntas;

    public Encuesta(){
        
    }
    
    
    
    public Encuesta(int id, String descripcion, LocalDateTime fechaAlta, LocalDateTime fechaUltimaModificacion, boolean activa, ArrayList<Pregunta> preguntas) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.activa = activa;
        this.preguntas = preguntas;
    }

    public int getId() {
        return id;
    }

    
    
    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    
    
    
    @Override
    public String toString() {
        return descripcion;
    }
 
    
    
    
}
