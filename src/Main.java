import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/Main.fxml"));
        primaryStage.setTitle("Titulo here");
        primaryStage.setScene(new Scene(root, 453, 267));
        primaryStage.show();
    }
}
