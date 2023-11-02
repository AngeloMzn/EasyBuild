package App.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorController {
    @FXML
    private Label mensagemLabel;
    @FXML
    private Stage stage;

    public void setMensagemErro(String mensagem) {
        mensagemLabel.setText(mensagem);
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void fecharJanela() {
        stage.close();
    }

}
