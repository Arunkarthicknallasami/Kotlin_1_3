/*Control Flow: if, when, for, while*/

fun main() {
    controlFlowIf()
    controlFlowWhen(1)
    controlFlowFor()
    controlFlowWhile()
}

/******************If************************/

fun controlFlowIf() {
    var a = 10
    var b = 20

    val max = if (a > b) a else b
    println("$max")
    println(max(99, -42))
}

fun max(a: Int, b: Int) = if (a > b) a else b

/******************When************************/

/*when matches its argument against all branches sequentially until some branch condition is satisfied. */

fun whenAssign(obj: Any): Any {
    val result = when (obj) {
        1 -> "one"
        "Hello" -> 1
        is Long -> false
        else -> 42
    }
    return result
}

fun controlFlowWhen(x: Any) {
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        in 10..20 -> print("x is in the range")
        !in 20..30 -> print("x is outside the range")
        is String -> {
            hasPrefix(x)
        }
        else -> print("none of the above")
    }
}

fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

/*When can also be used without arguments*/
/* when {
     x.isOdd() -> print("x is odd")
     x.isEven() -> print("x is even")
     else -> print("x is funny")
 }*/
/*Since Kotlin 1.3, it is possible to capture when subject in a variable using following syntax:
*/
/*fun Request.getBody() =
    when (val response = executeRequest()) {
        is Success -> response.body
        is HttpError -> throw HttpException(response.status)
    }*/


/*******************For*********************/
fun controlFlowFor() {
    for (i in 1..3) {
        println(i)
    }
    for (i in 6 downTo 0 step 2) {
        println(i)
    }
    val array = arrayOf("a", "b", "c")
    for (i in array.indices) {
        println(array[i])
    }
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }

    /*This gets index value elements from collection*/
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}


/*******************While**********************/

fun controlFlowWhile(){
    fun eatACake() = println("Eat a Cake")
    fun bakeACake() = println("Bake a Cake")
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {
        eatACake()
        cakesEaten ++
    }

    do {                                       
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)


}