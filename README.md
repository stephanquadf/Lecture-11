# Grades_University

Dieses Projekt zeigt eine kleine Scala-Modelldarstellung einer Universität. Es enthält Datenstrukturen für Studiengänge, Professoren, Studierende, Kurse und Räume sowie eine Klasse zur Verwaltung von Kurs-Einschreibungen.

## Inhalt

- `DegreeProgram`: Aufzählung der Studiengänge
- `Professor`: Lehrperson an der Universität
- `Student`: Studierende mit Studiengang
- `Course`: Kurs mit zugehörigem Professor
- `Raum`: Bezeichnung eines Unterrichtsraums
- `CourseRegistry`: Speichert Einschreibungen von Studierenden in Kurse und bietet Abfragen an

## Beispiel

```scala
val courseRegistry = new CourseRegistry()
  .enroll(UniversityRegistry.student1, UniversityRegistry.course1)
  .enroll(UniversityRegistry.student2, UniversityRegistry.course1)
  .enroll(UniversityRegistry.student1, UniversityRegistry.course2)

println(courseRegistry.studentsIn(UniversityRegistry.course1))
println(courseRegistry.inBoth(UniversityRegistry.course1, UniversityRegistry.course2))
```

## Ausführen

```bash
sbt run
```

## Dokumentation erzeugen

```bash
sbt doc
```

Die ScalaDoc-Dateien werden im `target`-Verzeichnis erzeugt.

## Zweck des Projekts

Das Projekt dient als einfaches Beispiel für:

- case classes und Enums in Scala
- unveränderliche Datenstrukturen
- Maps und Sets
- das Modellieren von Beziehungen zwischen Objekten
- die Verwendung von ScalaDoc-Kommentaren
