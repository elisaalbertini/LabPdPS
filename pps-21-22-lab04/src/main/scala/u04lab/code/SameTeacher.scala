package u04lab.code
import u04lab.code.List.*
import u04lab.code.List
import u04lab.code.Student
import scala.Option

class SameTeacher(val t: String)

object SameTeacher:

  def apply(t: String): SameTeacher =
    new SameTeacher(t)

  def unapply(par: SameTeacher): Some[List[Course]] = ???


