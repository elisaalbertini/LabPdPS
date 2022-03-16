package u03

import org.junit.*
import org.junit.Assert.*
import Exercise1.*
import u03.Optionals.Option.{None, Some}
import u02.AlgebraicDataTypes.*

class Exercise1Test:

  import Exercise1.List.*

  val lst = Cons(10, Cons(20, Cons(30, Nil())))
  val lstFold = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))

  @Test def testDrop(): Unit =

    assertEquals(Cons(20, Cons(30, Nil())), drop(lst, 1))
    assertEquals(Cons(30, Nil()), drop(lst, 2))
    assertEquals(Nil(), drop(lst, 5))


  @Test def testAppend(): Unit =

    val tail = Cons(40, Nil())
    assertEquals(Cons(10, Cons(20, Cons(30, Cons(40, Nil())))), append(lst, tail))
    assertEquals(tail, append(Nil(), tail))

  @Test def testFlatMap(): Unit =

    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), flatMap(lst)(v => Cons(v + 1, Nil())))
    assertEquals(Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil())))))), flatMap(lst)(v => Cons(v + 1, Cons(v + 2, Nil()))))
    assertEquals(Nil(), flatMap[Int, Int](Nil())(v => Cons(v + 1, Nil())))

  @Test def testMap2(): Unit =

    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), map2(lst)(_ + 1))
    assertEquals(Cons(5, Cons(10, Cons(15, Nil()))), map2(lst)(_ / 2))
    assertEquals(Nil(), map2[Int, Int](Nil())(_ / 2))

  @Test def testFilter2(): Unit =

    assertEquals(Cons(30, Nil()), filter2(lst)(_ > 20))
    assertEquals(Nil(), filter2(lst)(_ < 10))
    assertEquals(Nil(), filter2[Int](Nil())(_ < 10))

  @Test def testMax(): Unit =

    assertEquals(Some(30), max(lst))
    assertEquals(None(), max(Nil()))

  @Test def testGetCourses(): Unit =
    val lp = List.Cons(Person.Teacher("n1", "c1"), List.Cons(Person.Student("n2", 2), List.Cons(Person.Teacher("n3", "c3"), List.Nil())))
    assertEquals(Cons("c1", Cons("c3", Nil())), getCourses(lp))
    assertEquals(Nil(), getCourses(Nil()))

  @Test def testFoldLeft(): Unit =
    val start = 2
    assertEquals(-14, foldLeft[Int, Int](lstFold)(start)(_ - _))
    assertEquals(start, foldLeft[Int, Int](Nil())(start)(_ + _))

  @Test def testFoldRight(): Unit =
    val start = 3
    assertEquals(-5, foldRight[Int, Int](lstFold)(start)(_ - _))
    assertEquals(start, foldRight[Int, Int](Nil())(start)(_ + _))

