package u02

object Exercise4 extends App :
  
  val f1: Int => Int => Int => Boolean = x => y => z =>
    x <= y && y <= z
  
  val f2: (Int, Int, Int) => Boolean = (x, y, z) =>
    x <= y && y <= z
  
  def f3(x: Int)(y: Int)(z: Int): Boolean =
    x <= y && y <= z
  
  def f4(x: Int, y: Int, z: Int): Boolean =
    x <= y && y <= z

