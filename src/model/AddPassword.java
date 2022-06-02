package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AddPassword {

    private StringProperty username = new SimpleStringProperty();
    private StringProperty comment = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty error = new SimpleStringProperty();

    public AddPassword() {

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

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
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

    public void add() throws IOException, NoSuchAlgorithmException {
        String filename = "./src/files/passwords.csv";
        File file = new File(filename);

        if(file == null)
        {
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));


        String s = String.format(username.getValue() + "," + comment.getValue() + "," + generateKey(password.getValue()) + "\n");
        writer.write(s);

        writer.close();
    }

    public static SecretKey generateKey(String s) throws NoSuchAlgorithmException {
        byte[] decodedKey = Base64.getDecoder().decode(s);
        SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        return key;
    }
}
