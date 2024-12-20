package com.example.progettoinvernale;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView campo;
    @FXML
    public void initialize(){
        File fotoStadio = new File("C:/Users/valle.21141/IdeaProjects/ProgettoInvernale/src/Campo.jpg");
        Image image = new Image(fotoStadio.toURI().toString());
        campo.setImage(image);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}