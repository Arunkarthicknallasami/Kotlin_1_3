//https://medium.com/@agrawalsuneet/type-aliases-in-kotlin-646ab9186d4b
//https://typealias.com/guides/all-about-type-aliases/

/*You can define this typealias in any Kotlin file within the project but outside the class.
You can not define the typealias inside any class as nested and local type aliases are not supported.
If you try to do this, you’ll get this error message from the compiler - "Nested and local type aliases are not supported."*/

typealias Predicate<T> = (T) -> Boolean

//Examples of type alias
// Classes and Interfaces
typealias RegularExpression = String
//typealias IntentData = Parcelable

// Nullable types
typealias MaybeString = String?

// Generics with Type Parameters
typealias MultivaluedMap<K, V> = HashMap<K, List<V>>
typealias Lookup<T> = HashMap<T, T>

// Generics with Concrete Type Arguments
typealias Users = ArrayList<User>

// Type Projections
typealias Strings = Array<out String>
typealias OutArray<T> = Array<out T>
typealias AnyIterable = Iterable<*>

// Objects (including Companion Objects)
typealias RegexUtil = Regex.Companion

//// Function Types
//typealias ClickHandler = (View) -> Unit
//
//// Lambda with Receiver
//typealias IntentInitializer = Intent.() -> Unit
//
//// Nested Classes and Interfaces
//typealias NotificationBuilder = NotificationCompat.Builder
//typealias OnPermissionResult = ActivityCompat.OnRequestPermissionsResultCallback

// Enums
typealias DirectionWalk = kotlin.io.FileWalkDirection
// (but you cannot alias a single enum *entry*)

// Annotation
typealias Multifile = JvmMultifileClass

fun foo(p: Predicate<Int>) = p(42)

typealias MapIntToList = HashMap<Int, List<String>>

class UniqueIdentifier(val value: Int)

typealias UserId = UniqueIdentifier

fun main() {
    //Example 1
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // prints "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p))

    //Example 2
    val map = MapIntToList()

    map[0] = listOf("Hey Arun")

    var value: MapIntToList = map

    println("$value")

    //Example 3
    val firstUserId: UserId = UserId(0)

    println("${firstUserId.value}")


}

