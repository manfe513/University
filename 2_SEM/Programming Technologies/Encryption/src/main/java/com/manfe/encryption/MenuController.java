package com.manfe.encryption;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuController {

    @FXML
    private Label welcomeText;

    @FXML
    private Button btnChooseFile;

    @FXML
    private void onBtnChooseFileClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void onBtnExitClick() {
        System.exit(0);
    }

    @FXML
    private void onBtnAboutClick() {
        //todo
    }
}