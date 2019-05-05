package modelo;

public class Opcion {
    private int     id;
    private String  descripcion;
    private boolean elegida;

    public Opcion(int id, String descripcion, boolean elegida) {
        this.id = id;
        this.descripcion = descripcion;
        this.elegida = elegida;
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

    public boolean isElegida() {
        return elegida;
    }

    public void setElegida(boolean elegida) {
        this.elegida = elegida;
    }
    
    
    
}
