package tree.ast

class ASTLineStrRef(
	val identifier: String
) : ASTNode(
	"LineStrRef",
	"identifier" to ASTString(identifier)
)

class ASTLineStrText(
	val value: String
) : ASTNode(
	"LineStrText",
	"value" to ASTString(value)
)

class ASTLineStrEscapedChar(
	val value: String
) : ASTNode(
	"LineStrEscapedChar",
	"value" to ASTString(value)
)

class ASTMultiLineStringQuote(
	val count: Int
) : ASTNode(
	"MultiLineStringQuote",
	"count" to ASTNumber(count)
)

class ASTMultiLineStrRef(
	val identifier: String
) : ASTNode(
	"MultiLineStrRef",
	"identifier" to ASTString(identifier)
)

class ASTMultiLineStrText(
	val value: String
) : ASTNode(
	"MultiLineStrText",
	"value" to ASTString(value)
)