import com.strumenta.antlrkotlin.parsers.generated.KotlinLexer
import com.strumenta.antlrkotlin.parsers.generated.KotlinParser
import org.antlr.v4.kotlinruntime.CharStreams
import org.antlr.v4.kotlinruntime.CommonTokenStream

fun main() {
	val lexer = KotlinLexer(CharStreams.fromFileName("../kotlin/src/Main.kt"))
	val parser = KotlinParser(CommonTokenStream(lexer))
	val kotlinFile = parser.kotlinFile().visit()
	println(kotlinFile)
}