package dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Encuesta;

public interface IEncuestaDAO {
    //Metodos CRUD (Create - Read - Update - Delete)
    public void                 crear(Encuesta encuesta); 
    public Encuesta             getById(int id) throws ClassNotFoundException, SQLException, InstantiationException,IllegalAccessException;
    public ArrayList<Encuesta>  getAll() throws ClassNotFoundException, SQLException, InstantiationException,IllegalAccessException;;
    public void                 actualizar(Encuesta encuesta);
    public void                 borrar(int id);
    
}
