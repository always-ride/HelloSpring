# Erste Schritte mit Spring Boot

Diese Anleitung führt durch die Erstellung einer einfachen Spring Boot-Anwendung ohne der Hilfe der Spring Boot CLI.

## Voraussetzungen

Sicherstellen dass Java und Maven laufen.

- **Java Development Kit (JDK)**: JDK muss installiert und `JAVA_HOME` korrekt gesetzt sein.

```bash
$ java -version
openjdk version "17.0.4.1" 2022-08-12 LTS
OpenJDK Runtime Environment (build 17.0.4.1+1-LTS)
OpenJDK 64-Bit Server VM (build 17.0.4.1+1-LTS, mixed mode, sharing)
```

- **Maven**: Für den Build und das Packaging benutzen wir Maven. Gradle wäre eine Alternative.
  
```bash
$ mvn -v
Apache Maven 3.8.5 (3599d3414f046de2324203b78ddcf9b5e4388aa0)
Maven home: usr/Users/developer/tools/maven/3.8.5
Java version: 17.0.4.1, vendor: BellSoft, runtime: /Users/developer/sdkman/candidates/java/17.0.4.1-librca
```

## Erstellung eines neuen Projekts

Eine `pom.xml` Datei analog zu [unserer](pom.xml) reicht als Start. Damit kann bereits erfolgreich kompiliert werden. 

```bash
mvn package
```

Der folgende Befehl löscht den `target` Folder und stellt ein sauberes Kompilat sicher:

```bash
mvn clean
```

## Code von Anwendung und Controller

Eine einzelne Java-Datei reicht bereits. Standardmässig kompiliert Quellen aus `src/main/java`, daher musste diese Verzeichnisstruktur manuell erstellt werden sowie ebenfalls das Package `com.example`. Zu guter Letzt kamm die Datei [MyApplication.java](src/main/java/com/example/MyApplication.java) hinzufügen, welche Spring durch folgende Annotations einbindet.

```java
@RestController
@SpringBootApplication

@RequestMapping("/")
```

## Anwendung starten

Anwendung via Maven starten:

```bash
mvn spring-boot:run
```

Die Anwendung ist nun unter http://localhost:8080 erreichbar.

## Alternatives Starten

Mit dem bereits weiter oben eingeführten Befehl `mvn package` wird eine *.jar Datei erstellt, welche standalone ausgeführt werden kann. Damit es funktioniert, muss das <build>-Element im [pom.xml](pom.xml) vorhanden sein. Am besten das File validieren nach Anpassungen:

```bash
mvn validate
```

Nach dem Build kann das Projekt wie folgt gestartet werden:

```bash
java -jar .\target\myproject-0.0.1-SNAPSHOT.jar
```

## Weitere Informationen

Für detailliertere Anweisungen und fortgeschrittene Themen besuchen Sie bitte die offizielle [Spring Boot Dokumentation zu diesem Tutorial](https://docs.spring.io/spring-boot/tutorial/first-application/index.html).

## Test ausführen

Zunächst die Depencendies im pom.xml hinzufügen und dann laden:

```bash
mvn clean install
```

Test mit folgendem Befehl ausführen:

```bash
mvn test
```
