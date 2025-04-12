package tree.ast

class ASTEnumClassBody(
	val enumEntries: ASTEnumEntries?,
	val classMemberDeclarations: ASTClassMemberDeclarations?
) : ASTNode(
	"enumClassBody",
	"enumEntries" to enumEntries,
	"classMemberDeclarations" to classMemberDeclarations
)

class ASTEnumEntries(
	val enumEntry: List<ASTEnumEntry>
) : ASTNode(
	"enumEntries",
	"enumEntry" to ASTList(enumEntry)
)

class ASTEnumEntry(
	val modifiers: ASTModifiers?,
	val simpleIdentifier: ASTSimpleIdentifier,
	val valueArguments: ASTValueArguments?,
	val classBody: ASTClassBody?
) : ASTNode(
	"enumEntry",
	"modifiers" to modifiers,
	"simpleIdentifier" to simpleIdentifier,
	"valueArguments" to valueArguments,
	"classBody" to classBody
)