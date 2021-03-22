package traits

import ClassesAndObjects.Person

import java.util.Date


trait HtmlWriter[A] {
  def write(in: A): String
}

object HtmlWriter {
  def apply[A](implicit writer: HtmlWriter[A]): HtmlWriter[A] = writer

  implicit object PersonWriter extends HtmlWriter[Person] {
    override def write(person: Person): String = s"<h3>${person.name}</h3>"
  }

  implicit object DateWriter extends HtmlWriter[Date] {
    override def write(date: Date): String = s"<h1>Date: ${date}</h1>"
  }
}
