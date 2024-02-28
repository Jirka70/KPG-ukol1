module org.example.ukol {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.example.ukol1 to javafx.fxml;
    exports org.example.ukol1;
    exports org.example.ukol1.shapes;
    opens org.example.ukol1.shapes to javafx.fxml;
    exports org.example.ukol1.curve;
    opens org.example.ukol1.curve to javafx.fxml;
}