package com.manfe.encryption;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Шифрование файлов, РИВ-200027у, Васильев Андрей");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}