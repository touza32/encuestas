package controlador;

import dao.EncuestaDAO;
import modelo.Opcion;
import modelo.PreguntaMultipleChoice;
import modelo.Pregunta;
import modelo.PreguntaMultiple;
import modelo.Encuesta;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class VentanaPrinicipalController implements Initializable {

    @FXML
    private ListView listaEncuestas;
    @FXML
    private Label   lblError;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //inicializacionPrueba();

        EncuestaDAO encuestaDao = new EncuestaDAO();
        ArrayList<Encuesta> listaEnc;
        try {
            listaEnc = encuestaDao.getAll();
            ObservableList<Encuesta> oListaEnc = FXCollections.observableArrayList(listaEnc);
            listaEncuestas.setItems(oListaEnc);        
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            lblError.setText("Se produjo un error");
        }
    }
    
    public void elegirEncuesta() throws IOException{
        //System.out.println(listaEncuestas.getSelectionModel().getSelectedItems());
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/vista/VentanaEncuesta.fxml"));
        Parent root = fxmlLoader.load();
        Scene  scene = new Scene(root);

        //Seteo la encuesta elegida en el controller de la ventana de la encuesta
        VentanaEncuestaController vec = fxmlLoader.getController();
        Encuesta encuesta = (Encuesta) listaEncuestas.getSelectionModel().getSelectedItems().get(0);
        vec.setEncuesta(encuesta);
        vec.inicializar();
        
        Stage encuestaStage = new Stage();
        encuestaStage.setScene(scene);
        encuestaStage.setTitle("Encuesta - "+encuesta.getDescripcion());
        encuestaStage.show();        
    }
    
    private void inicializacionPrueba(){
        ArrayList<Encuesta>  listaEnc = new ArrayList();
        ArrayList<Pregunta> listaPreguntas = new ArrayList();
        ArrayList<Opcion> opciones = new ArrayList();
        Pregunta pregunta;
        
        opciones.add(new Opcion(111, "Opcion 1.1.1", false));
        opciones.add(new Opcion(112, "Opcion 1.1.2", false));
        opciones.add(new Opcion(113, "Opcion 1.1.3", false));
        pregunta = new PreguntaMultipleChoice(11,"Pregunta 1.1 Pregunta 1.1 Pregunta 1.1 ", null, null, true, opciones);
        listaPreguntas.add(pregunta);

        //opciones.clear();
        opciones = new ArrayList<>();
        opciones.add(new Opcion(121, "Opcion 1.2.1", false));
        opciones.add(new Opcion(122, "Opcion 1.2.2", false));
        opciones.add(new Opcion(123, "Opcion 1.2.3", false));
        pregunta = new PreguntaMultiple(12,"Pregunta 1.2", null, null, true, opciones,2);
        listaPreguntas.add(pregunta);

        //opciones.clear();
        opciones = new ArrayList<>();
        opciones.add(new Opcion(131, "Opcion 1.3.1", false));
        opciones.add(new Opcion(132, "Opcion 1.3.2", false));
        opciones.add(new Opcion(133, "Opcion 1.3.3", false));
        pregunta = new PreguntaMultiple(13,"Pregunta 1.3", null, null, true, opciones,2);
        listaPreguntas.add(pregunta);
        
        listaEnc.add(new Encuesta(1, "Atencion Telefonica", null, null, true, listaPreguntas));
        
        listaEnc.add(new Encuesta(2, "Servicio Tecnico", null, null, true, null));
        listaEnc.add(new Encuesta(3, "Ofertas del mes", null, null, true, null));
        listaEnc.add(new Encuesta(4, "Servicio Post Venta", null, null, true, null));
        listaEnc.add(new Encuesta(5, "Atencion en sucursales", null, null, true, null));
        
        ObservableList<Encuesta> oListaEnc = FXCollections.observableArrayList(listaEnc);
        listaEncuestas.setItems(oListaEnc);
        
    }
    
    
}
