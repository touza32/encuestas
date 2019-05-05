package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Pregunta {
    private int             id;
    private String          descripcion;
    private LocalDateTime   fechaAlta;
    private LocalDateTime   fechaUltimaModificacion;
    private boolean         activa;
    
    private ArrayList<Opcion>   opciones;
    
    public Pregunta(){
        
    }

    public Pregunta(int id, String descripcion, LocalDateTime fechaAlta, LocalDateTime fechaUltimaModificacion, boolean activa, ArrayList<Opcion> opciones) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.activa = activa;
        this.opciones = opciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public ArrayList<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }


    
    
    
    public abstract boolean validarRespuesta(Respuesta respuesta);
    
    protected int contarOpcionesElegidas(){
        int cantOpElegidas = 0;
        
        for(int i = 0; i < opciones.size(); i++){
            if(opciones.get(i).isElegida()){
                cantOpElegidas++;
            }
        }
        return cantOpElegidas;
    }
    
    protected int contarOpcionesElegidas(Respuesta respuesta){
        return respuesta.getOpcionesElejidas().size();
    }
    
}
