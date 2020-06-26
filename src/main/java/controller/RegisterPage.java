package controller;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Buyer;
import models.Request;
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
        String username = usernameText.getText();
        String password = passwordText.getText();
        String name = nameText.getText();
        String familyName = familyNameText.getText();
        String phoneNumber = phoneNumberText.getText();
        String accountType = accountTypeText.getText();
        String email = emailText.getText();
        String company = companyText.getText();
        if ((accountType.equals("seller") && company.equals("")) || accountType.equals("") || username.equals("") || password .equals("")  || name.equals("") || familyName .equals("")  || email.equals("")  || phoneNumber .equals("") ){
            warning.setText("unfilled field exist");
        } else if (accountType.equals( "buyer")){
            Buyer buyer = new Buyer(username);
            buyer.setFirstName(name);
            buyer.setPassword(password);
            buyer.setLastName(familyName);
            buyer.setEmail(email);
            buyer.setPhoneNumber(phoneNumber);
        } else if (accountType.equals( "seller")){
            Seller seller = new Seller(username);
            seller.setFirstName(name);
            seller.setPassword(password);
            seller.setLastName(familyName);
            seller.setEmail(email);
            seller.setPhoneNumber(phoneNumber);
            seller.setOrganization(company);
            new Request(seller,null,null);
        }else{
            warning.setText("invalid account type");
        }

    }

    public void login(MouseEvent mouseEvent) throws IOException {
        Main.setScene("LoginPage");
    }
}
