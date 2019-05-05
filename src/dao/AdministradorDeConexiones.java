package dao;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class AdministradorDeConexiones {
    
    public static Connection obtenerConexion() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
    
        String  dbDriver = "com.mysql.jdbc.Driver";
        String  dbConnString = "jdbc:mysql://localhost/miNegocio";
        String  dbUser = "root";
        String  dbPassword = "root";
        
        //Class.forName(dbDriver).newInstance();
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }

}
