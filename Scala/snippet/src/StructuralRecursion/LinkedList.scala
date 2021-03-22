package StructuralRecursion

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]

sealed trait LinkedList[A] {
  def fold[B](end: B, f: (A, B) => B): B =
    this match {
      case End() => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
}

sealed trait Sum[A, B] {
  def fold[C](err: A => C, ok: B => C) =
    this match {
      case Err(v) => err(v)
      case Ok(v) => ok(v)
    }

  def map[C](f: B => C): Sum[A, C] =
    this match {
      case Ok(v) => Ok(f(v))
      case Err(v) => Err(v)
    }
}

final case class Ok[A, B](value: B) extends Sum[A, B]
final case class Err[A, B](value: A) extends Sum[A, B]
