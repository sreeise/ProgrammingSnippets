package ClassesAndObjects

object ImplicitClass {
  implicit class StringMethods(str: String) {
    val vowels = Seq('a', 'e', 'i', 'o', 'u')

    def numberOfVowels: Int =
      str.toList.count(vowels contains _)
  }
}
