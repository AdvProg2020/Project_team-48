package controller;

import javafx.scene.input.MouseEvent;
import main.Main;
import models.Account;

import java.io.IOException;

public class MainPage {
    public void showAccountPage(MouseEvent mouseEvent) throws IOException {
        Account account = Main.getAccount();
        if (account == null){
            Main.setScene("../view/LoginPage.fxml");
        }else {
            Main.setScene(account.getAccountPage());
        }
    }

    public void showProductsPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/ProductsPage.fxml");
    }

    public void showOffPage(MouseEvent mouseEvent) throws IOException {
        Main.setScene("../view/OffPage.fxml");
    }
}
