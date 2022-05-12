package controllerview.passwordGenerator;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import model.PasswordGenerator;

import java.io.IOException;

public class PasswordGeneratorC {

    @FXML
    private CheckBox checkNumbs;

    @FXML
    private CheckBox checkUppercase;

    @FXML
    private CheckBox checkSpecial;

    @FXML
    private TextField txtLength;

    @FXML
    private Slider slideLength;

    @FXML
    private Button btnGenerate;

    @FXML
    private TextField txtGeneratedPassword;

    private PasswordGenerator model = new PasswordGenerator();

    public static void show(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(PasswordGeneratorC.class.getResource("passwordGeneratorV.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("PasswordGenerator");
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
    }

    @FXML
    void btnGenerateOnAction(ActionEvent event)
    {
        txtGeneratedPassword.setText(model.generatePassword());
    }

    @FXML
    public void initialize()
    {
        checkNumbs.selectedProperty().bindBidirectional(model.withNumbersProperty());
        checkSpecial.selectedProperty().bindBidirectional(model.withAdditionalCharacterProperty());
        checkUppercase.selectedProperty().bindBidirectional(model.withUppercaseProperty());
        slideLength.valueProperty().bindBidirectional(model.lengthProperty());

        txtLength.textProperty().bindBidirectional(slideLength.valueProperty(), new NumberStringConverter());
    }

}
