package u02

object Exercise6 extends App :

  def fib(n: Int): Int = n match
    case 0 => 0
    case 1 => 1
    case _ => fib(n - 1) + fib(n - 2)

  def fibTail(n: Int): Int =
    @annotation.tailrec
    def tail(counter: Int, fib1: Int, fib2: Int): Int = counter match
      case n if n <= 0 => fib2
      case _ => tail(counter - 1, fib1 + fib2, fib1)
    tail(n, 1, 0)

