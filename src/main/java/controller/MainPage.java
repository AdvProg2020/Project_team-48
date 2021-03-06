package controller;

import javafx.scene.input.MouseEvent;
import main.Main;
import models.Account;

import java.io.IOException;

public class MainPage {
    public void showAccountPage(MouseEvent mouseEvent) throws IOException {
        Account account = Main.getAccount();
        if (account == null) {
            Main.setScene("LoginPage");
        } else {
            Main.setScene(account.getAccountPage());
        }
    }

    public void showProductsPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ProductsPage");
    }

    public void showOffPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("OffPage");
    }
}
