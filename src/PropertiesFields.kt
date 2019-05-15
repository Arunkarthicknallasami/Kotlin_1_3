fun main() {
    val p = PersonProperty()
    p.name = "jack"
    println("${p.name}")
    p.address = "down street new york"
    println("${p.address}")
}

/*Custom properties for variables*/
/*Fields cannot be declared directly in Kotlin classes. However, when a property needs a backing field, Kotlin provides it automatically.
This backing field can be referenced in the accessors using the field identifier. The field identifier can only be used in the accessors of the property.
A backing field will be generated for a property if it uses the default implementation of at least one of the accessors,
or if a custom accessor references it through the field identifier*/
class PersonProperty {
    /*Here value is customised when setting to it*/
    var name: String = "defaultValue"
        get() = field
        set(value) {
            field = value.capitalize() + " Ryan"
        }

    /*Here value is customised when getting out to it*/
    var address: String = ""
        get() {
            return field.capitalize()
        }
        set(value) {
            field = value
        }

    var stringRepresentation: String = ""
        get() = this.toString()

    /*Value of this will be initiated lately*/
    lateinit var subject: String


}
