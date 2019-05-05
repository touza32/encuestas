package dao;

import dao.interfaces.IEncuestaDAO;
import modelo.Encuesta;
import modelo.Opcion;
import modelo.Pregunta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EncuestaDAO_1 implements IEncuestaDAO{

    @Override
    public void crear(Encuesta encuesta) {
        
    }

    @Override
    public Encuesta getById(int id) {
        Encuesta encuesta = null;
        Connection conn = null;
        Statement consulta = null;
        try {
            conn = AdministradorDeConexiones.obtenerConexion();
            consulta = conn.createStatement();
            
            //Obtengo la cabecera de la encuesta
            ResultSet resultado = consulta.executeQuery(
                    "SELECT * "
                  + "FROM encuesta "
                  + "WHERE idencuesta = "+id);
            if(resultado.next()){
                encuesta = new Encuesta(
                        resultado.getInt("idencuesta"), 
                        resultado.getString("descripcion"), 
                        resultado.getTimestamp("fechaAlta").toLocalDateTime(),
                        resultado.getTimestamp("fechaUltimaModificacion").toLocalDateTime(), 
                        resultado.getBoolean("activa"), 
                        null);
            }
            
            //Obtengo los ids de las preguntas de la encuesta
            consulta = conn.createStatement();
            ResultSet resultadoPreguntas = consulta.executeQuery(
                    "SELECT idpregunta " +
                    "FROM encuesta_pregunta ep " +
                    "WHERE ep.idencuesta = "+id);            
            
            //Creo la lista de preguntas
            ArrayList<Pregunta> listaPreguntas = new ArrayList();
            while(resultadoPreguntas.next()){
                int idPregunta = resultadoPreguntas.getInt("idpregunta");
                PreguntaDAO preguntaDao = new PreguntaDAO();
                Pregunta pregunta = preguntaDao.getById(idPregunta);

                //Obtengo los ids de las opciones de la pregunta
                consulta = conn.createStatement();
                ResultSet resultadoOpciones = consulta.executeQuery(
                        "SELECT idopcion " +
                        "FROM pregunta_opcion po " +
                        "WHERE po.idpregunta = "+idPregunta);
                
                //Creo la lista de opciones
                ArrayList<Opcion> listaOpciones = new ArrayList();
                while(resultadoOpciones.next()){
                    int idOpcion = resultadoOpciones.getInt("idopcion");
                    OpcionDAO opcionDao = new OpcionDAO();
                    Opcion opcion = opcionDao.getById(idOpcion);
                    listaOpciones.add(opcion);
                }
                pregunta.setOpciones(listaOpciones);
                listaPreguntas.add(pregunta);
            }
            if(encuesta != null){
                encuesta.setPreguntas(listaPreguntas);
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(consulta != null){
                    consulta.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        
        
        return encuesta;
    }

    @Override
    public ArrayList<Encuesta> getAll() {
        ArrayList<Encuesta> listaEncuestas = new ArrayList<>();
        Encuesta encuesta = null;
        Connection conn = null;
        Statement consulta = null;
        try {
            conn = AdministradorDeConexiones.obtenerConexion();
            consulta = conn.createStatement();
            
            //Consulto todos los id de las encuestas
            ResultSet resultado = consulta.executeQuery(
                    "SELECT idencuesta FROM encuesta");

            //Por cada id busco la encuesta correspondiente
            while(resultado.next()){
                int id = resultado.getInt("idencuesta");
                Encuesta e = this.getById(id);
                listaEncuestas.add(e);
            }
            
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(consulta != null){
                    consulta.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listaEncuestas;
    }
    
    
    @Override
    public void actualizar(Encuesta encuesta) {
        
    }

    @Override
    public void borrar(int id) {
        
    }


}
