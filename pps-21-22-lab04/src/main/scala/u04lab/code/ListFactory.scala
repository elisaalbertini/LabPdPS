package u04lab.code
import u04lab.code.List.*
import u04lab.code.List
import u04lab.code.Student

trait ListFactory:
  def List[A](vars: A*): List[A]
  //def sameTeacher(t: String, l: List[Course]): List[Course]

case class ListFactoryImpl() extends ListFactory:

  override def List[A](vars: A*): List[A] =
    var l: List[A] = Nil()
    vars foreach (x => l = append(l, Cons(x, Nil())))
    l

object sameTeacher:
  def unapply(t: String, l: List[Course]) : Option[List[Course]] =
    Option.Some(filter(l)(e => e.teacher == t))

  /*class sameTeacher():
    def unapply(t: String, l: List[Course]): List[Course] =
      filter(l)(e => e.teacher == t)*/


