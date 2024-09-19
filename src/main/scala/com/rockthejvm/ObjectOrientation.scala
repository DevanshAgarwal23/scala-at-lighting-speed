package com.rockthejvm


// java equivalent: public static void main(String[] args) --> App already has implemented the main method
object ObjectOrientation extends App {

  // class and instance
  class Animal{
    val age: Int =0
    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal


  // inheritance
  class Dog(name: String) extends Animal  // constructor definition
  val aDog = new Dog("Jogg")
  // constructor arguments are NOT fields
  // aDog.name // doesn't exists

  // need to put a val before the constructor argument
  class Cat(val name: String) extends Animal{
    override def eat() = println("Cat is eating")
  }
  val aCat = new Cat("Mauuu")
  aCat.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Cat("Alaadin")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime


  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true  // by default public, can restric by adding private and protected
    def walk(): Unit
  }

  // "interface" == ultimate abstract type
  trait  Carnivore {
    def eat(animal: Animal): Unit
  }


  trait Philosopher {
    def ?!(thought: String): Unit // valid method name ==> Scala is very permissive in methode naming
  }

  // single-class inheritance, multi-trait "mixing"
  class Lion extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit =  super.eat()
    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }



  // scala method-notation and method-naming -> scala shines in this compare to other languages
  val aLion = new Lion
  aLion.eat(aDog)
  aLion eat aDog // infix notation = Object method argument, only available for method with ONE argument
  aLion ?! "What if we could fly"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent of above

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I can eat anything")
  }

  /*
    What Compiler does under the hood in case of anonymous classes:-

    class Carnivore_Anonymous_7637698 extends Carnivore {
      override def eat(animal: Animal): Unit = println("I can eat anything")
    }
  */


  // Singleton class --> use object keyword
  object MySingleton {  // the only instance of the MySingleton type
    val mySpecialValue = 768779
    def mySpecialMethod(): Int = mySpecialValue+22
    def apply(x: Int): Int = x+22 // special method in scala
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(2)
  MySingleton(2) // equivalent to MySingleton.apply(2)

  object Animal { // companions - companion Object (of Animal class, defined above)

    // companion can access each other's private fields/methods
    // but Singleton Animal and instance of Animal are different things
    var canLiveForever = false
  }

  val animalCanLiveForever = Animal.canLiveForever // equivalent to "static" field/ method in java

  /*
    case classes (Very common practice in Scala Development) = lightweight data structures with some boilerplate:-
    - sensible equals and has code (helps with dealing with various Collection which depends on it)
    - serialization
    - companion with apply method
    - pattern matching
  */

  case class Person(name: String, age: Int)
  // may be constructed without new
  val bob = Person("Bob", 54)


  // exceptions
  try{
    //code that can throw error or exception
    val x: String = null
    x.length
  }catch {  // In Java: catch(Exception e) { ... }
    case e: Exception => "Some faulty error message"
  } finally{
    // execute some code no matter what
  }

  // Generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail

  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head // String


  // Point #1: in scala we usually operate with IMMUTABLE value/objects
  // Any modification to an object must return ANOTHER object
  /*
      Benefits:-
      1) works miracles in multithreaded/distributed env
      2) helps making sense of code ("reasoning about")
   */
  val reversedList = aList.reverse // returns a NEW list

  // Point #2: Scala is closest to the Object Oriented ideal

}
