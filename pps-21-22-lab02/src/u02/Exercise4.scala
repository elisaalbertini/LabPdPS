package u02

object Exercise4 extends App :

  //curried val
  val f1: Int => Int => Int => Boolean = x => y => z =>
    x <= y && y <= z

  //not curried val
  val f2: (Int, Int, Int) => Boolean = (x, y, z) =>
    x <= y && y <= z

  //curried def
  def f3(x: Int)(y: Int)(z: Int): Boolean =
    x <= y && y <= z

  //not curried def
  def f4(x: Int, y: Int, z: Int): Boolean =
    x <= y && y <= z

