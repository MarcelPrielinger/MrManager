package controllerview.mainMenu;

import controllerview.addPasswordScreen.AddPasswordScreenC;
import controllerview.loginScreen.LoginScreenC;
import controllerview.passwordGenerator.PasswordGeneratorC;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuC {

    @FXML
    private ListView<?> lvPasswords;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnAdd;

    @FXML
    public void initialize()
    {

    }

    public static void show(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(MainMenuC.class.getResource("mainMenuV.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Menu");
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    @FXML
    void btnGenerateOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        PasswordGeneratorC.show(stage);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        AddPasswordScreenC.show(stage);
    }
}