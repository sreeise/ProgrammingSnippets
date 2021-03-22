package ClassesAndObjects

class TypeBounds {}

// An upper type bound T <: A declares that type variable T refers to a subtype of type A
// Type parameters and abstract type members can be constrained by a type bound.
// Source: https://docs.scala-lang.org/tour/upper-type-bounds.html

abstract class Animal {
  def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  override def name: String = "Cat"
}

class Dog extends Pet {
  override def name: String = "Dog"
}

class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}

object Main extends App {
  val dogContainer = new PetContainer[Dog](new Dog)
  val catContainer = new PetContainer[Cat](new Cat)
  val petContainer = new PetContainer[Pet](new Dog)
  println(petContainer.pet.name)
}
