fun main() {
	val person = Person(0, "Yurin", 18)
	println(person)
}

data class Person(
	val id: Int,
	val name: String,
	val age: Int
)