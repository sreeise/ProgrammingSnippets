package ClassesAndObjects

class ScalaClasses(name: String) {
  def getName: String = name
}

// Companion Objects
// Allow us to associate functionality with a class without associating it with any instance of that class
class Person(val firstName: String, val lastName: String) {
  def name: String = s"$firstName $lastName"
}

object Person {
  def apply(name: String): Person = {
    val arr = name.split(" ")
    new Person(arr(0), arr(1))
  }
}


// Case Classes
// Shorthand for defining a class and companion object as well as other uses.
// Scala automatically generates a class and companion object for case classes.
// Case classes also include a field for each constructor, a default toString,
// equals and hashCode methods, a copy method, and lastly two trait implementations:
// java.io.Serializable and scala.Product. Serializable allows inspecting the
// number of fields and Product provides the name of the case class.
case class CasePerson(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

// The final keyword on a class prevents the class from being extended elsewhere
// outside of the classes initial implementation.
final class CasePersonFinal(firstName: String, lastName: String)
