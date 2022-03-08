package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import Exercise5.*

class Exercise5Test:

  @Test def testComposeInt(): Unit =
    assertEquals(9, compose(_ - 1, _ * 2)(5))

  @Test def testComposeGen(): Unit =
    assertTrue(composeGen[Int, String, Boolean](_.equals("25"), _.toString)(25))
  

