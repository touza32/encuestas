package _tests;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import dao.AdministradorDeConexiones;


public class test {

    public static void main(String[] args) throws Exception{
        Foo foo = new Foo();
        
        
        Connection conn = AdministradorDeConexiones.obtenerConexion();
        System.out.println(conn);
        //-----------------------------
        Statement sentencia = conn.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT * from encuesta");
        System.out.println(rs);
        
        while(rs.next()){
            System.out.println(rs.getString("descripcion"));
        }
        //rs.close();
        //-----------------------------
        //sentencia.execute("INSERT into encuesta (idencuesta, descripcion) VALUES (3,'Atencion Premium')");
        //-----------------------------
        sentencia.execute("UPDATE encuesta SET descripcion='Servicio Post Venta' WHERE idencuesta=2 ");
        //-----------------------------
        sentencia.execute("DELETE FROM encuesta WHERE idencuesta=3 ");
        conn.close();
        
        
    }
}
