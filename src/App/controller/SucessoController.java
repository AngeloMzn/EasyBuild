package App.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SucessoController {
     @FXML
    private Label messageLabel;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    @FXML
    private void closeWindow() {
        stage.close();
    }
}
