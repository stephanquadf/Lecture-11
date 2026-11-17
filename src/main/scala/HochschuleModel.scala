enum DegreeProgram {
  case ComputerScience, Mathematics, Physics
}

case class Professor(name: String)
case class Student(name: String, degreeProgram: DegreeProgram)
case class Course(name: String, professor: Professor)
case class Raum(name: String)

/** Verwaltet unveränderlich die Einschreibungen von Studierenden in Kurse.
  *
  * @param enrollments Zuordnung jedes Kurses zu den darin eingeschriebenen Studierenden
  * @example {{{
  * val registry = CourseRegistry()
  * val updated = registry.enroll(UniversityRegistry.student1, UniversityRegistry.course1)
  * updated.studentsIn(UniversityRegistry.course1)
  * }}}
  */
class CourseRegistry(val enrollments: Map[Course, Set[Student]] = Map.empty) {
  /** Schreibt einen Studierenden ein und gibt ein neues Register zurück.
    *
    * @param student der einzuschreibende Studierende
    * @param course der Kurs, in den der Studierende eingeschrieben wird
    * @return ein neues Register mit der ergänzten Einschreibung
    * @example {{{
    * val updated = CourseRegistry().enroll(UniversityRegistry.student1, UniversityRegistry.course1)
    * }}}
    */
  def enroll(student: Student, course: Course): CourseRegistry =
    new CourseRegistry(enrollments.updated(course, studentsIn(course) + student))

  /** Gibt alle in einem Kurs eingeschriebenen Studierenden zurück.
    *
    * @param course der abzufragende Kurs
    * @return die Studierenden des Kurses oder eine leere Menge, falls niemand eingeschrieben ist
    * @example {{{
    * val students = CourseRegistry().studentsIn(UniversityRegistry.course1)
    * }}}
    */
  def studentsIn(course: Course): Set[Student] =
    enrollments.getOrElse(course, Set.empty)

  /** Ermittelt die Studierenden, die in beiden Kursen eingeschrieben sind.
    *
    * @param c1 der erste Kurs
    * @param c2 der zweite Kurs
    * @return die Schnittmenge der Studierenden beider Kurse
    * @example {{{
    * val registry = CourseRegistry()
    *   .enroll(UniversityRegistry.student1, UniversityRegistry.course1)
    *   .enroll(UniversityRegistry.student1, UniversityRegistry.course2)
    * registry.inBoth(UniversityRegistry.course1, UniversityRegistry.course2)
    * }}}
    */
  def inBoth(c1: Course, c2: Course): Set[Student] =
    studentsIn(c1).intersect(studentsIn(c2))
}

object UniversityRegistry {
  val professor1 = Professor("Dr. Weber")
  val professor2 = Professor("Dr. Schmidt")

  val student1 = Student("Anna", DegreeProgram.ComputerScience)
  val student2 = Student("Ben", DegreeProgram.Mathematics)

  val course1 = Course("Programming", professor1)
  val course2 = Course("Linear Algebra", professor2)

  val room1 = Raum("A110")
  val room2 = Raum("B202")

  val booking1: (Course, Raum) = (course1, room1)
  val booking2: (Course, Raum) = (course2, room2)
}

@main def hochschuleModel(): Unit = {
  println(UniversityRegistry.professor1)
  println(UniversityRegistry.professor2)
  println(UniversityRegistry.student1)
  println(UniversityRegistry.student2)
  println(UniversityRegistry.course1)
  println(UniversityRegistry.course2)
  println(UniversityRegistry.room1)
  println(UniversityRegistry.room2)
  println(UniversityRegistry.booking1)
  println(UniversityRegistry.booking2)

  val courseRegistry = new CourseRegistry()
    .enroll(UniversityRegistry.student1, UniversityRegistry.course1)
    .enroll(UniversityRegistry.student2, UniversityRegistry.course1)
    .enroll(UniversityRegistry.student1, UniversityRegistry.course2)

  println(s"Studierende in ${UniversityRegistry.course1.name}: ${courseRegistry.studentsIn(UniversityRegistry.course1)}")
  println(s"In beiden Kursen: ${courseRegistry.inBoth(UniversityRegistry.course1, UniversityRegistry.course2)}")
}