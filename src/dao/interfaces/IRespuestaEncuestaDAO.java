package dao.interfaces;

import modelo.RespuestaEncuesta;

public interface IRespuestaEncuestaDAO {
    //Metodos CRUD (Create - Read - Update - Delete)
    public void                 crear(RespuestaEncuesta respuestaEncuesta); 
    public RespuestaEncuesta    getById(int id);
    public void                 actualizar(RespuestaEncuesta respuestaEncuesta);
    public void                 borrar(int id);
    
}
