module _4ain.verifica4bin {
    requires javafx.controls;
    requires javafx.fxml;


    opens _4ain.verifica4bin to javafx.fxml;
    exports _4ain.verifica4bin;
    exports _4ain.verifica4bin.controller;
    opens _4ain.verifica4bin.controller to javafx.fxml;
}