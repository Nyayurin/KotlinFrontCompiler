package tree.ast

class ASTStatements(
	val statement: List<ASTStatement>
) : ASTNode(
	"statements",
	"statement" to ASTList(statement)
)

class ASTStatement(
	val label: List<ASTLabel>,
	val annotation: List<ASTAnnotation>,
	val declaration: ASTDeclaration?,
	val assignment: ASTAssignment?,
	val loopStatement: ASTLoopStatement?,
	val expression: ASTExpression?
) : ASTNode(
	"statement",
	"label" to ASTList(label),
	"annotation" to ASTList(annotation),
	"declaration" to declaration,
	"assignment" to assignment,
	"loopStatement" to loopStatement,
	"expression" to expression
)

class ASTLabel(
	val simpleIdentifier: ASTSimpleIdentifier
) : ASTNode(
	"label",
	"simpleIdentifier" to simpleIdentifier
)

class ASTControlStructureBody(
	val block: ASTBlock?,
	val statement: ASTStatement?
) : ASTNode(
	"controlStructureBody",
	"block" to block,
	"statement" to statement
)

class ASTBlock(
	val statements: ASTStatements
) : ASTNode(
	"block",
	"statements" to statements
)

class ASTLoopStatement(
	val forStatement: ASTForStatement?,
	val whileStatement: ASTWhileStatement?,
	val doWhileStatement: ASTDoWhileStatement?
) : ASTNode(
	"loopStatement",
	"forStatement" to forStatement,
	"whileStatement" to whileStatement,
	"doWhileStatement" to doWhileStatement
)

class ASTForStatement(
	val annotation: List<ASTAnnotation>,
	val variableDeclaration: ASTVariableDeclaration?,
	val multiVariableDeclaration: ASTMultiVariableDeclaration?,
	val expression: ASTExpression,
	val controlStructureBody: ASTControlStructureBody?
) : ASTNode(
	"forStatement",
	"annotation" to ASTList(annotation),
	"variableDeclaration" to variableDeclaration,
	"multiVariableDeclaration" to multiVariableDeclaration,
	"expression" to expression,
	"controlStructureBody" to controlStructureBody
)

class ASTWhileStatement(
	val expression: ASTExpression,
	val controlStructureBody: ASTControlStructureBody?
) : ASTNode(
	"whileStatement",
	"expression" to expression,
	"controlStructureBody" to controlStructureBody
)

class ASTDoWhileStatement(
	val controlStructureBody: ASTControlStructureBody?,
	val expression: ASTExpression
) : ASTNode(
	"doWhileStatement",
	"controlStructureBody" to controlStructureBody,
	"expression" to expression
)

class ASTAssignment(
	val directlyAssignableExpression: ASTDirectlyAssignableExpression?,
	val assignableExpression: ASTAssignableExpression?,
	val assignmentAndOperator: ASTAssignmentAndOperator?,
	val expression: ASTExpression
) : ASTNode(
	"assignment",
	"directlyAssignableExpression" to directlyAssignableExpression,
	"assignableExpression" to assignableExpression,
	"assignmentAndOperator" to assignmentAndOperator,
	"expression" to expression
)