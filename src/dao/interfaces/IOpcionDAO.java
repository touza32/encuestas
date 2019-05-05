package dao.interfaces;

import modelo.Opcion;

public interface IOpcionDAO {
    //Metodos CRUD (Create - Read - Update - Delete)
    public void     crear(Opcion opcion); 
    public Opcion   getById(int id);
    public void     actualizar(Opcion opcion);
    public void     borrar(int id);
}
