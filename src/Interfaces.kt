fun main() {

    val obj = InterfaceImp()

    println("test = ${obj.test}")
    print("Calling hello(): ")

    obj.hello()

    print("Calling and printing foo(): ")
    println(obj.foo())



    val objInterface = CommonInterface()

    objInterface.callMe()
}

/*Interface with body tag will be optional to implement*/

interface MyInterface {

    val test: Int   // abstract property

    fun foo() : String   // abstract method (returns String)
    fun hello() {   // method with default implementation
        // body (optional)
    }
}

class InterfaceImp : MyInterface {

    override val test: Int = 25
    override fun foo() = "Lol"

    // other code
}


/*Two of interfaces has same name in their methods and the class which implements them has to use Super to identify and implement them to avoid conflict*/

interface interface1 {

    fun callMe() {
        println("From interface A")
    }
}

interface interface2  {
    fun callMe() {
        println("From interface B")
    }
}


class CommonInterface: interface1, interface2 {
    override fun callMe() {
        super<interface1>.callMe()
        super<interface2>.callMe()
    }
}