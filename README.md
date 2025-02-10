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

Eine einzelne Java-Datei reicht bereits. Standardmässig kompiliert Quellen aus `src/main/java`, daher musste diese Verzeichnisstruktur manuell erstellt werden sowie ebenfalls das Package `com.example`. Zu guter Letzt kam die Datei [MyApplication.java](src/main/java/com/example/MyApplication.java) hinzufügen, welche Spring durch folgende Annotations einbindet.

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

## Docker

Docker-Image bauen:

```bash
docker build -t myproject .
```

Container starten:

```bash
docker run -p 8080:8080 myproject
```

Einloggen für GitHub Container-Registry

```bash
docker login ghcr.io -u USERNAME
```

Sicherstellen, dass Fly läuft

```bash
fly version
```

## Deployment

Unter [hellospring.fly.dev](https://hellospring.fly.dev/) kann das Projekt eingesehen werde.

## Code anpassen

Eine Anpassung des Codes erfordert folgende Schritte, bis diese "live" ist:

1. File ändern, speichern
2. Build und Test mit `mvn test`
3. Package mit `mvn clean package` anstossen, um das *.jar zu generieren
4. Docker-Image aktualisieren mit `docker build -t myproject .`
5. Image lokal testen mit `docker run -p 8080:8080 myproject`
6. Bereitstellen mit `flyctl deploy` 

Mit folgendem Befehl ggf. das Image auf der GHCR aktualisieren:

```bash
flyctl deploy --image ghcr.io/USERNAME/myproject:latest
```
