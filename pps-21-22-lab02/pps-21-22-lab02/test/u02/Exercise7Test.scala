package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import Exercise7.*

class Exercise7Test:

  @Test def testRectangle(): Unit =
    val rect = Shape.Rectangle(4, 3)
    assertEquals(14, perimeter(rect), 0)
    assertEquals(12, area(rect), 0)

  @Test def testCircle(): Unit =
    val circle = Shape.Circle(8)
    assertEquals(50.27, perimeter(circle), 0.05)
    assertEquals(201.06, area(circle), 0.05)

  @Test def testSquare(): Unit =
    val square = Shape.Square(5)
    assertEquals(20, perimeter(square), 0)
    assertEquals(25, area(square), 0)

