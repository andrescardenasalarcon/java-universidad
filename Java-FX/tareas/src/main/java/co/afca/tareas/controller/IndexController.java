package co.afca.tareas.controller;

import co.afca.tareas.model.Tarea;
import co.afca.tareas.service.TareaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.net.URL;
import java.util.ResourceBundle;


@Component
public class IndexController implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private TareaService tareaServicio;

    //    Mapeo de nuestras columna de la tabla que tenemos o queremos mostrar en el index.fxml
    @FXML
    private TableView<Tarea> tareaTabla;

    @FXML
    private TableColumn<Tarea, Integer> idTareaColumna;

    @FXML
    private TableColumn<Tarea, String> nombreTareaColumna;

    @FXML
    private TableColumn<Tarea, String> responsableTareaColumna;

    @FXML
    private TableColumn<Tarea, String> estatusTareaColumna;

    private final ObservableList<Tarea> tareaLista = FXCollections.observableArrayList();

//    Componentes para el formulario --> textArea

    @FXML
    private TextField tareaTexto;

    @FXML
    private TextField responsableTexto;

    @FXML
    private TextField estatusTexto;

    private Integer idTareaInterno;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //Para que solo se pueda seleccionar un elemento de la tabla
        //Indicamos los atribs de los valores que se van a cargar en cada una de las columnas
        configurarColumnas();
        listarTareas();
    }

    private void configurarColumnas() {
        //"idTarea" --> vienen del modelo TAREA y asi sucesivamente
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        nombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        responsableTareaColumna.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        estatusTareaColumna.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }

    private void listarTareas() {
        logger.info("Listando tareas!!!");
        tareaLista.clear();
        tareaLista.addAll(tareaServicio.listarTareas());
        tareaTabla.setItems(tareaLista);
    }

    public void agreagrTarea() {
        if (tareaTexto.getText().isEmpty()) {
            mostrarMensaje("Error Validación", "Debe proporcionar una tarea");
            tareaTexto.requestFocus();
            return;
        } else {
            var tarea = new Tarea();
            recolectarDatosFormulario(tarea);
            tarea.setIdTarea(null);
            tareaServicio.guardarTarea(tarea);
            mostrarMensaje("Información", "Tarea guardada con exito");
            limpiarFormulario();
            listarTareas();
        }

    }

    public void cargarTareaFormulario() {
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if (tarea != null) {
            idTareaInterno = tarea.getIdTarea();
            tareaTexto.setText(tarea.getNombreTarea());
            responsableTexto.setText(tarea.getResponsable());
            estatusTexto.setText(tarea.getEstatus());
        }
    }

    private void recolectarDatosFormulario(Tarea tarea) {
        if (idTareaInterno != null) {
            tarea.setIdTarea(idTareaInterno);
        }
        tarea.setNombreTarea(tareaTexto.getText());
        tarea.setResponsable(responsableTexto.getText());
        tarea.setEstatus(estatusTexto.getText());


    }

    public void modificarTarea() {
        if (idTareaInterno == null) {
            mostrarMensaje("Información", "Debe seleccionar una tarea");
            return;
        }
        if (tareaTexto.getText().isEmpty()) {
            mostrarMensaje("Error Validación", "Debe proporcionar una tarea");
            tareaTexto.requestFocus();
            return;
        }
        var tarea = new Tarea();
        recolectarDatosFormulario(tarea);
        tareaServicio.guardarTarea(tarea);
        mostrarMensaje("Información", "Tarea actualizada");
        limpiarFormulario();
        listarTareas();
    }

    public void eliminarTarea() {
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if (tarea != null) {
            logger.info("Registro a eliminar: " + tarea.toString());
            tareaServicio.eliminarTarea(tarea);
            mostrarMensaje("Información", "Tarea eliminada: " + tarea.getIdTarea());
            limpiarFormulario();
            listarTareas();
        } else {
            mostrarMensaje("Error", "No se ha seleccionado ningúna tarea");
        }
    }

    public void limpiarFormulario() {
        idTareaInterno = null;
        tareaTexto.clear();
        responsableTexto.clear();
        estatusTexto.clear();
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
