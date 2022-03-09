package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import Exercise8.*
import Option.*

class Exercise8Test:

  @Test def testFilter(): Unit =
    assertEquals(Some("scala"), filter[String](Some("scala"))(_.length == 5))
    assertEquals(None(), filter[Int](None[Int]())(_ % 5 == 0))

  @Test def testMap(): Unit =
    assertEquals(Some(true), map[Int](Some(25))(scala.math.sqrt(_) == 5))
    assertEquals(None(), map[Int](None[Int]())(scala.math.sqrt(_) == 5))

  @Test def testMap2(): Unit =
    assertEquals(Some("scala3"), map2[String, Int, String](Some("scala"))(Some(3))(_ + _.toString))
    assertEquals(None(), map2[String, Int, String](None[String]())(None[Int]())(_ + _.toString))

