package main;

import Client.Client;
import Server.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.*;
import view.MainPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Main extends Application {
    private static Stage stage;
    private static Account account = null;
    private static Product product = null;
    private static String page = null;
    private static Client client = null;
    private static int leftAmount = 0;
    private static int tool = 0;

    public static void setScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(getAddress(fxml)));
        stage.setScene(new Scene(root, 650, 325));
        stage.show();
    }

    public static Product getProduct() {
        return product;
    }

    public static void setProduct(Product product) {
        Main.product = product;
    }

    public static String getPage() {
        return page;
    }

    public static void setPage(String page) {
        Main.page = page;
    }

    public static Account getAccount() {
        return account;
    }

    public static void setAccount(Account account) {
        if (account == null){
            Client.sendCommand("logout "+ Main.account.getUsername());
        }

        Main.account = account;
    }

    public static Client getClient() {
        return client;
    }

    public static void setLeftAmount(int leftAmount) {
        Main.leftAmount = leftAmount;
    }

    public static int getLeftAmount() {
        return leftAmount;
    }

    public static void setTool(int parseInt) {
        Main.tool = parseInt ;
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        if (Manager.getAllManagers().isEmpty()) {
            root = FXMLLoader.load(getClass().getResource("/fxml/RegisterManagerPAge.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("/fxml/MainPage.fxml"));
        }
        primaryStage.setTitle("Shop!");

        primaryStage.setScene(new Scene(root, 650, 325));
        primaryStage.show();
        stage = primaryStage;


    }

    public static String getAddress(String fxml) {
        return "/fxml/" + fxml + ".fxml";
    }

    public static void main(String[] args) {
        //Filter filter1 = new Filter("brand");
        //Filter filter2 = new Filter("existing");
        //Filter filter3 = new Filter("price");
        //new MainPage(null).execute();



        Main.client = new Client();


        //launch(args);



    }

}