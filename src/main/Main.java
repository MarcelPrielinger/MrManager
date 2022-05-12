package main;

import controllerview.passwordGenerator.PasswordGeneratorC;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void init(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PasswordGeneratorC.show(primaryStage);
    }

    @Override
    public void stop() {

    }
}
