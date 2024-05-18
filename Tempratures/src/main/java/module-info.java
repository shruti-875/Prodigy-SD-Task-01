module org.example.tempratures {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.tempratures to javafx.fxml;
    exports org.example.tempratures;
}