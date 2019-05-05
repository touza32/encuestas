package controlador;

import modelo.RespuestaEncuesta;
import modelo.PreguntaMultipleChoice;
import modelo.Pregunta;
import modelo.PreguntaBinaria;
import modelo.PreguntaMultiple;
import modelo.Encuesta;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import dao.RespuestaEncuestaDAO;

public class VentanaEncuestaController implements Initializable {
    
    private Encuesta encuesta;
    @FXML
    VBox vBoxListaPreguntas;

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void inicializar() throws IOException{
        for (int i = 0; i < encuesta.getPreguntas().size() ; i++){
            Pregunta pregunta = encuesta.getPreguntas().get(i);
            Label lblPregunta = new Label(pregunta.getDescripcion());
            //VBox es una lista vertical para poner elementos (Un Label con el texto dela pregunta y el resto las opciones
            VBox vBoxOpciones = new VBox(5); //El parametro es el espacio entre cada elemento 
                    
            vBoxOpciones.getChildren().add(lblPregunta);//agrego el primer elemento que es el label del texto de la pregunta
            ToggleGroup toggleGroup = new ToggleGroup();//Es un contenedor de RadioButtons para permiter q solo uno quede marcado de los q estan aqui dentro
            //Agrego las opciones
            for(int j = 0; j< pregunta.getOpciones().size(); j++){
                //Si es multiple choice, agrego RadioButton
                if(pregunta instanceof PreguntaMultipleChoice){
                    RadioButton rb = new RadioButton(pregunta.getOpciones().get(j).getDescripcion());
                    rb.setToggleGroup(toggleGroup);//Asigno el RadioButton al contenedor
                    vBoxOpciones.getChildren().add(rb);
                //Si es multiple, agrego CheckBox
                }else if(pregunta instanceof PreguntaMultiple){
                    CheckBox cb = new CheckBox(pregunta.getOpciones().get(j).getDescripcion());
                    vBoxOpciones.getChildren().add(cb);
                //Si es binaria agrego RadioButton
                }else if (pregunta instanceof PreguntaBinaria){
                    RadioButton rb = new RadioButton(pregunta.getOpciones().get(j).getDescripcion());
                    rb.setToggleGroup(toggleGroup);//Asigno el RadioButton al contenedor
                    vBoxOpciones.getChildren().add(rb); 
                }
            }
            vBoxListaPreguntas.getChildren().add(vBoxOpciones);
        }
    }
    
    public void guardarRespuesta(){
        System.out.println("Guardando respuesta");

        RespuestaEncuesta respuestaEncuesta = new RespuestaEncuesta();
        respuestaEncuesta.setEncuesta(encuesta);
        
        //Recorro la lista de preguntas
        for(int i = 0; i < vBoxListaPreguntas.getChildren().size(); i++){
            VBox vBoxListaOpciones = (VBox) vBoxListaPreguntas.getChildren().get(i);
            //Recorro la lista de opciones DESDE la SEGUNDA posicion para saltar el texto de la pregunta
            for(int j = 1; j < vBoxListaOpciones.getChildren().size(); j++ ){
                Node nodeOpcion = vBoxListaOpciones.getChildren().get(j);
                if(nodeOpcion instanceof CheckBox){
                    boolean isElegida = ((CheckBox)nodeOpcion).isSelected();
                    respuestaEncuesta.getEncuesta().getPreguntas().get(i).getOpciones().get(j-1).setElegida(isElegida);
                }else if(nodeOpcion instanceof RadioButton){
                    boolean isElegida = ((RadioButton)nodeOpcion).isSelected();
                    respuestaEncuesta.getEncuesta().getPreguntas().get(i).getOpciones().get(j-1).setElegida(isElegida);
                }
            }
        }
        RespuestaEncuestaDAO respuestaEncuestaDao = new RespuestaEncuestaDAO();
        respuestaEncuestaDao.crear(respuestaEncuesta);
    }
    
}
