/**
Generics are a powerful feature that allows us to define a common class/method/property that can be operated using different types while keeping a check of the compile-time type safety.
They are commonly used in Collections.
A generic type is a class or interface that is parameterized over types. We use angle brackets (<>) to specify the type parameter. To understand Generics, we need to understand types.
Every class has a type which is generally the same as the class*/
/*Ref :
 https://proandroiddev.com/understanding-generics-and-variance-in-kotlin-714c14564c47
 https://play.kotlinlang.org/byExample/01_introduction/06_Generics
 */
/**
 * class vs type
 * String is a class and String? is a type
 * List is a class and List<String> is a type
 * */

/**
 * Subclass vs subtype
 * For a class to be a subclass of another class, it needs to inherit from it. For example, Integer inherits from Number, so Integer is a subclass of Number
 * */
fun main() {
    var ageInt: PersonGenerics<Int> = PersonGenerics<Int>(30)
    var ageString: PersonGenerics<String> = PersonGenerics<String>("40")

    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)
}


class PersonGenerics<T>(age: T){
    var age: T = age
    init {
        this.age= age
        println(age)
    }
}


fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)


/**
 * Generics are a genericity mechanism that's become standard in modern languages. Generic classes and functions increase code reusability by encapsulating common logic
 * that is independent of a particular generic type, like the logic inside a List<T> is independent of what T is.
 *
- Defines a generic class MutableStack<E> where E is called the generic type parameter. At use-site, it is assigned to a specific type such as Int by declaring a MutableStack<Int>.
- Inside the generic class, E can be used as a parameter like any other type.
- You can also use E as a return type.
 * */

class MutableStack<E>(vararg items: E) {              // 1

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)        // 2

    fun peek(): E = elements.last()                     // 3

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}