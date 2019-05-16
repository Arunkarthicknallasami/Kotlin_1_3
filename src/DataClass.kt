/*
The primary constructor must have at least one parameter.
The parameters of the primary constructor must be marked as either val (read-only) or var (read-write).
The class cannot be open, abstract, inner or sealed.
The class may extend other classes or implement interfaces.
*/

fun main() {
    val jack = User("jack", 29,"Male")
    println("name = ${jack.name}")
    println("age = ${jack.age}")


    /*Copying*/
    val u1 = User("John", 29, "Male")

    // using copy function to create an object
    val u2 = u1.copy(name = "Randy")

    println("u1: name = ${u1.name}, name = ${u1.age}")
    println("u2: name = ${u2.name}, name = ${u2.age}")

    /*Destructuring Declarations*/
    val (name, age, gender) = u1
    println("name = $name")
    println("age = $age")
    println("gender = $gender")

    /*Instead of defining name we can also use ComponentN() Function*/
    println(u1.component1())     // John
    println(u1.component2())     // 29
    println(u1.component3())
}


data class User(val name: String, val age: Int, val gender: String)

