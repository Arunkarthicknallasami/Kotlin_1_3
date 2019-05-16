/*Kotlin, similar to C# and Gosu, provides the ability to extend a class with new functionality without having to inherit
from the class or use any type of design pattern such as Decorator.
This is done via special declarations called extensions.
 Kotlin supports extension functions and extension properties.*/
var str: String?  = null
fun main() {
    val l = mutableListOf(1, 2, 3)
    l.swap(0, 2)
    println("$l")
    println("${str.toString()}")

}

/*Extension to swap items in list*/
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

/*Extension to check null*/
fun Any?.toString(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}


/*Declaring Extensions as Members*/
class D {
    fun bar() {  }
}

class E {
    fun baz() {  }


    fun caller(d: D) {
        d.foo()   // call the extension function
    }
    /*In case of a name conflict between the members of the dispatch receiver and the extension receiver,
     the extension receiver takes precedence. To refer to the member of the dispatch receiver you can use the qualified this syntax*/
    fun D.foo() {
        toString()         // calls D.toString()
        this@E.toString()  // calls C.toString()
    }
}