package main;

import models.*;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainPage;


public class Main extends Application {
    private static Stage stage;
    private static Account account = null;


    public static void setScene(String fxml) throws IOException {
        Parent root = root = FXMLLoader.load(Main.class.getResource(fxml));
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account account) {
        Main.account = account;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        if (Manager.getAllManagers().isEmpty()){
           root = FXMLLoader.load(getClass().getResource("/RegisterManagerPage.fxml"));
        }else {
            root = FXMLLoader.load(getClass().getResource("/MainPage.fxml"));
        }
        primaryStage.setTitle("Shop!");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        stage = primaryStage;
    }


    public static void main(String[] args) {
        Filter filter1 = new Filter("brand");
        Filter filter2 = new Filter("existing");
        Filter filter3 = new Filter("price");

        launch(args);
        new MainPage(null).execute();
    }
}