package dao.interfaces;

import modelo.Respuesta;

public interface IRespuestaDAO {
    //Metodos CRUD (Create - Read - Update - Delete)
    public void     crear(Respuesta respuesta); 
    public Respuesta getById(int id);
    public void     actualizar(Respuesta respuesta);
    public void     borrar(int id);
    
}
