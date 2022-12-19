module main.examen1tr_desarrollointerfaces {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens main.examen1tr_desarrollointerfaces to javafx.fxml;
    exports main.examen1tr_desarrollointerfaces;
}