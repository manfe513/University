module com.manfe.encryption {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.manfe.encryption to javafx.fxml;
    exports com.manfe.encryption;
}