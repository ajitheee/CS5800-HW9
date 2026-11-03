package assignment9.flyweight;

public class TextCharacter {

    private char character;
    private CharacterProperty property;

    public TextCharacter(
            char character,
            CharacterProperty property) {

        this.character = character;
        this.property = property;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public CharacterProperty getProperty() {
        return property;
    }

    public void setProperty(
            CharacterProperty property) {

        this.property = property;
    }

    public void print() {
        System.out.println(
                character + " -> " + property
        );
    }
}
