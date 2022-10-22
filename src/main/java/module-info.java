module valerie.javafx.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens valerie.javafx.javafxproject to javafx.fxml;
    exports valerie.javafx.javafxproject;
}