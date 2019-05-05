package dao;

import dao.interfaces.IRespuestaEncuestaDAO;
import modelo.Opcion;
import modelo.Pregunta;
import modelo.RespuestaEncuesta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RespuestaEncuestaDAO implements IRespuestaEncuestaDAO{

    @Override
    public void crear(RespuestaEncuesta respuestaEncuesta) {
        Connection conn = null;
        Statement sentenciaInsert = null;
        
        try {
            conn = AdministradorDeConexiones.obtenerConexion();
            sentenciaInsert = conn.createStatement();
            sentenciaInsert.execute(
                    "INSERT INTO respuesta_encuesta (idencuesta)" +
                    "VALUES (" + respuestaEncuesta.getEncuesta().getId() + ")",Statement.RETURN_GENERATED_KEYS);
            
            //Obtengo el id autoincremental generado del insert anterior
            ResultSet rs = sentenciaInsert.getGeneratedKeys();
            rs.next();
            //respuestaEncuesta.setId(rs.getInt(1));
            int id = rs.getInt(1);
            
            Iterator<Pregunta> itPreguntas = respuestaEncuesta.getEncuesta().getPreguntas().iterator();
            while(itPreguntas.hasNext()){
                Pregunta p = itPreguntas.next();
                Iterator<Opcion> itOpciones = p.getOpciones().iterator();
                while(itOpciones.hasNext()){
                    Opcion o = itOpciones.next();
                    sentenciaInsert.execute(""
                            + "INSERT INTO respuesta (idrespuesta_encuesta, idpregunta, idopcion, elegida) "
                            + "VALUES ("+id+","+p.getId()+","+o.getId()+","+o.isElegida()+"  )");
                }
            }
            
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
    public RespuestaEncuesta getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(RespuestaEncuesta respuestaEncuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
