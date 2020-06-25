package controller;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Account;

import java.io.IOException;

public class EditPage {
    public PasswordField passwordText;
    public TextField nameText;
    public TextField familyNameText;
    public TextField phoneNumberText;
    public TextField emailText;
    public TextField creditText;
    public Label warning;

    public void edit(MouseEvent mouseEvent) throws IOException {
        String password = passwordText.toString();
        String name = nameText.toString();
        String familyName = familyNameText.toString();
        String phoneNumber = phoneNumberText.toString();
        String email = emailText.toString();
        Account account = Main.getAccount();
        Integer credit = null;
        try {
            credit = Integer.parseInt(creditText.toString());
        } catch (NumberFormatException e) {
            warning.setText("invalid credit");
            return;
        }
        if (password != null) account.setPassword(password);

        if (name != null) account.setFirstName(name);

        if (familyName != null)account.setLastName(familyName);

        if (phoneNumber != null)account.setPhoneNumber(phoneNumber);

        if (email != null)account.setEmail(email);

        if (creditText != null)account.setCredit(credit);


    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene(Main.getAccount().getAccountPage());
    }
}
