package dao;

import dao.interfaces.IRespuestaDAO;
import modelo.Respuesta;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RespuestaDAO_OLD implements IRespuestaDAO{

    @Override
    public void crear(Respuesta respuesta) {
        Connection conn = null;
        Statement sentenciaInsert = null;
        
        try {
            conn = AdministradorDeConexiones.obtenerConexion();
            sentenciaInsert = conn.createStatement();
            sentenciaInsert.execute(
                    "INSERT INTO respuesta (idrespuesta_encuesta,idpregunta,idopcionelegida)" +
                    "VALUES (" + 1 + "," + 2 + "," + 1 + ")");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(RespuestaEncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(sentenciaInsert != null){
                    sentenciaInsert.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException ex) {
                 Logger.getLogger(RespuestaEncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Respuesta getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    @Override
    public void actualizar(Respuesta respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
