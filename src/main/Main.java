package main;

import controllerview.loginScreen.LoginScreenC;
import controllerview.passwordGenerator.PasswordGeneratorC;
import controllerview.registerScreen.RegisterScreenC;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void init(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginScreenC.show(primaryStage);
    }

    @Override
    public void stop() {

    }
}
