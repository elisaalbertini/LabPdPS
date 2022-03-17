package u03

import u03.Optionals.Option
import u03.Optionals.Option.{None, Some}
import u02.AlgebraicDataTypes.*

import scala.annotation.tailrec

object Exercise1 extends App :

  // A generic linkedlist
  enum List[E]:
    case Cons(head: E, tail: List[E])
    case Nil()

  // a companion object (i.e., module) for List
  object List:

    def sum(l: List[Int]): Int = l match
      case Cons(h, t) => h + sum(t)
      case _ => 0

    def map[A, B](l: List[A])(mapper: A => B): List[B] = l match
      case Cons(h, t) => Cons(mapper(h), map(t)(mapper))
      case Nil() => Nil()

    def filter[A](l1: List[A])(pred: A => Boolean): List[A] = l1 match
      case Cons(h, t) if pred(h) => Cons(h, filter(t)(pred))
      case Cons(_, t) => filter(t)(pred)
      case Nil() => Nil()

    @tailrec
    def drop[A](l: List[A], n: Int): List[A] = l match
      case Cons(h, t) if n > 0 => drop(t, n - 1)
      case _ => l

    def append[A](left: List[A], right: List[A]): List[A] = left match
      case Cons(h, t) => Cons(h, append[A](t, right))
      case _ => right

    def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match
      case Cons(h, t) => append(f(h), flatMap[A, B](t)(f))
      case _ => Nil()

    def map2[A, B](l: List[A])(mapper: A => B): List[B] = flatMap[A, B](l)(e => Cons(mapper(e), Nil()))

    def filter2[A](l1: List[A])(pred: A => Boolean): List[A] = flatMap[A, A](l1)(e => e match
      case e if pred(e) => Cons(e, Nil())
      case _ => Nil())

    @tailrec
    def max(l: List[Int]): Option[Int] = l match
      case Cons(h, t) => t match
        case Nil() => Some(h)
        case _ => max(filter2(t)(_ >= h))
      case Nil() => None()

    def getCourses(l: List[Person]): List[String] = flatMap(l)(p => p match
      case Person.Teacher(_, c) => Cons(c, Nil())
      case _ => Nil())

    def foldLeft[A, B](l: List[A])(start: B)(f: (B, A) => B): B = l match
      case Cons(h, t) => f(foldLeft[A, B](t)(start)(f), h)
      case _ => start

    def foldRight[A, B](l: List[A])(start: B)(f: (A, B) => B): B = l match
      case Cons(h, t) => f(h, foldRight[A, B](t)(start)(f))
      case _ => start




