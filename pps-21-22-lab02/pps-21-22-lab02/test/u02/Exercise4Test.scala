package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import Exercise4.*

class Exercise4Test:

  @Test def testF1(): Unit =
    assertTrue(f1(1)(2)(3))
    assertFalse(f1(3)(2)(1))

  @Test def testF2(): Unit =
    assertTrue(f2(1)(2)(3))
    assertFalse(f2(3)(2)(1))

  @Test def testF3(): Unit =
    assertTrue(f3(1, 2, 3))
    assertFalse(f3(3, 2, 1))

  @Test def testF4(): Unit =
    assertTrue(f4(1, 2, 3))
    assertFalse(f4(3, 2, 1))

