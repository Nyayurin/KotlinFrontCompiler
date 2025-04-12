package tree.ast

class ASTSimpleIdentifier(
	val value: String
) : ASTNode(
	"simpleIdentifier",
	"value" to ASTString(value)
)

class ASTIdentifier(
	val simpleIdentifier: List<ASTSimpleIdentifier>
) : ASTNode(
	"identifier",
	"simpleIdentifier" to ASTList(simpleIdentifier)
)