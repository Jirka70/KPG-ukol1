module org.example.ukol1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.example.ukol1 to javafx.fxml;
    exports org.example.ukol1;
}