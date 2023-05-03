module com.example.sweproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sweproject to javafx.fxml;
    exports com.example.sweproject;
}