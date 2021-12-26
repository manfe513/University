package com.manfe.encryption;

import com.manfe.encryption.helper.AlertHelper;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void onBtnExitClick() {
        System.exit(0);
    }

    @FXML
    private void onBtnAboutClick() {
        AlertHelper.showInfo("Program created by Andrew Vasilev\nRIV-200027y\n2021");
    }
}