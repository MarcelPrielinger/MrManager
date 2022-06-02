package controllerview.mainMenu;

import controllerview.passwordGenerator.PasswordGeneratorC;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Password;

import java.io.IOException;

public class MainMenuC {

    @FXML
    private TableView tvPasswords;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnAdd;

    @FXML
    public void initialize()
    {
        tvPasswords.setEditable(true);

        TableColumn usernameCol = new TableColumn("Benutzername");
        TableColumn passwordCol = new TableColumn("Passwort");
        TableColumn commentCol = new TableColumn("Kommentar");

        usernameCol.setCellValueFactory(
                new PropertyValueFactory<Password,String>("username")
        );
        passwordCol.setCellValueFactory(
                new PropertyValueFactory<Password,String>("password")
        );
        commentCol.setCellValueFactory(
                new PropertyValueFactory<Password,String>("comment")
        );

        try {
            tvPasswords.setItems(Password.readCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }

        usernameCol.setMinWidth(100);
        passwordCol.setMinWidth(100);
        commentCol.setMinWidth(100);

        tvPasswords.getColumns().clear();
        tvPasswords.getColumns().addAll(usernameCol, passwordCol, commentCol);
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
        //AddPasswordScreenC.show(stage);
    }
}