package controller;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;
import models.Request;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageRequestPage implements Initializable {


    public ScrollPane scrollPane;
    public Request chosenRequest = null;
    public VBox userInfoVBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox vBox = new VBox();
        EventHandler<MouseEvent> eventHandler =
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        String name = e.getSource().toString();
                        int i = 10;
                        while (name.charAt(i) != ',') {
                            i++;
                        }
                        String id = name.substring(10, i);
                        for (Request request : Request.getRequests()) {
                            if (request.getRequestId() == Integer.parseInt(id)) {
                                chosenRequest = request;
                                Label info = new Label();
                                info.setText(request.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        for (Request request : Request.getRequests()) {
            Button button = new Button();
            button.setId(String.valueOf(request.getRequestId()));
            button.setText(String.valueOf(request.getRequestId()));
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            vBox.getChildren().add(button);
        }
        scrollPane.setContent(vBox);
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setAccount(null);
        Main.setScene("MainPage");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManagerPage");
    }


    public void accept(MouseEvent mouseEvent) {
        if (chosenRequest != null) {
            Request.acceptRequest(chosenRequest.getRequestId());
        }
    }


    public void decline(MouseEvent mouseEvent) {
        if (chosenRequest != null) {
            Request.remove(chosenRequest.getRequestId());
        }
    }
}