package modelo;

import dao.PreguntaBinariaDAO;
import dao.PreguntaMultipleChoiceDAO;
import dao.PreguntaMultipleDAO;


public class Pregunta_Factory {
    public static Pregunta crearPregunta(int id, char tipo){
        Pregunta pregunta = null;
        switch(tipo){
            case 'B':
                PreguntaBinariaDAO preguntaBinariaDao = new PreguntaBinariaDAO();
                pregunta = preguntaBinariaDao.getById(id);
                break;
            case 'M':
                PreguntaMultipleDAO preguntaMultipleDao = new PreguntaMultipleDAO();
                pregunta = preguntaMultipleDao.getById(id);
                break;
            case 'C':
                PreguntaMultipleChoiceDAO preguntaMultipleChoiceDao = new PreguntaMultipleChoiceDAO();
                pregunta =  preguntaMultipleChoiceDao.getById(id);
                break;
        }
                
        return pregunta;    
    }
//    public static Pregunta crearPregunta(int id, String descripcion, char tipo, LocalDateTime fechaAlta, LocalDateTime fechaUltimaModificacion, boolean activa) {
//        Pregunta pregunta = null;
//        switch(tipo){
//            case 'b':
//                pregunta = new PreguntaBinaria(id, descripcion, fechaAlta, fechaUltimaModificacion, true, null);
//                break;
//            case 'm':
//                
//                pregunta = new PreguntaMultiple(id, descripcion, fechaAlta, fechaUltimaModificacion, true, null);
//                break;
//            case 'c':
//                pregunta =  new PreguntaMultipleChoice(id, descripcion, fechaAlta, fechaUltimaModificacion, true, null);
//        }
//                
//        return pregunta;    
//        
//    }
}
