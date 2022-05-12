package model;

import javafx.beans.property.*;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphaCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numeric = "0123456789";
    private static final String specials = "!§$%&/()=?.:,;+*#<>";

    private SecureRandom random = new SecureRandom();
    private BooleanProperty withNumbers = new SimpleBooleanProperty();
    private BooleanProperty withAdditionalCharacter = new SimpleBooleanProperty();
    private BooleanProperty withUppercase = new SimpleBooleanProperty();
    private DoubleProperty length = new SimpleDoubleProperty();

    public String generatePassword()
    {
        StringBuilder stringBuilderChars = new StringBuilder();
        stringBuilderChars.append(alpha);

        if (withNumbers.get())
            stringBuilderChars.append(numeric);
        if (withUppercase.get())
            stringBuilderChars.append(alphaCaps);
        if (withAdditionalCharacter.get())
            stringBuilderChars.append(specials);


        String characters = stringBuilderChars.toString();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length.get(); i++) {
            stringBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }

        return stringBuilder.toString();
    }

    public enum CharacterSet {
        Alpha,
        AlphaCaps,
        Numeric,
        Special
    }

    private static String getCharacters(CharacterSet characterSet) {

        switch (characterSet) {
            case Alpha:
                return alpha;
            case AlphaCaps:
                return alphaCaps;
            case Numeric:
                return numeric;
            case Special:
                return specials;
        }

        return alpha;
    }

    public PasswordGenerator() {
    }

    public boolean isWithNumbers() {
        return withNumbers.get();
    }

    public BooleanProperty withNumbersProperty() {
        return withNumbers;
    }

    public void setWithNumbers(boolean withNumbers) {
        this.withNumbers.set(withNumbers);
    }

    public boolean isWithAdditionalCharacter() {
        return withAdditionalCharacter.get();
    }

    public BooleanProperty withAdditionalCharacterProperty() {
        return withAdditionalCharacter;
    }

    public void setWithAdditionalCharacter(boolean withAdditionalCharacter) {
        this.withAdditionalCharacter.set(withAdditionalCharacter);
    }

    public boolean isWithUppercase() {
        return withUppercase.get();
    }

    public BooleanProperty withUppercaseProperty() {
        return withUppercase;
    }

    public void setWithUppercase(boolean withUppercase) {
        this.withUppercase.set(withUppercase);
    }

    public double getLength() {
        return length.get();
    }

    public DoubleProperty lengthProperty() {
        return length;
    }

    public void setLength(double length) {
        this.length.set(length);
    }
}
