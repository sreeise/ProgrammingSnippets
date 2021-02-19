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
