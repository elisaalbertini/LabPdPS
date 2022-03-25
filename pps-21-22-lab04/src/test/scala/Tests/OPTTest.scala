package Tests
import org.junit.Test
import org.junit.Assert.*
import u04lab.code.{Course, ListFactory, ListFactoryImpl, Student, sameTeacher}
import u04lab.code.List.*

class OPTTest:

  @Test
  def createList(): Unit =
    val factory: ListFactory = ListFactoryImpl()
    assertEquals(Cons(1, Nil()), factory.List(1))
    assertEquals(Cons(1, Cons(2, Cons(3, Nil()))), factory.List(1, 2, 3))

