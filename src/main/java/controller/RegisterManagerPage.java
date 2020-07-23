package controller;

import Client.Client;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.Main;
import models.Manager;
import models.Poshtiban;

import java.io.IOException;

public class RegisterManagerPage {

    public TextField usernameText;
    public PasswordField passwordText;
    public TextField nameText;
    public TextField familyNameText;
    public TextField emailText;
    public TextField phoneNumberText;
    public Label warning;

    public void register(MouseEvent mouseEvent)  {
        String username = usernameText.getText();
        String password = passwordText.getText();
        String name = nameText.getText();
        String familyName = familyNameText.getText();
        String email = emailText.getText();
        String phoneNumber = phoneNumberText.getText();
        warning.setText(Client.sendCommand("register manager "+username+ " "+ password + " "+ name+" "+familyName+" "+email +" "+phoneNumber));
        if (warning.getText().equals("registered")){
                Manager manager = new Manager(username);
                manager.setFirstName(name);
                manager.setLastName(familyName);
                manager.setPassword(password);
                manager.setEmail(email);
                manager.setPhoneNumber(phoneNumber);
            try {
                Main.setScene("MainPage");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerPoshtiban(MouseEvent mouseEvent) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        warning.setText("register poshtiban " + " " +  username + " "+ password);
        if (warning.getText().equals("registered")){
            Poshtiban poshtiban = new Poshtiban(username);
            poshtiban.setPassword(password);
            try {
                Main.setScene("MainPage");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
