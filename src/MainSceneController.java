import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private TextField titulo;

    @FXML
    void btnOnClicked(ActionEvent event) {
        Stage mainWindow = (Stage) titulo.getScene().getWindow();
        String titulo1 = titulo.getText();
        mainWindow.setTitle(titulo1);
    }

}
