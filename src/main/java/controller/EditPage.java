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
        String password = passwordText.getText();
        String name = nameText.getText();
        String familyName = familyNameText.getText();
        String phoneNumber = phoneNumberText.getText();
        String email = emailText.getText();
        String creditt = creditText.getText();
        Account account = Main.getAccount();
        Integer credit = null;
        try {
            credit = Integer.parseInt(creditText.getText());
        } catch (NumberFormatException e) {
            warning.setText("invalid credit");
            return;
        }
        if (!password.equals("")) account.setPassword(password);

        if (!name.equals("")) account.setFirstName(name);

        if (!familyName.equals("")) account.setLastName(familyName);

        if (!account.equals("")) account.setPhoneNumber(phoneNumber);

        if (!email.equals("")) account.setEmail(email);

        if (!creditt.equals("")) account.setCredit(credit);


    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene(Main.getAccount().getAccountPage());
    }
}
