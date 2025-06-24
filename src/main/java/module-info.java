module org.shroomathy.originmaker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.shroomathy.originmaker to javafx.fxml;
    exports org.shroomathy.originmaker;
}