package dao;

import dao.interfaces.IPreguntaDAO;
import modelo.Pregunta;
import modelo.Pregunta_Factory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Opcion;

public class PreguntaDAO implements IPreguntaDAO{

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
            
            //Obtengo la cabecera de la pregunta
            ResultSet resultado = consulta.executeQuery(
                    "SELECT tipo "
                  + "FROM pregunta "
                  + "WHERE idpregunta = "+id);
            if(resultado.next()){
                pregunta = Pregunta_Factory.crearPregunta(id, resultado.getString("tipo").charAt(0));
                
                //Obtengo los ids de las opciones de la pregunta
                ResultSet resultadoOpciones = consulta.executeQuery(
                    "SELECT idopcion "
                  + "FROM pregunta_opcion "
                  + "WHERE idpregunta="+id);
                
                //Creo la lista de opciones
                ArrayList<Opcion> listaOpciones = new ArrayList();
                while(resultadoOpciones.next()){
                    int idOpcion = resultadoOpciones.getInt("idopcion");
                    OpcionDAO opcionDao = new OpcionDAO();
                    Opcion opcion = opcionDao.getById(idOpcion);
                    //Agrego la opcion obtenia del DAO en la lista de opciones
                    listaOpciones.add(opcion);
                }
                pregunta.setOpciones(listaOpciones);
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(consulta != null){
                    consulta.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(OpcionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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
