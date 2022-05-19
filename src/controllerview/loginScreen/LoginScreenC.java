package controllerview.loginScreen;

import controllerview.registerScreen.RegisterScreenC;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Login;

import java.io.IOException;

public class LoginScreenC {

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_password;

    @FXML
    private Label l_error;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_register;

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {
        login();
    }

    @FXML
    void registerOnAction(ActionEvent event) {

    }

    private Login model = new Login();

    public static void show(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(LoginScreenC.class.getResource("loginScreenV.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("LoginScreen");
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    private void login() throws IOException {
        model.newLogin();
    }

    @FXML
    public void initialize()
    {
        tf_username.textProperty().bindBidirectional(model.usernameProperty());
        tf_password.textProperty().bindBidirectional(model.passwordProperty());
        l_error.textProperty().bindBidirectional(model.errorProperty());

        tf_password.setText("");
        tf_username.setText("");
        l_error.setText("");
    }

}
