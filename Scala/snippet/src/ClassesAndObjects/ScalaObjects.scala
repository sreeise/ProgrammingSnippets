package ClassesAndObjects

object ScalaObjects {
  // Declare fields of an object
  val age: Int = 10

  // Val is immutable
  val age2 = 10

  // Var is muttable
  var age3 = 10

  // Declare methods
  def name: String = "name"
}


// Case objects - See companion objects
// For case classes that have no constructor arguments you can instead
// define a case object which extends the Product and Serializable traits
// while also providing a toString method.
case object CaseObject {
  def firstName = "John"
  def lastName = "Doe"
  def name: String = firstName + " " + lastName
}
