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
import models.Buyer;
import models.Discount;
import models.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartPage implements Initializable {
    public ScrollPane scrollPane;
    public Product chosenProduct = null;
    public VBox userInfoVBox;
    public Label priceLabel;
    public TextField discountCodeText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox vBox = new VBox();
        EventHandler<MouseEvent> eventHandler =
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        String name =  e.getSource().toString();
                        int i = 10;
                        while (name.charAt(i) != ','){
                            i++;
                        }
                        String id = name.substring(10, i);
                        Buyer buyer = (Buyer) Main.getAccount();
                        for (Product product: buyer.getCart().getProducts()) {
                            if (product.getName().equals(id)){
                                chosenProduct = product;
                                Label info = new Label();
                                info.setText(product.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        Buyer buyer = (Buyer) Main.getAccount();
        for (Product product : buyer.getCart().getProducts()) {
            Button button = new Button();
            button.setId(product.getName());
            button.setText(product.getName());
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            vBox.getChildren().add(button);
        }
        scrollPane.setContent(vBox);
        priceLabel.setText(String.valueOf(buyer.getCart().getTotalPrice()));
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setAccount(null);
        Main.setScene("MainPage");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("BuyerPage");
    }


    public void showProductPage(MouseEvent mouseEvent) throws IOException {
        if (chosenProduct != null){
            Main.setProduct(chosenProduct);
            Main.setScene("ProductPage");
        }
    }


    public void purchase(MouseEvent mouseEvent) {
            BuyerControl.purchase(Main.getAccount(), Discount.getDiscountByCode(Integer.parseInt(discountCodeText.getText())));
    }
}
