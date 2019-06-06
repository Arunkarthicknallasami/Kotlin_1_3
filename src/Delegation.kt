//https://proandroiddev.com/delegation-in-kotlin-e1efb849641

/**Delegation is the assignment of authority from one instance to another.
 * Kotlin supports delegation natively by language in the form of Class Delegation and Delegated Properties.
*/

fun main() {

    val person = PersonDelegate(JackName(), LongDistanceRunner())
    println(person.name) //Jack
    person.run() //long
}

//Class Delegation
//Ref: https://proandroiddev.com/delegation-in-kotlin-e1efb849641
interface Nameable {
    var name: String
}

class JackName : Nameable {
    override var name: String = "Jack"
}

class LongDistanceRunner: Runnable {
    override fun run() {
        println("long")
    }
}

class PersonDelegate(name: Nameable, runner: Runnable): Nameable by name, Runnable by runner
