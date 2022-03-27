package u04lab.code

import scala.annotation.tailrec

trait Complex:
  def re: Double

  def im: Double

  def +(c: Complex): Complex // should implement the sum of two complex numbers..

  def *(c: Complex): Complex // should implement the product of two complex numbers

object Complex:
  def apply(re: Double, im: Double): Complex = ComplexImpl(re, im)

  private case class ComplexImpl(override val re: Double,
                                 override val im: Double) extends Complex :
    override def +(c: Complex): Complex = ComplexImpl(c.re + re, c.im + im)

    override def *(c: Complex): Complex = ComplexImpl(re * c.re - im * c.im, re * c.im + im * c.re)

@main def checkComplex(): Unit =
  val a = Array(Complex(10, 20), Complex(1, 1), Complex(7, 0))
  val c = a(0) + a(1) + a(2)
  val c1 = a(0) + a(1) + a(2)
  println((c, c.re, c.im)) // (ComplexImpl(18.0,21.0),18.0,21.0)
  val c2 = a(0) * a(1)
  println((c2, c2.re, c2.im)) // (ComplexImpl(-10.0,30.0),-10.0,30.0)
  println(c.equals(c1)) //true
  println(c.equals(c)) //true
  println(c.toString) //complexImpl(18.0,21.0)

