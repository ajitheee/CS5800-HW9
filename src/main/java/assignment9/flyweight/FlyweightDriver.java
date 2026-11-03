package assignment9.flyweight;

public class FlyweightDriver {

    public static void main(String[] args) {

        Document document =
                new Document();

        CharacterProperty style1 =
                CharacterPropertyFactory.getProperty(
                        "Arial",
                        12,
                        "Red"
                );

        CharacterProperty style2 =
                CharacterPropertyFactory.getProperty(
                        "Calibri",
                        14,
                        "Blue"
                );

        CharacterProperty style3 =
                CharacterPropertyFactory.getProperty(
                        "Verdana",
                        16,
                        "Black"
                );

        CharacterProperty style4 =
                CharacterPropertyFactory.getProperty(
                        "Arial",
                        14,
                        "Black"
                );

        String text =
                "HelloWorldCS5800";

        for (int i = 0; i < text.length(); i++) {

            CharacterProperty property;

            if (i < 4) {
                property = style1;
            } else if (i < 8) {
                property = style2;
            } else if (i < 12) {
                property = style3;
            } else {
                property = style4;
            }

            document.addCharacter(
                    text.charAt(i),
                    property
            );
        }

        document.printDocument();

        System.out.println(
                "\nTotal shared CharacterProperty objects: "
                        + CharacterPropertyFactory.getPropertyCount()
        );

        String fileName =
                "HelloWorldCS5800.txt";

        document.saveToFile(fileName);

        System.out.println(
                "\nLOADING DOCUMENT FROM FILE"
        );

        Document loadedDocument =
                Document.loadFromFile(fileName);

        loadedDocument.printDocument();
    }
}
