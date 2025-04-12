package tree.ast

class ASTRealLiteral(
	val value: String
) : ASTNode(
	"RealLiteral",
	"value" to ASTString(value)
)

class ASTIntegerLiteral(
	val value: String
) : ASTNode(
	"IntegerLiteral",
	"value" to ASTString(value)
)

class ASTHexLiteral(
	val value: String
) : ASTNode(
	"HexLiteral",
	"value" to ASTString(value)
)

class ASTBinLiteral(
	val value: String
) : ASTNode(
	"BinLiteral",
	"value" to ASTString(value)
)

class ASTUnsignedLiteral(
	val value: String
) : ASTNode(
	"UnsignedLiteral",
	"value" to ASTString(value)
)

class ASTLongLiteral(
	val value: String
) : ASTNode(
	"LongLiteral",
	"value" to ASTString(value)
)

class ASTBooleanLiteral(
	val value: Boolean
) : ASTNode(
	"BooleanLiteral",
	"value" to ASTBoolean(value)
)

object ASTNullLiteral : ASTNode("NullLiteral")

class ASTCharacterLiteral(
	val value: String
) : ASTNode(
	"CharacterLiteral",
	"value" to ASTString(value)
)