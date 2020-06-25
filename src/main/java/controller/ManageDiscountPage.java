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
import models.Account;
import models.Discount;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageDiscountPage implements Initializable {
    public ScrollPane scrollPane;
    public Discount chosenDiscount =null;
    public VBox userInfoVBox;
    public TextField discountCode;
    public TextField startDate;
    public TextField finishDate;
    public TextField maxDate;
    public TextField discountPercent;
    public TextField discountedUsers;
    public TextField repeat;



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
                            if (discount.getDiscountCode() == Integer.parseInt(id)){
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
        Main.setScene("MainPage");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManagerPage");
    }


    public void delete(MouseEvent mouseEvent) {
        if (chosenDiscount != null)
        chosenDiscount.remove();
    }


    public void create(MouseEvent mouseEvent) {
        int code = Integer.parseInt(discountCode.getText());
        String start = startDate.getText();
        String end = finishDate.getText();
        int max = Integer.parseInt(maxDate.getText());
        int percent = Integer.parseInt(discountPercent.getText());
        String user = discountedUsers.getText();
        int repeated = Integer.parseInt(repeat.getText());

        ArrayList<Account> discountedAccounts = new ArrayList<>();
        for (String s : user.split("\\s")) {
            discountedAccounts.add(Account.getUserByName(s));
        }

        if (!Discount.existCode(code)) {
            new Discount(code, start, end, percent,repeated,discountedAccounts,max );
        }
    }

    public void edit(MouseEvent mouseEvent) {
        if (discountCode.getText() != "") {
            int code = Integer.parseInt(discountCode.getText());
            Discount discount = Discount.getDiscountByCode(code);
            if (discount != null) {
                if (startDate.getText() != "") {
                    discount.setStartDate(startDate.getText());
                }
                if (finishDate.getText() != "") {
                    discount.setFinishDate(finishDate.getText());
                }
                if (maxDate.getText() != "") {
                    discount.setMax(Integer.parseInt(maxDate.getText()));
                }
                if (discountPercent.getText() != "") {
                    discount.setDiscountPercent(Integer.parseInt(discountPercent.getText()));
                }
                if (discountedUsers.getText() != "") {
                    discount.addUser(Account.getUserByName(discountedUsers.getText()));

                }
            }
        }

    }
}
