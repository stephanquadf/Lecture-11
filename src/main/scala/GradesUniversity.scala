@main def gradesUniversity(): Unit = {
  val grades = Array(1.7, 2.3, 1.0)

  if (grades.isEmpty) {
    println("Keine Noten vorhanden")
  } else {
    var total = 0.0
    var best = grades(0)
    var worst = grades(0)

    for (i <- 0 until grades.length) {
      val grade = grades(i)
      total += grade

      if (grade < best) {
        best = grade
      }
      if (grade > worst) {
        worst = grade
      }
    }

    val average = total / grades.length

    println(f"Notendurchschnitt: $average%.2f")
    println(s"Beste Note: $best")
    println(s"Schlechteste Note: $worst")
  }
}