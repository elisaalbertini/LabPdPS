package u02

object Exercise7:
  
  enum Shape:
    case Rectangle(base: Double, eight: Double)
    case Circle(radius: Double)
    case Square(sides: Double)

  def perimeter(shape: Shape): Double = shape match
    case Shape.Rectangle(b, h) => (b * 2) + (h * 2)
    case Shape.Circle(r) => 2 * scala.math.Pi * r
    case Shape.Square(s) => s * 4

  def area(shape: Shape): Double = shape match
    case Shape.Rectangle(b, h) => b * h
    case Shape.Circle(r) => scala.math.Pi * scala.math.pow(r, 2)
    case Shape.Square(s) => scala.math.pow(s, 2)

