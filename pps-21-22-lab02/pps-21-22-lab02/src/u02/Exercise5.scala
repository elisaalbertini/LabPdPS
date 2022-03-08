package u02

object Exercise5 extends App :

  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))

  def composeGen[A, B, C](f: B => C, g: A => B): A => C =
    x => f(g(x))





