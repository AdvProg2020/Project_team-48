package controller;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import main.Main;
import models.Category;
import models.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageCategoryPage implements Initializable {
    public TextField nameText;
    public TextField specialityText;
    public ScrollPane productScrollPane;
    public VBox userInfoVBox;
    public ScrollPane scrollPane;
    public Category chosenCategory;
    public Product chosenProduct;
    public VBox productVBox;


    public void logout(MouseEvent mouseEvent) throws IOException {
        Main.setAccount(null);
        Main.setScene("MainPage");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Main.setScene("ManagerPage");
    }


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
                        for (Category category : Category.getAllCategories()) {
                            if (category.getName().equals(id)) {
                                chosenCategory = category;
                                Label info = new Label();
                                info.setText(category.toString());
                                userInfoVBox.getChildren().add(info);
                            }
                        }
                    }
                };
        for (Category category : Category.getAllCategories()) {
            Button button = new Button();
            button.setId(category.getName());
            button.setText(category.getName());
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            vBox.getChildren().add(button);
        }
        scrollPane.setContent(vBox);
    }

    public void create(MouseEvent mouseEvent) {
        new Category(nameText.getText(),specialityText.getText(),null,null);
    }
}
