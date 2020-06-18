module ponstekla {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.ksprofiel.ponstekla.controllers to javafx.fxml;
    opens com.ksprofiel.ponstekla.models to javafx.fxml;
    opens com.ksprofiel.ponstekla.builders to javafx.fxml;
    opens com.ksprofiel.ponstekla.factories to javafx.fxml;

    exports com.ksprofiel.ponstekla;
}