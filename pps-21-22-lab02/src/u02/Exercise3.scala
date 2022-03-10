package u02

object Exercise3 extends App :
  
  val parityLambda: Int => String = x => x % 2 match
    case 0 => "even"
    case _ => "odd"

  def paritySyntaxMethod(x: Int): String = x % 2 match
    case 0 => "even"
    case _ => "odd"
  
  val negLambda: (String => Boolean) => String => Boolean = f => x => !f(x)

  def negSyntaxMethod(f: String => Boolean): String => Boolean = !f(_)
  
  def neg[X](f: X => Boolean): X => Boolean = !f(_)


