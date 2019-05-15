fun main() {
    breakFunction()
    continueFunction()
}

/* Break terminates the nearest enclosing loop when encountered (without checking the test expression). It basically ends the execution at that point*/
fun breakFunction() {

    var sum = 0
    var number: Int

    while (true) {
        print("Enter a number: ")
        number = readLine()!!.toInt()

        if (number == 0)
            break

        sum += number
    }

    print("sum = $sum")

    labelledBreak()
}

fun labelledBreak(){
    /*This one breaks entire loop*/
    first@ for (i in 1..4) {

        second@ for (j in 1..2) {
            println("i = $i; j = $j")

            if (i == 2)
                break@first
        }
    }

    /*This one breaks second loop*/
    first@ for (i in 1..4) {

        second@ for (j in 1..2) {
            println("i = $i; j = $j")

            if (i == 2)
                break@second
        }
    }

}

/*The continue construct skips the current iteration of the enclosing loop, and the control of the program jumps to the end of the loop body. It skips the execution*/

fun continueFunction(){
    var number: Int
    var sum = 0

    for (i in 1..6) {
        print("Enter an integer: ")
        number = readLine()!!.toInt()

        if (number <= 0)
            continue

        sum += number
    }
    println("sum = $sum")

    labelledContinue()
}

fun labelledContinue(){

    here@ for (i in 1..5) {
        for (j in 1..4) {
            if (i == 3 || j == 2)
                continue@here
            println("i = $i; j = $j")
        }
    }
}