package controller;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;
import models.Account;
import models.Buyer;
import models.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductPage implements Initializable {


    public ScrollPane scrollPane;
    public Product product = null;
    public VBox userInfoVBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox vBox = new VBox();
        product = Main.getProduct();
        Label label = new Label();
        label.setText(product.toString());
        vBox.getChildren().add(label);
        scrollPane.setContent(vBox);
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setProduct(null);
        Main.setScene("MainPage");
    }

    public void addCart(MouseEvent mouseEvent) throws IOException {
        if (Main.getAccount() == null){
            Main.setPage("ProductPage");
            Main.setScene("LoginPage");
        }else {
            Buyer buyer = (Buyer) Main.getAccount();
            buyer.getCart().addProductToCart(product);
        }
    }
}
