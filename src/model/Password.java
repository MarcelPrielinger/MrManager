package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Password {

    private String username;
    private String password;
    private String comment;

    public Password(String username, String password, String comment) {
        this.username = username;
        this.password = password;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static ObservableList<Password> readCSV() throws IOException {
        String filename = "./src/files/loginData.csv";
        String line = "";
        String splitBy = ",";
        ObservableList<Password> passwords = FXCollections.observableArrayList();

        BufferedReader reader = new BufferedReader(new FileReader(filename));

        while ((line = reader.readLine()) != null)
        {
            String[] data = line.split(splitBy);
            passwords.add(new Password(data[0],data[1],data[2]));
        }
        return passwords;
    }
}

