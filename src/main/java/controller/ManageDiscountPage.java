package controller;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import models.Discount;

public class ManageDiscountPage implements Initializable {
    public ScrollPane scrollPane;
    public Discount chosenDiscount =null;
    public VBox userInfoVBox;

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
                        for (Discount discount: Discount.getAllDiscounts()) {
                            if (discount.equals(id)){
                                chosenDiscount = discount;
                                Label info = new Label();
                                info.setText(discount.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        for (Discount discount : Discount.getAllDiscounts()) {
            Button button = new Button();
            button.setId(Integer.toString(discount.getDiscountCode()));
            button.setText(Integer.toString(discount.getDiscountCode()));
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            vBox.getChildren().add(button);
        }
        scrollPane.setContent(vBox);
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/MainPage.fxml");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/ManagerPage.fxml");
    }


    public void delete(MouseEvent mouseEvent) {
        if (chosenDiscount != null)
        chosenDiscount.remove();
    }


}
