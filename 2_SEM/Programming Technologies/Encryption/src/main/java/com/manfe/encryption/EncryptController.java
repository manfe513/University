package com.manfe.encryption;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class EncryptController {

    @FXML
    private TextField inputEncryptionKey;

    @FXML
    private Button btnChooseFile;

    @FXML
    private void onBtnChooseFileClick() {

        final FileChooser fileChooser = new FileChooser();

        fileChooser.setInitialDirectory(new java.io.File("C:\\\\"));
        fileChooser.setTitle("Pick file");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "jpg, png, bmp, gif",
                        "*.jpg", "*.png", "*.bmp", "*.gif"
                )
        );

        fileChooser.showOpenDialog(btnChooseFile.getScene().getWindow());
    }

    @FXML
    private void onBtnExitClick() {
        System.exit(0);
    }
}