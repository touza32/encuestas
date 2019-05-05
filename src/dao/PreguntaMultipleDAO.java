package dao;

import dao.interfaces.IPreguntaDAO;
import modelo.Pregunta;
import modelo.PreguntaMultiple;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreguntaMultipleDAO implements IPreguntaDAO{

    @Override
    public void crear(Pregunta pregunta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pregunta getById(int id) {
        Pregunta pregunta = null;
        Connection conn = null;
        Statement consulta = null;
        try {
            conn = AdministradorDeConexiones.obtenerConexion();
            consulta = conn.createStatement();
            
            ResultSet resultado = consulta.executeQuery(
                    "SELECT * "
                  + "FROM pregunta p INNER JOIN pregunta_multiple pm "
                  + "     ON p.idpregunta = pm.idpregunta "          
                  + "WHERE p.idpregunta = "+id);
            if(resultado.next()){
                pregunta = new PreguntaMultiple(
                        resultado.getInt("idpregunta"),
                        resultado.getString("descripcion"), 
                        resultado.getTimestamp("fechaAlta").toLocalDateTime(),
                        resultado.getTimestamp("fechaUltimaModificacion").toLocalDateTime(), 
                        resultado.getBoolean("activa"), 
                        null, 
                        resultado.getInt("cantidadMaximaRespuestas"));
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PreguntaMultipleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pregunta;
    }

    @Override
    public void actualizar(Pregunta pregunta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
