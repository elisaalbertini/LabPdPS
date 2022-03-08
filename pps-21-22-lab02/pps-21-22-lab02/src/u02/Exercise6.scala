package u02

object Exercise6 extends App :
  // va bene? non credo sia a coda
  def fib(n: Int): Int = n match
    case 0 => 0
    case 1 => 1
    case _ => fib(n - 1) + fib(n - 2)

  //questa è tail
  /*
  def fib(n: Int): Int =
    @annotation.tailrec
    def tail(n: Int, prev: Int, curr: Int): Int = n match
      case n if n <= 0 => curr
      case _ => tail(n - 1, prev + curr, prev)
    tail(n, 1, 0)*/

