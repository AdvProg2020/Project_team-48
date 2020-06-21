package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.Account;
import models.Manager;
import main.Main;

import java.io.IOException;

public class RegisterManagerPage {


    public TextField usernameText;
    public PasswordField passwordText;
    public TextField nameText;
    public TextField familyNameText;
    public TextField emailText;
    public TextField phoneNumberText;

    public void register(MouseEvent mouseEvent) throws IOException {
        String username = usernameText.toString();
        String password = passwordText.toString();
        String name = nameText.toString();
        String familyName = familyNameText.toString();
        String email = emailText.toString();
        String phoneNumber = phoneNumberText.toString();
        Manager manager = new Manager(username);
        manager.setFirstName(name);
        manager.setLastName(familyName);
        manager.setPassword(password);
        manager.setEmail(email);
        manager.setPhoneNumber(phoneNumber);
        Main.setScene("../view/MainPage.fxml");
    }
}
