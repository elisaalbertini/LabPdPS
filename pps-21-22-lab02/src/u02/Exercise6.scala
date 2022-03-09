package u02

object Exercise6 extends App :
  // va bene? non credo sia a coda
  /*def fib(n: Int): Int = n match
    case 0 => 0
    case 1 => 1
    case _ => fib(n - 1) + fib(n - 2)*/

  //questa è tail
  def fib(n: Int): Int =
    @annotation.tailrec
    def tail(counter: Int, fib2: Int, fib1: Int): Int = counter match
      case n if n <= 0 => fib1
      case _ => tail(counter - 1, fib2 + fib1, fib2)
    tail(n, 1, 0)

