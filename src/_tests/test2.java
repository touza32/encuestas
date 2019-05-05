package _tests;

import dao.EncuestaDAO;
import modelo.Encuesta;
import modelo.Opcion;
import modelo.Pregunta;
import modelo.PreguntaMultiple;
import java.util.Iterator;
import dao.OpcionDAO;
import dao.PreguntaDAO;
import dao.PreguntaMultipleDAO;
import java.sql.SQLException;


public class test2 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

//       EncuestaDAO_MySql encuestaDao = new EncuestaDAO_MySql();
//        Encuesta e = encuestaDao.getById(1);
//        System.out.println(e.getDescripcion());
        
        OpcionDAO opcionDao = new OpcionDAO();
        Opcion o = opcionDao.getById(16);
        System.out.println(o.getDescripcion());
        
        PreguntaMultipleDAO preguntaMultipleDao = new PreguntaMultipleDAO();
        Pregunta p = preguntaMultipleDao.getById(4);
        System.out.println(p.getDescripcion());
        System.out.println(((PreguntaMultiple)p).getCantidadMaximaRespuestas());
        
        PreguntaDAO preguntaDao = new PreguntaDAO();

        Pregunta p2 = preguntaDao.getById(4);
        System.out.println(p2.getDescripcion());
        System.out.println(((PreguntaMultiple)p2).getCantidadMaximaRespuestas());
        
        Pregunta p3 = preguntaDao.getById(3);
        System.out.println(p3.getDescripcion());
        
        Pregunta p4 = preguntaDao.getById(2);
        System.out.println(p4.getDescripcion());  
        
        EncuestaDAO encuestaDao = new EncuestaDAO();
        Encuesta e = encuestaDao.getById(1);
        System.out.println(e.getDescripcion());
        
        Iterator<Pregunta> itPreguntas = e.getPreguntas().iterator();
        while(itPreguntas.hasNext()){
            Pregunta pregunta = itPreguntas.next();
            System.out.println("   "+pregunta.getDescripcion());
            
            Iterator<Opcion> itOpciones = pregunta.getOpciones().iterator();
            while (itOpciones.hasNext()){
                Opcion opcion = itOpciones.next();
                System.out.println("      "+opcion.getDescripcion());
            }
        }
        
//        RespuestaEncuestaDAO respuestaEncuestaDao = new RespuestaEncuestaDAO();
//        RespuestaEncuesta respuestaEncuesta = new RespuestaEncuesta();
//        respuestaEncuestaDao.crear(respuestaEncuesta);
        
       
    }
    
}
