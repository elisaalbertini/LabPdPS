package u04lab.code

import List.*

trait Student:
  def name: String

  def year: Int

  def enrolling(course: Course): Unit // the student participates to a Course

  def enrollingVariadicArgument(variadic: Course*): Unit // the student participates to a Course

  def courses: List[String] // names of course the student participates to

  def hasTeacher(teacher: String): Boolean // is the student participating to a course of this teacher?

trait Course:
  def name: String

  def teacher: String

object Student:
  def apply(name: String, year: Int = 2017): Student = StudentImpl(name, year)

  private case class StudentImpl(override val name: String, override val year: Int) extends Student :
    private var coursesList: List[Course] = Nil()

    def enrolling(course: Course): Unit =
      coursesList = Cons(course, coursesList)

    def enrollingVariadicArgument(variadic: Course*): Unit =
      variadic foreach (c => enrolling(c))

    def courses: List[String] =
      map(coursesList)(e => e.name)

    def hasTeacher(teacher: String): Boolean =
      contains(map(coursesList)(e => e.teacher), teacher)

object Course:
  def apply(name: String, teacher: String): Course = CourseImpl(name, teacher)

  private case class CourseImpl(override val name: String, override val teacher: String) extends Course


@main def checkStudents(): Unit =
  val cPPS = Course("PPS", "Viroli")
  val cPCD = Course("PCD", "Ricci")
  val cSDR = Course("SDR", "D'Angelo")

  val s1 = Student("mario", 2015)
  val s2 = Student("gino", 2016)
  val s3 = Student("rino") // defaults to 2017
  val s4 = Student("gino", 2016)

  s1.enrolling(cPPS)
  s1.enrolling(cPCD)
  s2.enrolling(cPPS)
  s3.enrolling(cPPS)
  s3.enrolling(cPCD)
  s3.enrolling(cSDR)
  s4.enrollingVariadicArgument(cPPS, cPCD, cSDR)

  println(s1.courses) // Cons(PCD,Cons(PPS,Nil()))
  println(s2.courses) // Cons(PPS,Nil())
  println(s3.courses) // Cons(SDR,Cons(PCD,Cons(PPS,Nil())))
  println(s4.courses) // Cons(SDR,Cons(PCD,Cons(PPS,Nil())))

  println(s1.hasTeacher("D'Angelo")) // false
  println(s4.hasTeacher("Viroli")) // true
