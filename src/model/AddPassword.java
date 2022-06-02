package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class AddPassword {

    private StringProperty username = new SimpleStringProperty();
    private StringProperty comment = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty error = new SimpleStringProperty();

    private static SecretKeySpec secretKeySpec;
    private static byte[] key;
    private static final String ALGORITHM = "AES";

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

    public void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKeySpec = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt, String secret)
    {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(Base64.getDecoder().decode(strToEncrypt)));
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add() throws Exception {
        String filename = "./src/files/passwords.csv";
        File file = new File(filename);

        if(file == null)
        {
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));


        String s = String.format(username.getValue() + "," + comment.getValue() + "," + encrypt(password.getValue(), String.valueOf(secretKeySpec)) + "\n");
        writer.write(s);

        writer.close();
    }

}
