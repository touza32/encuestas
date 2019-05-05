package dao;

import dao.interfaces.IOpcionDAO;
import modelo.Opcion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpcionDAO implements IOpcionDAO{

    @Override
    public void crear(Opcion opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Opcion getById(int id){
        Opcion opcion = null;
        Connection conn = null;
        Statement consulta = null;
        try {
            conn = AdministradorDeConexiones.obtenerConexion();
            consulta = conn.createStatement();
            
            ResultSet resultado = consulta.executeQuery(
                    "SELECT * "
                  + "FROM opcion "
                  + "WHERE idopcion = "+id);
            if(resultado.next()){
                opcion = new Opcion(
                        resultado.getInt("idopcion"),
                        resultado.getString("descripcion"), 
                        false);
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OpcionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return opcion;
    }

    @Override
    public void actualizar(Opcion opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
