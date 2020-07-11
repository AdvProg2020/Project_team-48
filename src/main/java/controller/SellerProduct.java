package controller;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;
import models.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SellerProduct implements Initializable {
    public ScrollPane scrollPane;
    public Product chosenProduct = null;
    public VBox userInfoVBox;
    public TextField nameText;
    public TextField brandText;
    public TextField priceText;
    public TextField existingText;
    public TextField detailsText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox vBox = new VBox();
        EventHandler<MouseEvent> eventHandler =
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        String name = e.getSource().toString();
                        int i = 10;
                        while (name.charAt(i) != ',') {
                            i++;
                        }
                        String id = name.substring(10, i);
                        Seller seller = (Seller) Main.getAccount();
                        for (Product product : seller.getProducts()) {
                            if (product.getName().equals(id)) {
                                chosenProduct = product;
                                Label info = new Label();
                                info.setText(product.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        Seller seller = (Seller) Main.getAccount();
        for (Product product : seller.getProducts()) {
            Button button = new Button();
            button.setId(product.getName());
            button.setText(product.getName());
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            vBox.getChildren().add(button);
        }
        scrollPane.setContent(vBox);
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setAccount(null);
        Main.setScene("MainPage");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("SellerPage");
    }


    public void delete(MouseEvent mouseEvent) {
        if (chosenProduct != null) {
            new Request(Main.getAccount(),chosenProduct,null);

            Seller seller = (Seller) Main.getAccount();
            seller.removeProduct(chosenProduct);
        }
    }

    public void create(MouseEvent mouseEvent) {
        String name = nameText.getText();
        String brand = brandText.getText();
        String price = priceText.getText();
        String existing = existingText.getText();
        String detail = detailsText.getText();
        Seller seller = (Seller) Main.getAccount();

        if (!name.equals("") && !brand.equals("") && !price.equals("") && !existing.equals("") && !seller.equals("") && !detail.equals("")) {
            Product product = new Product(name, brand, Integer.parseInt(price), Integer.parseInt(existing), seller, detail);
            seller.addProduct(product);
        }
    }
}
