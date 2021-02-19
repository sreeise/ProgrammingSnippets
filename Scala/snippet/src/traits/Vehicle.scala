package traits

trait Vehicle {
  def make(): String
  def model(): String

  def getMakeAndModel: String = s"Make: ${make()}\nModel: ${model()}"
}

class Suv(var ma: String, var mo: String) extends Vehicle {
  override def make(): String = ma

  override def model(): String = mo

  override def toString: String = s"Vehicle: Suv\n${getMakeAndModel}"
}

// Sealed Traits
// Sealed traits are typically used when all the subtypes of a trait
// are known. All subtypes of a sealed trait must be defined in the
// same file. Sealed traits tell the compiler that the subtypes
// of the trait are all known. The compiler provides extra checks
// for sealed traits. This is useful for pattern matching where
// the compiler will warn us if there is a missing pattern.
sealed trait Computer {
  def motherboard: String
  def processor: String
  def graphicsProcessor: String
}

case class Desktop(motherboard: String, processor: String, graphicsProcessor: String) extends Computer {}

case class Laptop(motherboard: String, processor: String, graphicsProcessor: String) extends Computer {}

object ComputerMatch {
  def matchComputer(computer: Computer): String = {
    computer match {
      case Desktop(_, _, _) => "desktop"
      case Laptop(_, _, _) => "laptop"
    }
  }
}
