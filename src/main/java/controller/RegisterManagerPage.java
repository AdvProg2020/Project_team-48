package controller;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Manager;

import java.io.IOException;

public class RegisterManagerPage {

    public TextField usernameText;
    public PasswordField passwordText;
    public TextField nameText;
    public TextField familyNameText;
    public TextField emailText;
    public TextField phoneNumberText;
    public Label warning;

    public void register(MouseEvent mouseEvent) throws IOException {
        String username = usernameText.getText();
        String password = passwordText.getText();
        String name = nameText.getText();
        String familyName = familyNameText.getText();
        String email = emailText.getText();
        String phoneNumber = phoneNumberText.getText();
        if (username.equals("") || password.equals("") || name.equals("") || familyName.equals("") || email.equals("") || phoneNumber.equals("")) {
            warning.setText("unfilled field exist");
        } else {
            Manager manager = new Manager(username);
            manager.setFirstName(name);
            manager.setLastName(familyName);
            manager.setPassword(password);
            manager.setEmail(email);
            manager.setPhoneNumber(phoneNumber);
            Main.setScene("MainPage");
        }
    }
}
