module com.example.progettoinvernale {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.progettoinvernale to javafx.fxml;
    exports com.example.progettoinvernale;
}