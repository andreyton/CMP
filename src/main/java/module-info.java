module com.cmp.cmp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.cmp.cmp to javafx.fxml;
    exports com.cmp.cmp;
}