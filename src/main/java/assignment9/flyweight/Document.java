package assignment9.flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {

    private final List<TextCharacter> characters =
            new ArrayList<>();

    public void addCharacter(
            char c,
            CharacterProperty property) {

        characters.add(
                new TextCharacter(c, property)
        );
    }

    public void printDocument() {

        System.out.println("\nDOCUMENT CONTENT");
        System.out.println("================");

        for (TextCharacter tc : characters) {
            tc.print();
        }
    }

    public void saveToFile(String fileName) {

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(fileName))) {

            for (TextCharacter tc : characters) {

                CharacterProperty p =
                        tc.getProperty();

                writer.println(
                        tc.getCharacter() + "," +
                        p.getFont() + "," +
                        p.getSize() + "," +
                        p.getColor()
                );
            }

            System.out.println(
                    "\nDocument saved to: " + fileName
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving document: "
                            + e.getMessage()
            );
        }
    }

    public static Document loadFromFile(
            String fileName) {

        Document document =
                new Document();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts =
                        line.split(",");

                char c =
                        parts[0].charAt(0);

                String font =
                        parts[1];

                int size =
                        Integer.parseInt(parts[2]);

                String color =
                        parts[3];

                CharacterProperty property =
                        CharacterPropertyFactory.getProperty(
                                font,
                                size,
                                color
                        );

                document.addCharacter(
                        c,
                        property
                );
            }

            System.out.println(
                    "Document loaded from: " + fileName
            );

        } catch (IOException e) {

            System.out.println(
                    "Error loading document: "
                            + e.getMessage()
            );
        }

        return document;
    }
}
