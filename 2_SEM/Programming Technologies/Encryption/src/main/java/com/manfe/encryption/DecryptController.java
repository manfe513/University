package com.manfe.encryption;

import com.manfe.encryption.helper.AlertHelper;
import com.manfe.encryption.helper.CryptoHelper;
import com.manfe.encryption.helper.FileHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class DecryptController {

    @FXML
    private TextField etKey;

    @FXML
    private TextField etFilePath;

    private File selectedFile = null;

    @FXML
    private void onBtnChooseFileClick() {

        File file = FileHelper.getFile(etFilePath.getScene().getWindow());

        if(file != null) {
            selectedFile = file;
            etFilePath.setText(selectedFile.getPath());
        }
    }

    @FXML
    private void onBtnDecryptClick() {

        if(selectedFile == null) {
            AlertHelper.showInfo("Pick file first");
            return;
        }

        if(etKey.getText().isBlank()) {
            AlertHelper.showInfo("Enter decryption key");
            return;
        }

        String destinationFilePath = selectedFile.getParentFile().getAbsolutePath()
                + File.separator
                + "DECRYPTED_"
                + selectedFile.getName();

        try {
            CryptoHelper.decrypt(
                    etKey.getText(),
                    selectedFile,
                    new File(destinationFilePath)
            );

            AlertHelper.showInfo("File decrypted, path:\n" + destinationFilePath);

        } catch (Exception e) {
            AlertHelper.showInfo(e.getLocalizedMessage());
        }
    }
}