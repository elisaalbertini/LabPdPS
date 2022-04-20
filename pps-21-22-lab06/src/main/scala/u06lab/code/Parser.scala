package u06lab.code

abstract class Parser[T]:
  def parse(t: T): Boolean

  def end: Boolean

  def parseAll(seq: Seq[T]): Boolean = (seq forall parse) & end

object Parsers

extension (string: String)
  def charParser(): BasicParser =
    new BasicParser(string.toSet)

class BasicParser(chars: Set[Char]) extends Parser[Char] :
  override def parse(t: Char): Boolean = chars.contains(t)

  override def end: Boolean = true

trait NonEmpty[T] extends Parser[T] :
  private[this] var empty = true

  abstract override def parse(t: T): Boolean =
    empty = false;
    super.parse(t)

  abstract override def end: Boolean = !empty && super.end

class NonEmptyParser(chars: Set[Char]) extends BasicParser(chars) with NonEmpty[Char]

trait NotTwoConsecutive[T] extends Parser[T] :
  private[this] var notConsecutive = true
  private[this] var old: T = scala.compiletime.uninitialized

  abstract override def parse(t: T): Boolean =
    notConsecutive = old != t
    old = t
    notConsecutive

  abstract override def end: Boolean = notConsecutive && super.end

class NotTwoConsecutiveParser(chars: Set[Char]) extends BasicParser(chars) with NotTwoConsecutive[Char]
