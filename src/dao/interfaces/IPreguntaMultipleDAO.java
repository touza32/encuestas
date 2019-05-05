package dao.interfaces;

import modelo.Pregunta;

public interface IPreguntaMultipleDAO {
    //Metodos CRUD (Create - Read - Update - Delete)
    public void     crear(Pregunta pregunta); 
    public Pregunta getById(int id);
    public void     actualizar(Pregunta pregunta);
    public void     borrar(int id);
    
}
