/**
 * All subclasses of a sealed class must be declared in the same file where sealed class is declared.
A sealed class is abstract by itself, and you cannot instantiate objects from it.
You cannot create non-private constructors of a sealed class; their constructors are private by default.
A sealed class cannot be instantiated. Hence, are implicitly abstract.
 */
/**
 * Sealed classes allow us to create instances with different types, unlike Enums which restrict us to use the same type for all enum constants.
 * Enum classes allow only a single type for all constants.
 * Sealed classes allows multiple instances.
 * */
fun main() {
    val add = execute(5, Operation.Add(5))
    println("added value is $add")


    val decrement = execute2(5, Operation2.Decrement)
    println("decremented value is $decrement")


    sealedSample()

    val sub = Operation.Substract(5)
    println("value is ${sub.sub()}")


    var circle = Shape.Circle(4.5f)
    var square = Shape.Square(4)
    var rectangle = Shape.Rectangle(4,5)

    eval(circle)
    eval(square)
    eval(rectangle)
}

// each classes can have their own instance when invoked
sealed class Operation {
    class Add(val value: Int) : Operation()
    class Substract(val value: Int) : Operation() {
        fun sub() = if (value > 1) value - 1 else 0
    }

    class Multiply(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()

}

fun execute(x: Int, op: Operation) = when (op) {
    is Operation.Add -> x + op.value
    is Operation.Substract -> x - op.value
    is Operation.Multiply -> x * op.value
    is Operation.Divide -> x / op.value
}

/**objects are used instead of classes.This is because if a subclass doesn’t keep state, it can just be an object.
 * All the instances you create for that class would be exactly the same, as they can’t have different state. 'is' can be omitted for these cases
 * when objects are used inside sealed class.
 * Note:  operations that have no state can be objects, because we don’t need different instances.
 * */

sealed class Operation2 {
    object Increment : Operation2()
    object Decrement : Operation2()
}

fun execute2(x: Int, op: Operation2) = when (op) {
    Operation2.Increment -> x + 1
    Operation2.Decrement -> x - 1
}


/**sealed class examples*/
sealed class MyExample {
    class OP1 : MyExample() // MyExmaple class can be of two types only
    class OP2 : MyExample()
}

fun sealedSample() {
    val obj: MyExample = MyExample.OP2()

    val output = when (obj) { // defining the object of the class depending on the inputs
        is MyExample.OP1 -> "Option One has been chosen"
        is MyExample.OP2 -> "option Two has been chosen"
    }

    println(output)
}


sealed class Shape{
    class Circle(var radius: Float): Shape()
    class Square(var length: Int): Shape()
    class Rectangle(var length: Int, var breadth: Int): Shape()
}

fun eval(e: Shape) =
    when (e) {
        is Shape.Circle -> println("Circle area is ${3.14*e.radius*e.radius}")
        is Shape.Square -> println("Square area is ${e.length*e.length}")
        is Shape.Rectangle -> println("Rectagle area is ${e.length*e.breadth}")
    }