package com.manfe.encryption.helper;

import javafx.scene.control.Alert;

public class AlertHelper {

    public static void showInfo(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(text);
//        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }
}
