package com.manfe.encryption.helper;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class FileHelper {

    public static File getFile(Window window) {

        final FileChooser fileChooser = new FileChooser();

        fileChooser.setInitialDirectory(new File("C:\\\\"));
        fileChooser.setTitle("Pick file");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "*",
                        "*.*"
                )
        );

        return fileChooser.showOpenDialog(window);
    }
}
