package Task.Modul6.com.main;

import Task.Modul6.com.gui.LoginPanel;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApps extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        LoginPanel.showLogin(primaryStage);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }
}
