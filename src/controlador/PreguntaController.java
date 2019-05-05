package controlador;

import modelo.PreguntaMultipleChoice;
import modelo.Pregunta;
import modelo.PreguntaBinaria;
import modelo.PreguntaMultiple;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class PreguntaController implements Initializable {
    
    protected Pregunta pregunta;
    @FXML
    VBox vBoxOpciones;

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void inicializar(){
//        Label lblPregunta = new Label(pregunta.getDescripcion());
//        vBoxOpciones.getChildren().add(lblPregunta);
//        ToggleGroup toggleGroup = new ToggleGroup();
//        for(int i = 0; i< pregunta.getOpciones().size(); i++){
//            if(pregunta instanceof PreguntaMultipleChoice){
//                RadioButton rb = new RadioButton(pregunta.getOpciones().get(i).getDescripcion());
//                rb.setToggleGroup(toggleGroup);
//                vBoxOpciones.getChildren().add(rb);
//            }else if(pregunta instanceof PreguntaMultiple){
//                CheckBox cb = new CheckBox(pregunta.getOpciones().get(i).getDescripcion());
//                vBoxOpciones.getChildren().add(cb);
//            }else if (pregunta instanceof PreguntaBinaria){
//                RadioButton rb = new RadioButton(pregunta.getOpciones().get(i).getDescripcion());
//                rb.setToggleGroup(toggleGroup);
//                vBoxOpciones.getChildren().add(rb); 
//            }
//        }
    }
    
}
