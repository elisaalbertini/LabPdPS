package u04lab.polyglot.a01b

import scala.jdk.javaapi.OptionConverters
import u04lab.polyglot.OptionToOptional
import u04lab.code.Option
import u04lab.code.Option.*
import u04lab.code.List.*

import scala.util.Random
import u04lab.code.*

import scala.annotation.tailrec

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics :

  private var selected = Nil[(Int, Int)]()
  private var minesSet = Nil[(Int, Int)]()
  private val totElem = size * size

  private def genNewMin(r: Random): (Int, Int) = (r.nextInt(size), r.nextInt(size))

  @tailrec
  private def genMines(l: List[(Int, Int)], next: (Int, Int), n: Int): List[(Int, Int)] =
    contains(l, next) match
      case true => genMines(l, genNewMin(Random()), n)
      case false => n match
        case 0 => l
        case _ => genMines(Cons(next, l), genNewMin(Random()), n - 1)

  minesSet = genMines(minesSet, genNewMin(Random()), mines)
  println(minesSet)

  private def neighbours(x: Int, y: Int): Int =
    length(filter(minesSet)((e1, e2) =>
      contains(Stream.toList(Stream.take(Stream.iterate(x - 1)(_ + 1))(3)), e1) &&
        contains(Stream.toList(Stream.take(Stream.iterate(y - 1)(_ + 1))(3)), e2)))

  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    if contains(minesSet, (x, y)) then OptionToOptional(None()) else
      selected = append(selected, Cons((x, y), Nil()))
      OptionToOptional(Some(neighbours(x, y)))

  def won = length(selected) + mines == totElem
