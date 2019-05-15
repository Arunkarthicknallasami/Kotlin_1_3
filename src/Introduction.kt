/* In Kotlin 1.3, you can declare main without any parameters. The return type is not specified, which means that the function returns nothing.*/
fun main() {
    literals()
}

/*Data types available
* Double	64
* Float	32
* Long	64
* Int	32
* Short	16
* Byte	8
* */

/*String Literals*/
/*Using triple quote will print as given with retaining formats*/
fun literals() {
    val text = """
    for (c in "foo")
        print(c)
"""
    println("$text")

    /*In the following string | is the margin*/
    val textTrim = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println("$textTrim")
}