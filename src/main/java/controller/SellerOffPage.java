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
import models.Off;
import models.Product;
import models.Seller;
import view.usersPageCommands.managerCommands.ManageAllProducts;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SellerOffPage implements Initializable {
    public ScrollPane scrollPane;
    public Off chosenOff = null;
    public VBox userInfoVBox;
    public TextField startDateText;
    public TextField finishDateText;
    public TextField amountText;
    public TextField productsText;
    public TextField percentText;


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
                        Seller seller = (Seller) Main.getAccount();
                        for (Off off: seller.getOffs()) {
                            if (String.valueOf(off.getOffId()).equals(id)){
                                chosenOff = off;
                                Label info = new Label();
                                info.setText(off.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        Seller seller = (Seller) Main.getAccount();
        for (Off off : seller.getOffs()) {
            Button button = new Button();
            button.setId(String.valueOf(off.getOffId()));
            button.setText(String.valueOf(off.getOffId()));
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            vBox.getChildren().add(button);
        }
        scrollPane.setContent(vBox);
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setScene("MainPage");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("SellerPage");
    }

    public void create(MouseEvent mouseEvent) {
        String startDate = startDateText.getText();
        String finishDate = finishDateText.getText();
        String amount = amountText.getText();
        String products = productsText.getText();
        String percent = percentText.getText();

        if (!startDate.equals("") && !finishDate.equals("") && !amount.equals("") && !products.equals("") && !percent.equals("") ){
            ArrayList<Product> product = new ArrayList<>();
            for (String s : products.split("\\s")) {
               product.add( Product.getProductById(Integer.parseInt(s)));
            }
            Seller seller = (Seller) Main.getAccount();
            seller.addOff(new Off(startDate, finishDate,Integer.parseInt( amount),product, Integer.parseInt(percent)));
        }
        
    }
}
