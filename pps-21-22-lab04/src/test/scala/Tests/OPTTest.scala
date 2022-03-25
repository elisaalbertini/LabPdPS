package Tests
import org.junit.Test
import org.junit.Assert.*
import u04lab.code.{Course, ListFactory, ListFactoryImpl, Student}
import u04lab.code.List.*
import u04lab.code.SameTeacher

class OPTTest:
  val factory: ListFactory = ListFactoryImpl()
  @Test
  def createListTest(): Unit =
    assertEquals(Cons(1, Nil()), factory.List(1))
    assertEquals(Cons(1, Cons(2, Cons(3, Nil()))), factory.List(1, 2, 3))

    

