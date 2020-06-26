package controller;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;
import models.SellLog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SellerLogPage implements Initializable {



    public ScrollPane scrollPane;
    public SellLog chosenSellLog = null;
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
                        for (SellLog sellLog: Main.getAccount().getSellLogsList()) {
                            if (sellLog.getLogId() == Integer.parseInt(id)){
                                chosenSellLog = sellLog;
                                Label info = new Label();
                                info.setText(sellLog.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        try {
            for (SellLog sellLog : Main.getAccount().getSellLogsList()) {
                Button button = new Button();
                button.setId(Integer.toString(sellLog.getLogId()));
                button.setText(Integer.toString(sellLog.getLogId()));
                button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
                vBox.getChildren().add(button);
            }
        }catch (Exception a){

        }
        scrollPane.setContent(vBox);
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setAccount(null);
        Main.setScene("MainPage");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("SellerPage");
    }


}

