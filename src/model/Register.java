package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register {

    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();

    public Register() {
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


    public void newUser() throws IOException {
        String filename = "./src/files/loginData.csv";

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));

        String s = String.format(username.getValue() + "," + password.getValue() + "\n");
        writer.write(s);

        writer.close();
    }
}
