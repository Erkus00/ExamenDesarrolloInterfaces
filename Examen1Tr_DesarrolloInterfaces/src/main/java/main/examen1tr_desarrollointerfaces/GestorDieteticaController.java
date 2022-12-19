package main.examen1tr_desarrollointerfaces;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class GestorDieteticaController {

    @FXML
    private TableColumn<?, ?> actividadCol;

    @FXML
    private ComboBox<?> actividadCombo;

    @FXML
    private TableColumn<?, ?> alturaCol;

    @FXML
    private Spinner<Integer> alturaPick;

    @FXML
    private Text areaActividad;

    @FXML
    private Text areaAltura;

    @FXML
    private Text areaEdad;

    @FXML
    private Text areaNombre;

    @FXML
    private Text areaPeso;

    @FXML
    private Text areaSexo;

    @FXML
    private Button close1;

    @FXML
    private TableColumn<?, ?> edadCol;

    @FXML
    private Spinner<Integer> edadPick;

    @FXML
    private TableColumn<?, ?> gerCol;

    @FXML
    private TableColumn<?, ?> getCol;

    @FXML
    private GridPane gridPaneAddTarea;

    @FXML
    private Text infoLabel;

    @FXML
    private TextField nombre;

    @FXML
    private TableColumn<?, ?> nombreCol;

    @FXML
    private TableColumn<?, ?> pesoCol;

    @FXML
    private Spinner<Integer> pesoPick;

    @FXML
    private TableColumn<?, ?> sexoCol;

    @FXML
    private ComboBox<?> sexoCombo;

    @FXML
    private TableView<?> vistaTabla;

    @FXML
    public void add() {

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
            sex = sexoCombo.getValue().toString();
            age = (int) edadPick.getValue();
            weight = (int) pesoPick.getValue();
            height = (int) alturaPick.getValue();
            activity = actividadCombo.getValue().toString();

            if (sex.equals("Mujer")) {
                ger = (655.0955 + (9.463 * weight) + (1.8496 * height) - (4.6756 * age));
            } else if (sex.equals("Hombre")) {
                ger = (66.473 + (13.751 * weight) + (5.0033 * height) - (6.755 * age));
            }

            switch (activity) {
                case "Muy ligera" -> get = (ger * 1.3);
                case "Ligera" -> {
                    if (sex.equals("Mujer")) get = (ger * 1.5);
                    else get = (ger * 1.6);
                }
                case "Moderada" -> {
                    if (sex.equals("Mujer")) get = (ger * 1.6);
                    else get = (ger * 1.7);
                }
                case "Intensa" -> {
                    if (sex.equals("Mujer")) get = (ger * 1.9);
                    else get = (ger * 2.1);
                }
            }

        } catch (NullPointerException e) {
            infoLabel.setText("ERROR: Rellena todos los campos");
            infoLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold");
        }

        Persona persona = new Persona(name, sex, age, weight, height, activity, ger, get);

        if (persona != null) {
            vistaTabla.getItems().add(persona);
            vistaTabla.refresh();

            nombre.clear();
            sexoCombo.setValue(null);
            edadPick.getValueFactory().setValue(null);
            pesoPick.getValueFactory().setValue(null);
            alturaPick.getValueFactory().setValue(null);
            actividadCombo.setValue(null);
        } else {
            infoLabel.setText("ERROR: No se ha podido añadir la persona");
            infoLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold");
        }


    }


    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {

        sexoCombo.setItems().addAll("Mujer", "Hombre");
        actividadCombo.getItems().addAll("Muy ligera", "Ligera", "Moderada", "Intensa");
        edadPick.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        pesoPick.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 400, 0));
        alturaPick.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 250, 0));
    }
}
