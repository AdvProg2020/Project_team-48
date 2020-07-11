package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Account;
import models.Discount;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyerPage implements Initializable {
    public Label nameLabel;
    public Label familyNameLabel;
    public Label passwordLabel;
    public Label emailLabel;
    public Label usernameLabel;
    public Label phoneNumberLabel;
    public Label creditLabel;
    public Label discountLabel;

    public void showCartPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("CartPage");
    }

    public void showDiscount(MouseEvent mouseEvent) {
        Account account = Main.getAccount();
        StringBuilder discounts = new StringBuilder();
        for (Discount discount : account.getAllDiscounts()) {
            discounts.append(discount.getDiscountCode());
        }
        discountLabel.setText(discounts.toString());
    }

    public void showLogPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("BuyLogPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Account account = Main.getAccount();
        nameLabel.setText(account.getFirstName());
        familyNameLabel.setText(account.getLastName());
        passwordLabel.setText(account.getPassword());
        emailLabel.setText(account.getEmail());
        usernameLabel.setText(account.getUsername());
        phoneNumberLabel.setText(account.getPhoneNumber());
        creditLabel.setText(Integer.toString(account.getCredit()));
    }

    public void edit(MouseEvent mouseEvent) throws IOException {
        Main.setScene("EditPage");
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setAccount(null);
        Main.setScene("MainPage");
    }


}
