package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import Exercise7.*

class Exercise7Test:

  private val rect = Shape.Rectangle(4, 3)
  private val circle = Shape.Circle(8)
  private val square = Shape.Square(5)

  @Test def testRectanglePerimeter(): Unit =
    assertEquals(14, perimeter(rect), 0)

  @Test def testRectangleArea(): Unit =
    assertEquals(12, area(rect), 0)

  @Test def testCirclePerimeter(): Unit =
    assertEquals(50.27, perimeter(circle), 0.05)

  @Test def testCircleArea(): Unit =
    assertEquals(201.06, area(circle), 0.05)

  @Test def testSquarePerimeter(): Unit =
    assertEquals(20, perimeter(square), 0)

  @Test def testSquareArea(): Unit =
    assertEquals(25, area(square), 0)

