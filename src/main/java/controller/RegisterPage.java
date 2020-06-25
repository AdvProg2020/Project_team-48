package controller;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Buyer;
import models.Seller;

import java.io.IOException;

public class RegisterPage {
    public TextField usernameText;
    public PasswordField passwordText;
    public TextField nameText;
    public TextField familyNameText;
    public TextField phoneNumberText;
    public TextField accountTypeText;
    public TextField emailText;
    public TextField companyText;
    public Label warning;

    public void register(MouseEvent mouseEvent) throws IOException {
        String username = usernameText.toString();
        String password = passwordText.toString();
        String name = nameText.toString();
        String familyName = familyNameText.toString();
        String phoneNumber = phoneNumberText.toString();
        String accountType = accountTypeText.toString();
        String email = emailText.toString();
        String company = companyText.toString();

        if (accountType == "buyer"){
            Buyer buyer = new Buyer(username);
            buyer.setFirstName(name);
            buyer.setPassword(password);
            buyer.setLastName(familyName);
            buyer.setEmail(email);
            buyer.setPhoneNumber(phoneNumber);
            Main.setScene("../view/BuyerPage.fxml");
        }else if (accountType == "seller"){
            Seller seller = new Seller(username);
            seller.setFirstName(name);
            seller.setPassword(password);
            seller.setLastName(familyName);
            seller.setEmail(email);
            seller.setPhoneNumber(phoneNumber);
            seller.setOrganization(company);
            Main.setScene("../view/SellerPage.fxml");
        }else{
            warning.setText("invalid account type");
        }

    }

    public void login(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/LoginPage.fxml");
    }
}
