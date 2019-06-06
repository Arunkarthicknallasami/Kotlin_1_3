/*Abstract, data, enum, sealed*/
/*All classes in Kotlin have a common superclass Any, that is the default superclass for a class with no supertypes declared:*/
/*Note: Any is not java.lang.Object; in particular, it does not have any members other than equals(), hashCode() and toString()*/

/*Visibility Modifiers
* If you do not specify any visibility modifier, public is used by default, which means that your declarations will be visible everywhere;
* If you mark a declaration private, it will only be visible inside the file containing the declaration;
* If you mark it internal, it is visible everywhere in the same module;
* protected is not available for top-level declarations.
* */
fun main() {
    /*All classes in Kotlin have a common superclass Any, that is the default superclass for a class with no supertypes declared
  * Note: Any is not java.lang.Object; in particular, it does not have any members other than equals(), hashCode() and toString().
  * */
    InitOrderDemo("hello")
    var person = ConstructorWithArguments("Suresh", 25, "Developer")
    person.printPersonDetails()
    ConstructorWithoutArguments(5)


    //inheritance
    val t1 = MathTeacher(25, "Jack")
    t1.teachMaths()

    println()

    val f1 = Footballer(29, "Christiano")
    f1.playFootball()

    val p1 = AuthLog("Bad Password")


    val d = Derived("hello", "world")


    val e = C()
    e.f()

    /*object Expression - These are anonymous class instances*/
    rentPrice(10, 2, 1)

    /*Anonymous objects can be used to define an implementation of an interface or an abstract class without
    creating a reusable implementation*/
    val atheist = object : ObjectAnonymous() {
        override fun pray() = println("I don't pray. I am an atheist.")
    }

    atheist.eat()
    atheist.talk()
    atheist.pray()

    DoAuth.takeParams("foo", "qwerty")                          //3

    /*Inner class*/
    val demo = Outer().Inner().foo()


}

/***********************************************************/
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

/***********************************************************/
//primary constructor with no arguments
class ConstructorWithoutArguments {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Secondary constructor")
    }
}

/***********************************************************/
//Primary Constructor with Arguments, when we add var or val in constructor arguments then those variables can be accessed inside class
class ConstructorWithArguments constructor(var name: String, var age: Int) {
    var profession: String = "Not Mentioned"

    init {
        println("Init block $name")
    }

    constructor (name: String, age: Int, profession: String) : this(name, age) {
        this.profession = profession
    }

    fun printPersonDetails() {
        println("$name whose profession is $profession, is $age years old.")
    }
}

/***********************************************************/
//inheritance - Class with primary constructor and arguments
/*By default, classes in Kotlin are final. If you are familiar with Java,
 you know that a final class cannot be subclassed.
 By using the open annotation on a class, compiler allows you to derive new classes from it.*/
open class Person(age: Int, name: String) {

    init {
        println("My name is $name.")
        println("My age is $age")
    }

    open fun displayAge(age: Int) {
        println("My age is $age.")
    }
}

class MathTeacher(age: Int, name: String) : Person(age, name) {

    fun teachMaths() {
        println("I teach in primary school.")
    }

    override fun displayAge(age: Int) {
        println("My fake age is ${age - 5}.")
    }
}

class Footballer(age: Int, name: String) : Person(age, name) {
    fun playFootball() {
        println("I play for LA Galaxy.")
    }
}

/***********************************************************/

//inheritance - Class with no primary constructor
open class Log {
    var data: String = ""
    var numberOfData = 0


    constructor(_data: String) {

    }

    constructor(_data: String, _numberOfData: Int) : this(_data) {
        data = _data
        numberOfData = _numberOfData
        println("$data: $numberOfData times")
    }
}

class AuthLog : Log {
    constructor(_data: String) : this("From AuthLog -> + $_data", 10) {
    }

    constructor(_data: String, _numberOfData: Int) : super(_data, _numberOfData) {
    }
}

/***********************************************************/
//overriding and functional flow in inheritance

open class Base(val name: String) {

    init {
        println("Initializing Base")
    }

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }
}

class Derived(
    name: String,
    val lastName: String
) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init {
        println("Initializing Derived")
    }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

/***********************************************************/
//overriding when more than one instance of a method is found from inherited classes
open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } // interface members are 'open' by default

    fun b() {
        print("b")
    }
}

class C() : A(), B {
    override fun b() {
    }

    // The compiler requires f() to be overridden:
    override fun f() {
        super<A>.f() // call to A.f()
        super<B>.f() // call to B.f()
        println("extended classes function")
    }
}

/***********************************************************/
/*abstract keyword is used to declare abstract classes in Kotlin.
An abstract class cannot be instantiated (you cannot create objects of an abstract class). However, you can inherit subclasses from can them*/
/*Abstract classes are always open. You do not need to explicitly use open keyword to inherit subclasses from them.By default, the members of an abstract class are non-abstract unless stated otherwise.*/
//abstract class
open class Base2 {
    open fun f() {}
}

abstract class Derived2 : Base2() {
    abstract override fun f()
}

//here 3rd class extends an abstract class which implements base2 class's method and which gets overridden automatically
class Derived3 : Derived2() {
    override fun f() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


/**************************************************************/
/*Classes and objects in Kotlin work the same way as in most object-oriented languages: a class is a blueprint, and an object is an instance of a class. */
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    print("Total price: $$total")                                               //4

}


object DoAuth {                                                 //1
    fun takeParams(username: String, password: String) {         //2
        println("input Auth parameters = $username:$password")
    }
}


/*******************************Inner class****************************/
/*A class may be marked as inner to be able to access members of outer class. Inner classes carry a reference to an object of an outer class*/

class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
        fun result() = result
    }

    /*Companion objects are part of class and may or may not have a name fot themselves*/
    companion object cmpInstance{
        var result: String = "Pass"
    }
}

//A big difference between anonymous objects in Kotlin and anonymous inner classes in Java is that
// anonymous objects can implement multiple interfaces and methods.
open class ObjectAnonymous() {
    fun eat() = println("Eating food.")

    fun talk() = println("Talking with people.")

    open fun pray() = println("Praying god.")
}

interface Switcher {
    fun on(): String
}
