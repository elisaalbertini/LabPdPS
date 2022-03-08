package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import Exercise3.*

class Exercise3Test:

  @Test def testParityLambda(): Unit =

    assertEquals("even", parityLambda(2))
    assertEquals("odd", parityLambda(5))

  @Test def testParitySyntaxMethod(): Unit =

    assertEquals("even", paritySyntaxMethod(2))
    assertEquals("odd", paritySyntaxMethod(5))

  @Test def testNegLambda(): Unit =
    val empty: String => Boolean = _ == ""
    val notEmpty: String => Boolean = negLambda(empty)

    assertTrue(notEmpty("string"))
    assertFalse(notEmpty(""))

  @Test def testNegSyntaxMethod(): Unit =
    val length: String => Boolean = _.length == 5
    val notLength: String => Boolean = negSyntaxMethod(length)

    assertTrue(notLength(""))
    assertFalse(notLength("scala"))

  @Test def testNegGen(): Unit =
    assertFalse(neg[Int](_ % 2 == 0)(2))




