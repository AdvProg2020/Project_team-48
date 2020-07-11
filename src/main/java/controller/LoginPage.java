package controller;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Account;
import view.usersPageCommands.managerCommands.ManageAllProducts;

import java.io.IOException;

public class LoginPage {
    public TextField usernameText;
    public PasswordField passwordText;
    public Label warning;

    public void login(MouseEvent mouseEvent) throws IOException {
        String username = usernameText.getText();
        String password = passwordText.getText();
        warning.setText( Account.getUserByName(username).getClient().login("login " + username + " " + password));
    }

    public void showRegisterPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("RegisterPage");
    }
}
