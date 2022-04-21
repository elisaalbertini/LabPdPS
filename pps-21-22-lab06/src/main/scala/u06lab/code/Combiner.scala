package u06lab.code

trait Functions:
  def sum(a: List[Double]): Double

  def concat(a: Seq[String]): String

  def max(a: List[Int]): Int

object FunctionsImpl extends Functions :

  override def sum(a: List[Double]): Double =
    this.combine(a)

  override def concat(a: Seq[String]): String =
    this.combine(a)

  override def max(a: List[Int]): Int =
    this.combine(a)


  def combine[A](a: Seq[A])(using c: Combiner[A]): A =
    a.foldLeft(c.unit)(c.combine)

trait Combiner[A]:
  def unit: A

  def combine(a: A, b: A): A

given Combiner[Double] with
  override def unit: Double = 0.0

  override def combine(a: Double, b: Double): Double = a + b

given Combiner[String] with
  override def unit: String = ""

  override def combine(a: String, b: String): String = a + b

given Combiner[Int] with
  override def unit: Int = Int.MinValue

  override def combine(a: Int, b: Int): Int = if a > b then a else b

@main def checkFunctions(): Unit =
  val f: Functions = FunctionsImpl
  println(f.sum(List(10.0, 20.0, 30.1))) // 60.1
  println(f.sum(List())) // 0.0
  println(f.concat(Seq("a", "b", "c"))) // abc
  println(f.concat(Seq())) // ""
  println(f.max(List(-10, 3, -5, 0))) // 3
  println(f.max(List())) // -2147483648
