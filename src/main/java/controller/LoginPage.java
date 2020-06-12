package controller;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Account;

import java.io.IOException;

public class LoginPage {
    public TextField usernameText;
    public PasswordField passwordText;
    public Label warning;

    public void login(MouseEvent mouseEvent) {
        String username = usernameText.toString();
        String password = passwordText.toString();
        if (Account.getUserByName(username).getPassword().equals(password)){
            Main.setAccount(Account.getUserByName(username));
        }else{
            warning.setText("invalid username or password");
        }
    }

    public void showRegisterPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/RegisterPage.fxml");
    }
}
