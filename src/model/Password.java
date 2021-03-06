package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

public class Password {

    private String username;
    private String password;
    private String comment;

    public Password(String username, String comment, String password) {
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

    public static ObservableList<Password> readCSV() throws Exception {
        String filename = "./src/files/passwords.csv";
        String line = "";
        String splitBy = ",";
        ObservableList<Password> passwords = FXCollections.observableArrayList();

        BufferedReader reader = new BufferedReader(new FileReader(filename));

        while ((line = reader.readLine()) != null)
        {
            String[] data = line.split(splitBy);
            passwords.add(new Password(data[0],data[1],Cryption.decrypt(data[2],"secret")));
        }
        return passwords;
    }
}

