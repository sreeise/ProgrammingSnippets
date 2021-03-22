package ClassesAndObjects

class CompoundTypes {}

// Source: https://docs.scala-lang.org/tour/compound-types.html

// We can specify a value to be of a certain type, or trait,
// and we can specify multiple traits for one object.
trait Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}

trait Resetable {
  def reset: Unit
}

object Main extends App {
  // Specify obj to be of types Cloneable and Ressetable.
  def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
    val cloned = obj.clone()
    obj.reset
    cloned
  }
}
