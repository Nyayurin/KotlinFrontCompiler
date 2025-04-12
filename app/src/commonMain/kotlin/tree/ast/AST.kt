package tree.ast

sealed class AST {
	final override fun toString() = toString(0)
	abstract fun toString(depth: Int): String
}

class ASTString(private val value: String) : AST() {
	override fun toString(depth: Int) = value
}

class ASTCharacter(private val value: Char) : AST() {
	override fun toString(depth: Int) = value.toString()
}

class ASTNumber(private val value: Number) : AST() {
	override fun toString(depth: Int) = value.toString()
}

class ASTBoolean(private val value: Boolean) : AST() {
	override fun toString(depth: Int) = value.toString()
}

class ASTList<T : ASTNode>(private val list: List<T>) : AST(), List<T> by list {
	override fun toString(depth: Int) = buildString {
		append('[')
		if (list.isNotEmpty()) {
			append(list.joinToString(",\n", "\n", "\n") {
				buildString {
					repeat(depth + 1) {
						append("  ")
					}
					append(it.toString(depth + 1))
				}
			})
			repeat(depth) {
				append("  ")
			}
		}
		append(']')
	}
}

sealed class ASTNode(
	protected val name: String,
	protected vararg val properties: Pair<String, AST?>
) : AST() {
	final override fun toString(depth: Int) = buildString {
		append(name)
		append('(')
		val list = properties.filter { (_, value) ->
			value != null && !(value is ASTList<*> && value.isEmpty())
		}.map { it.first to it.second!! }
		if (list.isNotEmpty()) {
			append(list.joinToString(",\n", "\n", "\n") { (key, value) ->
				buildString {
					repeat(depth + 1) {
						append("  ")
					}
					append("$key: ${value.toString(depth + 1)}")
				}
			})
			repeat(depth) {
				append("  ")
			}
		}
		append(')')
	}
}