package controllerview.addPasswordScreen;

import controllerview.loginScreen.LoginScreenC;
import controllerview.mainMenu.MainMenuC;
import controllerview.registerScreen.RegisterScreenC;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.AddPassword;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AddPasswordScreenC {

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_comment;

    @FXML
    private TextField tf_password;

    @FXML
    private Label l_error;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_back;

    @FXML
    void addOnAction(ActionEvent event) throws Exception {
        addPwd();
    }

    @FXML
    void backOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        MainMenuC.show(stage);
    }

    private AddPassword model = new AddPassword();

    public static void show(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(AddPasswordScreenC.class.getResource("addPasswordScreenV.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Add Password");
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    private void addPwd() throws Exception {
        if(!tf_username.getText().isEmpty() && !tf_password.getText().isEmpty())
        {
            model.add();
            System.out.println("Neu Angelegt");
            l_error.setTextFill(Color.web("#008000"));
            l_error.setText("Neu Angelegt");

            tf_password.setText("");
            tf_username.setText("");
            tf_comment.setText("");

        }
        else {
            l_error.setTextFill(Color.web("#ff0000"));
            l_error.setText("Fehler");
        }
    }


    @FXML
    public void initialize()
    {
        tf_password.textProperty().bindBidirectional(model.passwordProperty());
        tf_username.textProperty().bindBidirectional(model.usernameProperty());
        tf_comment.textProperty().bindBidirectional(model.commentProperty());
        l_error.textProperty().bindBidirectional(model.errorProperty());

        tf_comment.setText("");
        tf_password.setText("");
        tf_username.setText("");
        l_error.setText("");
    }

}
