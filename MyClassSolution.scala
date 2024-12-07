```scala
class MyClass[T](val value: T) {
  def this() = this(null.asInstanceOf[T])
}

// Better Solution:
class MyClassImproved[T](val value: Option[T] = None) // Uses Option to handle nullable types

object Main extends App {
  val myInstance = new MyClass[String]() // This will work, but may have issues later.
  val myImprovedInstance = new MyClassImproved[String]() // This is safer, value will be None
  val myImprovedInstance2 = new MyClassImproved[String](Some("hello")) // This is how you would use it.
  println(myInstance.value) //prints null, but using it can cause runtime errors
  println(myImprovedInstance.value) //prints None
  println(myImprovedInstance2.value) //prints Some(hello)
}
```