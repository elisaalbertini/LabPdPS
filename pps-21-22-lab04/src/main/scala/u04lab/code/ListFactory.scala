package u04lab.code

import u04lab.code.List.*
import u04lab.code.List
import u04lab.code.Student
import scala.Option

trait ListFactory:
  def List[A](vars: A*): List[A]

case class ListFactoryImpl() extends ListFactory :

  override def List[A](vars: A*): List[A] =
    var l: List[A] = Nil()
    vars foreach (x => l = append(l, Cons(x, Nil())))
    l







