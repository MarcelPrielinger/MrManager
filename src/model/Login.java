package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Login {

    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty error = new SimpleStringProperty();

    public Login() {
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }

    public void setError(String error) {
        this.error.set(error);
    }

    public void newLogin() throws IOException {
        String filename = "./src/files/loginData.csv";
        String line = "";
        String splitBy = ",";

        BufferedReader reader = new BufferedReader(new FileReader(filename));

        while ((line = reader.readLine()) != null)
        {
            String[] data = line.split(splitBy);
            if(data[0].equals(username.getValue()) && data[1].equals(password.getValue()))
            {
                System.out.println("Hello");
                //Klasse wechslen
            }
            else {
            }

        }
        System.out.println("Fehlerhaft");
        error.setValue("Falsche Eingabe");

    }

}
