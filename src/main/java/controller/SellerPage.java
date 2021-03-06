package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Account;
import models.Discount;
import models.Seller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SellerPage implements Initializable {
    public Label nameLabel;
    public Label familyNameLabel;
    public Label passwordLabel;
    public Label emailLabel;
    public Label usernameLabel;
    public Label phoneNumberLabel;
    public Label creditLabel;
    public Label discountLabel;
    public Label companyText;


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
        Seller seller = (Seller) account;
        companyText.setText(seller.getOrganization());
    }

    public void edit(MouseEvent mouseEvent) throws IOException {
        Main.setScene("EditPage");
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setAccount(null);
        Main.setScene("MainPage");
    }

    public void sellLog(MouseEvent mouseEvent) throws IOException {
        Main.setScene("SellerLogPage");
    }


    public void sellerProduct(MouseEvent mouseEvent) throws IOException {
        Main.setScene("SellerProduct");
    }

    public void showOffPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("SellerOffPage");
    }

    public void showCategory(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManageCategoryPage");
    }
}
