module ponstekla {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ksprofiel.ponstekla.controllers to javafx.fxml;
    exports com.ksprofiel.ponstekla;
}