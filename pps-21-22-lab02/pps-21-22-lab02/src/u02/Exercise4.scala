package u02

object Exercise4 extends App :

  //curried def
  def f1(x: Int)(y: Int)(z: Int): Boolean =
    x <= y && y <= z

  //curried val
  val f2: Int => Int => Int => Boolean = x => y => z =>
    x <= y && y <= z

  //not curried def
  def f3(x: Int, y: Int, z: Int): Boolean =
    x <= y && y <= z

  //not curried val
  val f4: (Int, Int, Int) => Boolean = (x, y, z) =>
    x <= y && y <= z