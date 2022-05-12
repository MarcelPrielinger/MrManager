package main;

import controllerview.passwordGenerator.PasswordGeneratorC;
import controllerview.registerScreen.RegisterScreenC;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void init(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        RegisterScreenC.show(primaryStage);
    }

    @Override
    public void stop() {

    }
}
