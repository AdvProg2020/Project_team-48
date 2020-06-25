package controller;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;
import models.BuyLog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyLogPage implements Initializable {



    public ScrollPane scrollPane;
    public BuyLog chosenBuyLog = null;
    public VBox userInfoVBox;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox vBox = new VBox();
        EventHandler<MouseEvent> eventHandler =
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        String name =  e.getSource().toString();
                        int i = 10;
                        while (name.charAt(i) != ','){
                            i++;
                        }
                        String id = name.substring(10, i);
                        for (BuyLog buyLog: Main.getAccount().getBuyLogList()) {
                            if (buyLog.getCode() == Integer.parseInt(id)){
                                chosenBuyLog = buyLog;
                                Label info = new Label();
                                info.setText(buyLog.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        for (BuyLog buyLog : Main.getAccount().getBuyLogList()) {
            Button button = new Button();
            button.setId(Integer.toString(buyLog.getCode()));
            button.setText(Integer.toString(buyLog.getCode()));
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            vBox.getChildren().add(button);
        }
        scrollPane.setContent(vBox);
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setScene("MainPage");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManagerPage");
    }


}

