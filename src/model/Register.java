package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register {
    public static void main(String[] args) throws IOException {
        String filename = "./src/files/loginData.csv";

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));

        String s = String.format("%s,%s\n","e", "H");
        writer.write(s);

        writer.close();
    }
}
