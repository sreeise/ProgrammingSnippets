package ClassesAndObjects

class AbstractTypeMember {}

// Source: https://docs.scala-lang.org/tour/abstract-type-members.html

// Concrete implementations must define the type T
trait Buffer {
  type T
  val element: T
}

// We can add an upper type bound to T
abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length = element.length
}

// You can use IntSeqBuffer with anonymous class instantiation. See newIntSeqBuf below.
abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}

// Buffer and SeqBuffer can also be implemented using type parameters instead.
trait Buffer2[+T] {
  val element: T
}

abstract class SeqBuffer2[U, +T <: Seq[U]] extends Buffer2[T] {
  def length = element.length
}

object Main extends App {
  def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
    new IntSeqBuffer {
      type T = List[U]
      val element = List(elem1, elem2)
    }

  def newIntSeqBuf2(e1: Int, e2: Int): SeqBuffer2[Int, Seq[Int]] =
    new SeqBuffer2[Int, List[Int]] {
      val element = List(e1, e2)
    }
}

