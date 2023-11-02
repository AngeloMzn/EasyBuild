import java.io.IOException;
import java.sql.SQLException;

import App.controller.ProdutoController;
import App.model.Produto;
import App.model.DAO.ProdutoDAO;
import core.app.AppDAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("App/view/Produto.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Produtos");
            primaryStage.setScene(scene);
            primaryStage.show();
            ProdutoController controller = loader.getController();
            controller.initialize(null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
    }
}

