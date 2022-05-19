package controllerview.registerScreen;

import controllerview.passwordGenerator.PasswordGeneratorC;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import model.Register;

import java.io.IOException;

public class RegisterScreenC {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;

    @FXML
    private PasswordField tf_confirmPw;

    @FXML
    private Label l_error;

    @FXML
    private Button btn_create;

    @FXML
    private Button btn_back;

    @FXML
    void backOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        PasswordGeneratorC.show(stage);
    }

    @FXML
    void createOnAction(ActionEvent event) throws IOException {
        create();
        //Zurück zu Login Screen
    }

    private Register model = new Register();

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

    private void create() throws IOException {
        if(!tf_username.getText().isEmpty() && !tf_password.getText().isEmpty() && !tf_confirmPw.getText().isEmpty())
        {
            if(tf_password.getText().equals(tf_confirmPw.getText())) {
                System.out.println("Erfolgreich erstellt");
                model.newUser();

                tf_password.setText("");
                tf_username.setText("");
                tf_confirmPw.setText("");
            }
            else{
                l_error.setText("Passwort Stimmt nicht überein");
                System.out.println("Passwort Stimmt nicht überein");
            }
        }
        else {
            l_error.setText("Alle Daten müssen befüllt sein");
            System.out.println("Alle Daten müssen befüllt sein");
        }
    }

    @FXML
    public void initialize()
    {
       tf_password.textProperty().bindBidirectional(model.passwordProperty());
       tf_username.textProperty().bindBidirectional(model.usernameProperty());

       tf_username.setText("");
       tf_password.setText("");
       tf_confirmPw.setText("");
    }


}
