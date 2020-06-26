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
        if (username.equals("") || password.equals("")) {
            warning.setText("unfilled field exist");
        } else if (!Account.existsUsername(username)) {
            warning.setText("username does not exist");
        }else if (Account.getUserByName(username) == null){
            warning.setText("invalid username");
        }else if (Account.getUserByName(username).getPassword().equals(password)){
            Main.setAccount(Account.getUserByName(username));
            if (Main.getPage() == null) {
                Main.setScene(Main.getAccount().getAccountPage());
            }else{
                Main.setScene(Main.getPage());
                Main.setPage(null);
            }
        }else{
            warning.setText("invalid password");
        }
    }

    public void showRegisterPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("RegisterPage");
    }
}
