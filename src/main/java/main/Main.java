package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Account;
import models.Filter;
import models.Manager;
import models.Product;
import view.MainPage;

import java.io.IOException;
import java.util.regex.Pattern;


public class Main extends Application {
    private static Stage stage;
    private static Account account = null;
    private static Product product = null;
    private static String page = null;


    public static void setScene(String fxml) throws IOException {
        Parent root  = FXMLLoader.load(Main.class.getResource(getAddress(fxml)));
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
        Main.account = account;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root ;
        if (Manager.getAllManagers().isEmpty()){
            root = FXMLLoader.load(getClass().getResource("/fxml/RegisterManagerPAge.fxml"));
        }else {
            root = FXMLLoader.load(getClass().getResource("/fxml/MainPage.fxml"));
        }
        primaryStage.setTitle("Shop!");

        primaryStage.setScene(new Scene(root, 650, 325));
        primaryStage.show();
        stage = primaryStage;
    }

    public static String getAddress(String fxml){
        return  "/fxml/" + fxml + ".fxml";
    }


    public static void main(String[] args) {
        //Filter filter1 = new Filter("brand");
        //Filter filter2 = new Filter("existing");
        //Filter filter3 = new Filter("price");

        launch(args);
        //new MainPage(null).execute();
    }
    
}