package main.examen1tr_desarrollointerfaces;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class GestorDieteticaController implements Initializable {

    @FXML
    private TableColumn actividadCol;

    @FXML
    private ComboBox<String> actividadCombo;

    @FXML
    private TableColumn alturaCol;

    @FXML
    private Spinner<Integer> alturaPick;

    @FXML
    private TableColumn edadCol;

    @FXML
    private Spinner<Integer> edadPick;

    @FXML
    private TableColumn gerCol;

    @FXML
    private TableColumn getCol;

    @FXML
    private GridPane gridPaneAddTarea;

    @FXML
    private Text infoLabel;

    @FXML
    private TextField nombre;

    @FXML
    private TableColumn nombreCol;

    @FXML
    private TableColumn pesoCol;

    @FXML
    private Spinner<Integer> pesoPick;

    @FXML
    private TableColumn sexoCol;

    @FXML
    private ComboBox<String> sexoCombo;

    @FXML
    private TableView<Persona> vistaTabla;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {

        sexoCombo.getItems().addAll("Mujer", "Hombre");
        actividadCombo.getItems().addAll("Muy ligera", "Ligera", "Moderada", "Intensa");
        edadPick.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 150, 0));
        pesoPick.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 0));
        alturaPick.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 220, 0));
    }

    @FXML
    public void addButtonOnAction() {

        String name = null;
        String sex = null;
        String activity = null;
        int age = 0;
        int weight = 0;
        int height = 0;

        double ger = 0;
        double get = 0;

        try {
            name = nombre.getText();
            sex = sexoCombo.getValue();
            age = edadPick.getValue();
            weight = pesoPick.getValue();
            height = alturaPick.getValue();
            activity = actividadCombo.getValue();

            if (sex.equals("Mujer")) {
                ger = (655.0955 + (9.463 * weight) + (1.8496 * height) - (4.6756 * age));
            } else if (sex.equals("Hombre")) {
                ger = (66.473 + (13.751 * weight) + (5.0033 * height) - (6.755 * age));
            }

            switch (activity) {
                //Muy Ligera
                case "Muy ligera" -> get = (ger * 1.3);
                //Ligera
                case "Ligera" -> {
                    if (sex.equals("Mujer")) {
                        get = (ger * 1.5);
                    } else {
                        get = (ger * 1.6);
                    }
                }
                //Moderada
                case "Moderada" -> {
                    if (sex.equals("Mujer")) {
                        get = (ger * 1.6);
                    } else {
                        get = (ger * 1.7);
                    }
                }
                //Intensa
                case "Intensa" -> {
                    if (sex.equals("Mujer")) {
                        get = (ger * 1.9);
                    } else {
                        get = (ger * 2.1);
                    }
                }
            }

        } catch (NullPointerException e) {
            infoLabel.setText("Ha sucedido un Error Inesperado");
            infoLabel.setStyle("-fx-text-fill: red");
        }

        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        sexoCol.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        edadCol.setCellValueFactory(new PropertyValueFactory<>("edad"));
        pesoCol.setCellValueFactory(new PropertyValueFactory<>("peso"));
        alturaCol.setCellValueFactory(new PropertyValueFactory<>("altura"));
        actividadCol.setCellValueFactory(new PropertyValueFactory<>("actividad"));
        gerCol.setCellValueFactory(new PropertyValueFactory<>("ger"));
        getCol.setCellValueFactory(new PropertyValueFactory<>("get"));


        if (name != null && sex != null && age != 0 && weight != 0 && height != 0 && activity != null && ger != 0 && get != 0) {
            Persona persona = new Persona(name, sex, age, weight, height, activity, ger, get);
            vistaTabla.getItems().add(persona);
            vistaTabla.refresh();

            nombre.clear();
            sexoCombo.setValue(null);
            edadPick.getValueFactory().setValue(0);
            pesoPick.getValueFactory().setValue(0);
            alturaPick.getValueFactory().setValue(0);
            actividadCombo.setValue(null);
        } else {
            infoLabel.setText("ERROR: No se ha podido añadir la persona. Rellene todos los Campos");
            infoLabel.setStyle("-fx-text-fill: red");
        }
    }
}
