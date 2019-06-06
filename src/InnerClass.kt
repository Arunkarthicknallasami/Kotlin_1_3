
//https://www.programiz.com/kotlin-programming/inner-nested-class
//https://www.baeldung.com/kotlin-inner-classes
/*Similar like Java, Kotlin allows you to define a class within another class known as nested class.*/
fun main() {
    // accessing member of Nested class
    println(Outer2().Nested().b)

    // creating object of Nested class
    val nested = Outer2().Nested()
    println(nested.callMe())
    powerOn()

}


/*In Java, when you declare a class inside another class,
 it becomes an inner class by default. However in Kotlin, you need to use inner modifier to create an inner class which we will discuss next.*/
class Outer2 {

    val variableParent = "Outside Nested class."

    /*Inorder for nested class to access value "variableParent" it has to have inner prefix*/
    inner class Nested {
        val b = "Inside Nested class."
        fun callMe() = "Function call from inside Nested class."

        fun callParent() = variableParent
    }
}


/*Local Inner Classes*/

fun powerOn(): String {
    class Led(val color: String) {
        fun blink(): String {
            return "blinking $color"
        }
    }
    val powerLed = Led("Green")
    return powerLed.blink()
}
