//https://github.com/Kotlin/KEEP/blob/master/proposals/inline-classes.md
//https://blog.worldline.tech/2018/12/05/kotlin-1-3-inline-class.html
//https://realjenius.com/2018/10/24/inline-classes/
//https://medium.com/@anvith/working-with-kotlin-inline-class-daac9822596f

/*Inline classes are declared using soft keyword inline and must have a single property:*/

/**Currently, inline classes must satisfy the following requirements:

Inline class must have a public primary constructor with a single value parameter
Inline class must have a single read-only (val) property as an underlying value, which is defined in primary constructor
Underlying value cannot be of the same type that is containing inline class
Inline class with undefined (recursively defined) generics, e.g. generics with an upper bound equal to the class, is prohibited
inline class A<T : A<T>>(val x: T) // error
Inline class cannot have init block
Inline class must be final
Inline class can implement only interfaces
Inline class cannot have backing fields
Hence, it follows that inline class can have only simple computable properties (no lateinit/delegated properties)
Inline class must be a toplevel class
 */

/**inline vs typealias*/
inline class InlineMinutes(val minutes: Int)
typealias TypealiasMinutes = Int

fun main() {

    /*As we can see, the InlineMail class is not created, which means less memory footprint.
    In addition to the memory footprint gain, we have added an abstraction level making our code less error prone.*/
    val mail2 = DataMail("toto-gmail.com")
    println("type: ${mail2.javaClass.name}, value: ${mail2.mail}, valid: ${mail2.isValid()}, dns: ${mail2.dns()}")
    val mail1 = InlineMail("toto@gmail.com")
    println("type: ${mail1.javaClass.name}, value: ${mail1.mail}, valid: ${mail1.isValid()}, dns: ${mail1.dns()}")

    /**inline vs typealias*/
    /*Inline classes behave like typealiases at runtime because they are replaced with their underlying type.
     However, they are different at compile time because inline classes are viewed as plain classes that introduce a new type.
     Thus, an inline class to a Int is not compatible with neither a Int nor a typealias for a Int.
     The following code illustrates the differences between a typealias and an inline class. The code that does not compile is commented.
    */
    var tam: TypealiasMinutes = 10
    var i: Int = 10
    tam = i
    // var im: InlineMinutes = 10 //not possible
    // var im2: InlineMinutes = tam //not possible
    var im3: InlineMinutes = InlineMinutes(10)
    //tam = im3 //not possible
    //im3 = i //not possible
}

//Ref: https://blog.worldline.tech/2018/12/05/kotlin-1-3-inline-class.html
inline class InlineMail(val mail: String) {
    fun isValid() = mail.contains("@")
    fun dns() = if (isValid()) mail.substringAfter("@") else ""
}

data class DataMail(val mail: String) {
    fun isValid() = mail.contains("@")
    fun dns() = if (isValid()) mail.substringAfter("@") else ""
}

