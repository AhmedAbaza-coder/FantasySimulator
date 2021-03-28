package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.AppDatabase;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Fantasy Simulator");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();

    }


    public static void main(String[] args)
    {

        System.out.println(AppDatabase.getInstance().getSelectedPlayers());
        launch(args);
    }

}
