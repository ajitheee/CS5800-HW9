# CS5800 - Assignment 9: Structural Design Patterns

This repository contains the completed Flyweight text-editor example for
Assignment 9. The Proxy music-streaming part is pending.

## Flyweight pattern

Each `TextCharacter` stores its character and a reference to an immutable
`CharacterProperty`. The factory reuses the same property object whenever the
font, size, and color match.

The driver creates `HelloWorldCS5800` with four formatting combinations:

| Characters | Font | Size | Color |
| --- | --- | --- | --- |
| `Hell` | Arial | 12 | Red |
| `oWor` | Calibri | 14 | Blue |
| `ldCS` | Verdana | 16 | Black |
| `5800` | Arial | 14 | Black |

It prints the document, saves it to `HelloWorldCS5800.txt` in the working
directory, and reloads it while reusing the factory's shared property objects.
There are 16 characters and only four shared property objects.

## Project files

```text
src/main/java/assignment9/flyweight/
    CharacterProperty.java
    CharacterPropertyFactory.java
    TextCharacter.java
    Document.java
    FlyweightDriver.java
examples/
    HelloWorldCS5800.txt
    FlyweightDriver-output.txt
.run/Assignment9_Flyweight.run.xml
pom.xml
```

## Run in IntelliJ IDEA

1. Clone this repository and open its `pom.xml` as a Maven project.
2. Set the project SDK to Java 21 and allow Maven import to finish.
3. Run `assignment9.flyweight.FlyweightDriver`, or select the shared
   **Assignment 9 - Flyweight** run configuration.

## Run from PowerShell

Install JDK 21 or later, then run these commands from the repository root:

```powershell
New-Item -ItemType Directory -Path out -Force | Out-Null
$javaFiles = Get-ChildItem -Path src/main/java -Filter *.java -Recurse | ForEach-Object FullName
javac --release 21 -d out $javaFiles
java -cp out assignment9.flyweight.FlyweightDriver
```

With Maven installed, the equivalent commands are:

```text
mvn compile
java -cp target/classes assignment9.flyweight.FlyweightDriver
```

Expected output includes:

```text
Total shared CharacterProperty objects: 4
Document saved to: HelloWorldCS5800.txt
Document loaded from: HelloWorldCS5800.txt
```

The complete console output and saved document are in `examples/`.
The supplied example stores one character and its formatting per line,
separated by commas.

## Next: Proxy pattern

The Proxy part will use `Song`, `SongService`, `RealSongService`,
`SongServiceProxy`, and `ProxyDriver` under `assignment9.proxy`. It will
demonstrate caching for searches by ID, title, and album, with an approximately
one-second delay on real-service calls. These classes are not implemented yet.
