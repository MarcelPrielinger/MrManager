package controllerview.registerScreen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterScreenC {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;

    @FXML
    private PasswordField tf_confirmPw;

    @FXML
    private Button btn_create;

    @FXML
    private Button btn_back;

    @FXML
    void backOnAction(ActionEvent event) {

    }

    @FXML
    void createOnAction(ActionEvent event) {

    }

    public static void show(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(RegisterScreenC.class.getResource("registerScreenV.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("RegisterScreen");
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

}
