package controller;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;
import models.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductsPage implements Initializable {


    public ScrollPane scrollPane;
    public Product chosenProduct = null;
    public VBox userInfoVBox;


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
                        for (Product product : Product.getAllProduct()) {
                            if (product.getName().equals(id)) {
                                chosenProduct = product;
                                Label info = new Label();
                                info.setText(product.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        for (Product product : Product.getAllProduct()) {
            Button button = new Button();
            button.setId(product.getName());
            button.setText(product.getName());
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            if (product.getExisting() == 0){
                button.setText(product.getName()+ "does not exist");
            }
            vBox.getChildren().add(button);
        }
        scrollPane.setContent(vBox);
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("MainPage");
    }


    public void showProductPage(MouseEvent mouseEvent) throws IOException {
        if (chosenProduct != null) {
            Main.setProduct(chosenProduct);
            Main.setScene("ProductPage");
        }
    }
}


