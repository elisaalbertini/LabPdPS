package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import Exercise6.*

class Exercise6Test:

  @Test def testFib(): Unit =
    assertEquals(0, fib(0))
    assertEquals(13, fib(7))

  @Test def testFibTail(): Unit =
    assertEquals(1, fibTail(2))
    assertEquals(5, fibTail(5))

