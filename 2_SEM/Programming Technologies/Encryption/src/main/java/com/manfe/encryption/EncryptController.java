package com.manfe.encryption;

import com.manfe.encryption.helper.AlertHelper;
import com.manfe.encryption.helper.CryptoHelper;
import com.manfe.encryption.helper.FileHelper;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.File;

public class EncryptController {

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
    private void onBtnEncryptClick() {

        if(selectedFile == null) {
            AlertHelper.showInfo("Pick file first");
            return;
        }

        if(etKey.getText().isBlank()) {
            AlertHelper.showInfo("Enter encryption key");
            return;
        }

        String destinationFilePath = selectedFile.getParentFile().getAbsolutePath()
                + File.separator
                + "ENCRYPTED_"
                + selectedFile.getName();

        try {
            CryptoHelper.encrypt(
                    etKey.getText(),
                    selectedFile,
                    new File(destinationFilePath)
            );

            AlertHelper.showInfo("File encrypted, path:\n" + destinationFilePath);

        } catch (Exception e) {
            AlertHelper.showInfo(e.getLocalizedMessage());
        }
    }
}