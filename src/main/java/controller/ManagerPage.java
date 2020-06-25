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
        Main.setScene("../view/MainPage.fxml");
    }

    public void showManageUsersPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/ManageUserPage.fxml");
    }

    public void showManageDiscountPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/ManageDiscountPage.fxml");
    }

    public void showManageProductPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/ManageProductPage.fxml");
    }

    public void showManageRequestPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/ManageRequestPage.fxml");
    }

    public void showManageCategoryPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/ManageCategoryPage.fxml");
    }

    public void edit(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/EditPage.fxml");
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/MainPage.fxml");
    }

    public void back(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Account account  = Main.getAccount();
        nameLabel.setText(account.getFirstName());
        familyNameLabel.setText(account.getLastName());
        passwordLabel.setText(account.getPassword());
        emailLabel.setText(account.getEmail());
        usernameLabel.setText(account.getUsername());
        phoneNumberLabel.setText(account.getPhoneNumber());
        creditLabel.setText(Integer.toString(account.getCredit()));
    }
}
