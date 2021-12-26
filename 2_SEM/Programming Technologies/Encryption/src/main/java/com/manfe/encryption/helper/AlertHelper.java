package com.manfe.encryption.helper;

import javafx.scene.control.Alert;

public class AlertHelper {

    public static void showInfo(String text) {
        show("Information", text, Alert.AlertType.INFORMATION);
    }

    public static void showError(String text) {
        show("Error", text, Alert.AlertType.ERROR);
    }

    private static void show(String title,
                             String text,
                             Alert.AlertType type) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(text);

        alert.showAndWait();
    }
}
