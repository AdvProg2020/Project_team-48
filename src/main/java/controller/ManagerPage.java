package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerPage implements Initializable {
    public Label nameLabel;
    public Label familyNameLabel;
    public Label passwordLabel;
    public Label emailLabel;
    public Label usernameLabel;
    public Label phoneNumberLabel;
    public Label creditLabel;

    public void showManagerRegisterPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("RegisterManagerPage");
    }

    public void showManageUsersPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManageUserPage");
    }

    public void showManageDiscountPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManageDiscountPage");
    }

    public void showManageProductPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManageProductPage");
    }

    public void showManageRequestPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManageRequestPage");
    }

    public void showManageCategoryPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManageCategoryPage");
    }

    public void edit(MouseEvent mouseEvent) throws IOException {
        Main.setScene("EditPage");
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setAccount(null);
        Main.setScene("MainPage");
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

}
