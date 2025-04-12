package tree.ast

class ASTExpression(
	val disjunction: ASTDisjunction
) : ASTNode(
	"expression",
	"disjunction" to disjunction
)

class ASTDisjunction(
	val conjunction: List<ASTConjunction>
) : ASTNode(
	"disjunction",
	"conjunction" to ASTList(conjunction),
)

class ASTConjunction(
	val equality: List<ASTEquality>
) : ASTNode(
	"conjunction",
	"equality" to ASTList(equality),
)

class ASTEquality(
	val comparison: List<ASTComparison>,
	val equalityOperator: List<ASTEqualityOperator>
) : ASTNode(
	"equality",
	"comparison" to ASTList(comparison),
	"equalityOperator" to ASTList(equalityOperator)
)

class ASTComparison(
	val genericCallLikeComparison: List<ASTGenericCallLikeComparison>,
	val comparisonOperator: List<ASTComparisonOperator>
) : ASTNode(
	"comparison",
	"genericCallLikeComparison" to ASTList(genericCallLikeComparison),
	"comparisonOperator" to ASTList(comparisonOperator)
)

class ASTGenericCallLikeComparison(
	val infixOperation: ASTInfixOperation,
	val callSuffix: List<ASTCallSuffix>
) : ASTNode(
	"genericCallLikeComparison",
	"infixOperation" to infixOperation,
	"callSuffix" to ASTList(callSuffix)
)

class ASTInfixOperation(
	val elvisExpression: ASTElvisExpression,
	val sub: List<Sub>
) : ASTNode(
	"infixOperation",
	"elvisExpression" to elvisExpression,
	"sub" to ASTList(sub)
) {
	sealed class Sub(name: String, vararg properties: Pair<String, AST?>) : ASTNode(name, *properties)

	class In(
		val operator: ASTInOperator,
		val right: ASTElvisExpression
	) : Sub(
		"in",
		"operator" to operator,
		"right" to right
	)

	class Is(
		val operator: ASTIsOperator,
		val right: ASTType
	) : Sub(
		"in",
		"operator" to operator,
		"right" to right
	)
}

class ASTElvisExpression(
	val infixFunctionCall: List<ASTInfixFunctionCall>
) : ASTNode(
	"elvisExpression",
	"infixFunctionCall" to ASTList(infixFunctionCall)
)

class ASTInfixFunctionCall(
	val rangeExpression: List<ASTRangeExpression>,
	val simpleIdentifier: List<ASTSimpleIdentifier>
) : ASTNode(
	"infixFunctionCall",
	"rangeExpression" to ASTList(rangeExpression),
	"simpleIdentifier" to ASTList(simpleIdentifier)
)

class ASTRangeExpression(
	val additiveExpression: List<ASTAdditiveExpression>,
	val sub: List<Sub>
) : ASTNode(
	"rangeExpression",
	"additiveExpression" to ASTList(additiveExpression),
	"sub" to ASTList(sub)
) {
	sealed class Sub(name: String) : ASTNode(name)
	object Range : Sub("RANGE")
	object RangeUntil : Sub("RANGE_UNTIL")
}

class ASTAdditiveExpression(
	val multiplicativeExpression: List<ASTMultiplicativeExpression>,
	val additiveOperator: List<ASTAdditiveOperator>
) : ASTNode(
	"additiveExpression",
	"multiplicativeExpression" to ASTList(multiplicativeExpression),
	"additiveOperator" to ASTList(additiveOperator)
)

class ASTMultiplicativeExpression(
	val asExpression: List<ASTAsExpression>,
	val multiplicativeOperator: List<ASTMultiplicativeOperator>
) : ASTNode(
	"multiplicativeExpression",
	"asExpression" to ASTList(asExpression),
	"multiplicativeOperator" to ASTList(multiplicativeOperator)
)

class ASTAsExpression(
	val prefixUnaryExpression: ASTPrefixUnaryExpression,
	val asOperator: List<ASTAsOperator>,
	val type: List<ASTType>
) : ASTNode(
	"asExpression",
	"prefixUnaryExpression" to prefixUnaryExpression,
	"asOperator" to ASTList(asOperator),
	"type" to ASTList(type)
)

class ASTPrefixUnaryExpression(
	val unaryPrefix: List<ASTUnaryPrefix>,
	val postfixUnaryExpression: ASTPostfixUnaryExpression
) : ASTNode(
	"prefixUnaryExpression",
	"unaryPrefix" to ASTList(unaryPrefix),
	"postfixUnaryExpression" to postfixUnaryExpression
)

class ASTUnaryPrefix(
	val annotation: ASTAnnotation?,
	val label: ASTLabel?,
	val prefixUnaryOperator: ASTPrefixUnaryOperator?
) : ASTNode(
	"unaryPrefix",
	"annotation" to annotation,
	"label" to label,
	"prefixUnaryOperator" to prefixUnaryOperator
)

class ASTPostfixUnaryExpression(
	val primaryExpression: ASTPrimaryExpression,
	val postfixUnarySuffix: List<ASTPostfixUnarySuffix>
) : ASTNode(
	"postfixUnaryExpression",
	"primaryExpression" to primaryExpression,
	"postfixUnarySuffix" to ASTList(postfixUnarySuffix)
)

class ASTPostfixUnarySuffix(
	val postfixUnaryOperator: ASTPostfixUnaryOperator?,
	val typeArguments: ASTTypeArguments?,
	val callSuffix: ASTCallSuffix?,
	val indexingSuffix: ASTIndexingSuffix?,
	val navigationSuffix: ASTNavigationSuffix?
) : ASTNode(
	"postfixUnarySuffix",
	"postfixUnaryOperator" to postfixUnaryOperator,
	"typeArguments" to typeArguments,
	"callSuffix" to callSuffix,
	"indexingSuffix" to indexingSuffix,
	"navigationSuffix" to navigationSuffix
)

class ASTDirectlyAssignableExpression(
	val postfixUnaryExpression: ASTPostfixUnaryExpression?,
	val assignableSuffix: ASTAssignableSuffix?,
	val simpleIdentifier: ASTSimpleIdentifier?,
	val parenthesizedDirectlyAssignableExpression: ASTParenthesizedDirectlyAssignableExpression?
) : ASTNode(
	"directlyAssignableExpression",
	"postfixUnaryExpression" to postfixUnaryExpression,
	"assignableSuffix" to assignableSuffix,
	"simpleIdentifier" to simpleIdentifier,
	"parenthesizedDirectlyAssignableExpression" to parenthesizedDirectlyAssignableExpression
)

class ASTParenthesizedDirectlyAssignableExpression(
	val directlyAssignableExpression: ASTDirectlyAssignableExpression
) : ASTNode(
	"parenthesizedDirectlyAssignableExpression",
	"directlyAssignableExpression" to directlyAssignableExpression
)

class ASTAssignableExpression(
	val prefixUnaryExpression: ASTPrefixUnaryExpression?,
	val parenthesizedAssignableExpression: ASTParenthesizedAssignableExpression?
) : ASTNode(
	"assignableExpression",
	"prefixUnaryExpression" to prefixUnaryExpression,
	"parenthesizedAssignableExpression" to parenthesizedAssignableExpression
)

class ASTParenthesizedAssignableExpression(
	val assignableExpression: ASTAssignableExpression
) : ASTNode(
	"parenthesizedAssignableExpression",
	"assignableExpression" to assignableExpression
)

class ASTAssignableSuffix(
	val typeArguments: ASTTypeArguments?,
	val indexingSuffix: ASTIndexingSuffix?,
	val navigationSuffix: ASTNavigationSuffix?
) : ASTNode(
	"assignableSuffix",
	"typeArguments" to typeArguments,
	"indexingSuffix" to indexingSuffix,
	"navigationSuffix" to navigationSuffix
)

class ASTIndexingSuffix(
	val expression: List<ASTExpression>
) : ASTNode(
	"indexingSuffix",
	"expression" to ASTList(expression)
)

class ASTNavigationSuffix(
	val memberAccessOperator: ASTMemberAccessOperator,
	val simpleIdentifier: ASTSimpleIdentifier?,
	val parenthesizedExpression: ASTParenthesizedExpression?,
	val `class`: Boolean
) : ASTNode(
	"navigationSuffix",
	"memberAccessOperator" to memberAccessOperator,
	"simpleIdentifier" to simpleIdentifier,
	"parenthesizedExpression" to parenthesizedExpression,
	"class" to ASTBoolean(`class`)
)

class ASTCallSuffix(
	val typeArguments: ASTTypeArguments?,
	val valueArguments: ASTValueArguments?,
	val annotatedLambda: ASTAnnotatedLambda?
) : ASTNode(
	"callSuffix",
	"valueArguments" to valueArguments,
	"annotatedLambda" to annotatedLambda
)

class ASTAnnotatedLambda(
	val annotation: List<ASTAnnotation>,
	val label: ASTLabel?,
	val lambdaLiteral: ASTLambdaLiteral
) : ASTNode(
	"annotatedLambda",
	"annotation" to ASTList(annotation),
	"label" to label,
	"lambdaLiteral" to lambdaLiteral
)

class ASTTypeArguments(
	val typeProjection: List<ASTTypeProjection>
) : ASTNode(
	"typeArguments",
	"typeProjection" to ASTList(typeProjection)
)

class ASTValueArguments(
	val valueArgument: List<ASTValueArgument>
) : ASTNode(
	"valueArguments",
	"valueArgument" to ASTList(valueArgument)
)

class ASTValueArgument(
	val annotation: ASTAnnotation?,
	val simpleIdentifier: ASTSimpleIdentifier?,
	val multi: Boolean,
	val expression: ASTExpression
) : ASTNode(
	"valueArgument",
	"annotation" to annotation,
	"simpleIdentifier" to simpleIdentifier,
	"multi" to ASTBoolean(multi),
	"expression" to expression
)

class ASTPrimaryExpression(
	val parenthesizedExpression: ASTParenthesizedExpression?,
	val simpleIdentifier: ASTSimpleIdentifier?,
	val literalConstant: ASTLiteralConstant?,
	val stringLiteral: ASTStringLiteral?,
	val callableReference: ASTCallableReference?,
	val functionLiteral: ASTFunctionLiteral?,
	val objectLiteral: ASTObjectLiteral?,
	val collectionLiteral: ASTCollectionLiteral?,
	val thisExpression: ASTThisExpression?,
	val superExpression: ASTSuperExpression?,
	val ifExpression: ASTIfExpression?,
	val whenExpression: ASTWhenExpression?,
	val tryExpression: ASTTryExpression?,
	val jumpExpression: ASTJumpExpression?
) : ASTNode(
	"primaryExpression",
	"parenthesizedExpression" to parenthesizedExpression,
	"simpleIdentifier" to simpleIdentifier,
	"literalConstant" to literalConstant,
	"stringLiteral" to stringLiteral,
	"callableReference" to callableReference,
	"functionLiteral" to functionLiteral,
	"ObjectLiteral" to objectLiteral,
	"collectionLiteral" to collectionLiteral,
	"thisExpression" to thisExpression,
	"superExpression" to superExpression,
	"ifExpression" to ifExpression,
	"whenExpression" to whenExpression,
	"tryExpression" to tryExpression,
	"jumpExpression" to jumpExpression
)

class ASTParenthesizedExpression(
	val expression: ASTExpression
) : ASTNode(
	"parenthesizedExpression",
	"expression" to expression
)

class ASTCollectionLiteral(
	val expression: List<ASTExpression>
) : ASTNode(
	"collectionLiteral",
	"expression" to ASTList(expression)
)

class ASTLiteralConstant(
	val booleanLiteral: ASTBooleanLiteral?,
	val integerLiteral: ASTIntegerLiteral?,
	val hexLiteral: ASTHexLiteral?,
	val binLiteral: ASTBinLiteral?,
	val characterLiteral: ASTCharacterLiteral?,
	val realLiteral: ASTRealLiteral?,
	val nullLiteral: ASTNullLiteral?,
	val longLiteral: ASTLongLiteral?,
	val unsignedLiteral: ASTUnsignedLiteral?
) : ASTNode(
	"literalConstant",
	"booleanLiteral" to booleanLiteral,
	"integerLiteral" to integerLiteral,
	"hexLiteral" to hexLiteral,
	"binLiteral" to binLiteral,
	"characterLiteral" to characterLiteral,
	"realLiteral" to realLiteral,
	"nullLiteral" to nullLiteral,
	"longLiteral" to longLiteral,
	"unsignedLiteral" to unsignedLiteral
)

class ASTStringLiteral(
	val lineStringLiteral: ASTLineStringLiteral?,
	val multiLineStringLiteral: ASTMultiLineStringLiteral?,
) : ASTNode(
	"stringLiteral",
	"lineStringLiteral" to lineStringLiteral,
	"multiLineStringLiteral" to multiLineStringLiteral
)

class ASTLineStringLiteral(
	val sub: List<Sub>
) : ASTNode(
	"lineStringLiteral",
	"sub" to ASTList(sub)
) {
	class Sub(
		val lineStringContent: ASTLineStringContent?,
		val lineStringExpression: ASTLineStringExpression?
	) : ASTNode(
		"sub",
		"lineStringContent" to lineStringContent,
		"lineStringExpression" to lineStringExpression
	)
}

class ASTMultiLineStringLiteral(
	val sub: List<Sub>
) : ASTNode(
	"multiLineStringLiteral",
	"sub" to ASTList(sub)
) {
	class Sub(
		val multiLineStringContent: ASTMultiLineStringContent?,
		val multiLineStringExpression: ASTMultiLineStringExpression?,
		val multiLineStringQuote: Boolean
	) : ASTNode(
		"sub",
		"multiLineStringContent" to multiLineStringContent,
		"multiLineStringExpression" to multiLineStringExpression,
		"multiLineStringQuote" to ASTBoolean(multiLineStringQuote)
	)
}

class ASTLineStringContent(
	val lineStrText: ASTLineStrText?,
	val lineStrEscapedChar: ASTLineStrEscapedChar?,
	val lineStrRef: ASTLineStrRef?
) : ASTNode(
	"lineStringContent",
	"lineStrText" to lineStrText,
	"lineStrEscapedChar" to lineStrEscapedChar,
	"lineStrRef" to lineStrRef
)

class ASTLineStringExpression(
	val expression: ASTExpression
) : ASTNode(
	"lineStringExpression",
	"expression" to expression
)

class ASTMultiLineStringContent(
	val multiLineStrText: ASTMultiLineStrText?,
	val multiLineStringQuote: ASTMultiLineStringQuote?,
	val multiLineStrRef: ASTMultiLineStrRef?
) : ASTNode(
	"multiLineStringContent",
	"multiLineStrText" to multiLineStrText,
	"multiLineStringQuote" to multiLineStringQuote,
	"multiLineStrRef" to multiLineStrRef
)

class ASTMultiLineStringExpression(
	val expression: ASTExpression
) : ASTNode(
	"multiLineStringExpression",
	"expression" to expression
)

class ASTLambdaLiteral(
	val lambdaParameters: ASTLambdaParameters?,
	val statements: ASTStatements
) : ASTNode(
	"lambdaLiteral",
	"lambdaParameters" to lambdaParameters,
	"statements" to statements
)

class ASTLambdaParameters(
	val lambdaParameter: List<ASTLambdaParameter>
) : ASTNode(
	"lambdaParameters",
	"lambdaParameter" to ASTList(lambdaParameter)
)

class ASTLambdaParameter(
	val variableDeclaration: ASTVariableDeclaration?,
	val multiVariableDeclaration: ASTMultiVariableDeclaration?,
	val type: ASTType?
) : ASTNode(
	"lambdaParameter",
	"variableDeclaration" to variableDeclaration,
	"multiVariableDeclaration" to multiVariableDeclaration,
	"type" to type
)

class ASTAnonymousFunction(
	val suspend: Boolean,
	val type: ASTType?,
	val parametersWithOptionalType: ASTParametersWithOptionalType,
	val typeRight: ASTType?,
	val typeConstraints: ASTTypeConstraints?,
	val functionBody: ASTFunctionBody?
) : ASTNode(
	"anonymousFunction",
	"suspend" to ASTBoolean(suspend),
	"type" to type,
	"parametersWithOptionalType" to parametersWithOptionalType,
	"typeRight" to typeRight,
	"typeConstraints" to typeConstraints,
	"functionBody" to functionBody
)

class ASTFunctionLiteral(
	val lambdaLiteral: ASTLambdaLiteral?,
	val anonymousFunction: ASTAnonymousFunction?
) : ASTNode(
	"functionLiteral",
	"lambdaLiteral" to lambdaLiteral,
	"anonymousFunction" to anonymousFunction
)

class ASTObjectLiteral(
	val data: Boolean,
	val delegationSpecifiers: ASTDelegationSpecifiers?,
	val classBody: ASTClassBody?
) : ASTNode(
	"objectLiteral",
	"delegationSpecifiers" to delegationSpecifiers,
	"classBody" to classBody
)

class ASTThisExpression(
	val at: String?
) : ASTNode(
	"thisExpression",
	"at" to at?.let { ASTString(it) }
)

class ASTSuperExpression(
	val type: ASTType?,
	val simpleIdentifier: ASTSimpleIdentifier?,
	val at: String?
) : ASTNode(
	"superExpression",
	"type" to type,
	"simpleIdentifier" to simpleIdentifier,
	"at" to at?.let { ASTString(it) }
)

class ASTIfExpression(
	val expression: ASTExpression,
	val controlStructureBody: ASTControlStructureBody?,
	val elseControlStructureBody: ASTControlStructureBody?
) : ASTNode(
	"ifExpression",
	"expression" to expression,
	"controlStructureBody" to controlStructureBody,
	"elseControlStructureBody" to elseControlStructureBody
)

class ASTWhenSubject(
	val annotation: List<ASTAnnotation>,
	val variableDeclaration: ASTVariableDeclaration?,
	val expression: ASTExpression
) : ASTNode(
	"whenSubject",
	"annotation" to ASTList(annotation),
	"variableDeclaration" to variableDeclaration,
	"expression" to expression
)

class ASTWhenExpression(
	val whenSubject: ASTWhenSubject?,
	val whenEntry: List<ASTWhenEntry>
) : ASTNode(
	"whenExpression",
	"whenSubject" to whenSubject,
	"whenEntry" to ASTList(whenEntry)
)

class ASTWhenEntry(
	val whenCondition: List<ASTWhenCondition>,
	val `else`: Boolean,
	val controlStructureBody: ASTControlStructureBody
) : ASTNode(
	"whenEntry",
	"whenCondition" to ASTList(whenCondition),
	"else" to ASTBoolean(`else`),
	"controlStructureBody" to controlStructureBody
)

class ASTWhenCondition(
	val expression: ASTExpression?,
	val rangeTest: ASTRangeTest?,
	val typeTest: ASTTypeTest?
) : ASTNode(
	"whenCondition",
	"expression" to expression,
	"rangeTest" to rangeTest,
	"typeTest" to typeTest
)

class ASTRangeTest(
	val inOperator: ASTInOperator,
	val expression: ASTExpression
) : ASTNode(
	"rangeTest",
	"inOperator" to inOperator,
	"expression" to expression
)

class ASTTypeTest(
	val isOperator: ASTIsOperator,
	val type: ASTType
) : ASTNode(
	"rangeTest",
	"isOperator" to isOperator,
	"type" to type
)

class ASTTryExpression(
	val block: ASTBlock,
	val catchBlock: List<ASTCatchBlock>,
	val finallyBlock: ASTFinallyBlock?
) : ASTNode(
	"tryExpression",
	"block" to block,
	"catchBlock" to ASTList(catchBlock),
	"finallyBlock" to finallyBlock
)

class ASTCatchBlock(
	val annotation: List<ASTAnnotation>,
	val simpleIdentifier: ASTSimpleIdentifier,
	val type: ASTType,
	val block: ASTBlock
) : ASTNode(
	"catchBlock",
	"annotation" to ASTList(annotation),
	"simpleIdentifier" to simpleIdentifier,
	"type" to type,
	"block" to block
)

class ASTFinallyBlock(
	val block: ASTBlock
) : ASTNode(
	"finallyBlock",
	"block" to block
)

class ASTJumpExpression(
	val `throw`: Boolean,
	val `return`: Boolean,
	val `continue`: Boolean,
	val `break`: Boolean,
	val expression: ASTExpression?,
	val at: String?
) : ASTNode(
	"jumpExpression",
	"return" to ASTBoolean(`return`),
	"continue" to ASTBoolean(`continue`),
	"break" to ASTBoolean(`break`),
	"expression" to expression,
	"at" to at?.let { ASTString(it) }
)

class ASTCallableReference(
	val receiverType: ASTReceiverType?,
	val simpleIdentifier: ASTSimpleIdentifier?
) : ASTNode(
	"callableReference",
	"receiverType" to receiverType,
	"simpleIdentifier" to simpleIdentifier
)

class ASTAssignmentAndOperator(
	val add: Boolean,
	val sub: Boolean,
	val mul: Boolean,
	val div: Boolean,
	val mod: Boolean
) : ASTNode(
	"assignmentAndOperator",
	"add" to ASTBoolean(add),
	"sub" to ASTBoolean(sub),
	"mul" to ASTBoolean(mul),
	"div" to ASTBoolean(div),
	"mod" to ASTBoolean(mod),
)

class ASTEqualityOperator(
	val hardEq: Boolean,
	val excl: Boolean
) : ASTNode(
	"equalityOperator",
	"hardEq" to ASTBoolean(hardEq),
	"excl" to ASTBoolean(excl)
)

class ASTComparisonOperator(
	val eq: Boolean,
	val greater: Boolean,
) : ASTNode(
	"comparisonOperator",
	"eq" to ASTBoolean(eq),
	"greater" to ASTBoolean(greater)
)

class ASTInOperator(
	val not: Boolean
) : ASTNode(
	"inOperator",
	"not" to ASTBoolean(not)
)

class ASTIsOperator(
	val not: Boolean
) : ASTNode(
	"isOperator",
	"not" to ASTBoolean(not)
)

class ASTAdditiveOperator(
	val add: Boolean
) : ASTNode(
	"additiveOperator",
	"add" to ASTBoolean(add)
)

class ASTMultiplicativeOperator(
	val mul: Boolean,
	val div: Boolean,
	val mod: Boolean
) : ASTNode(
	"multiplicativeOperator",
	"mul" to ASTBoolean(mul),
	"div" to ASTBoolean(div),
	"mod" to ASTBoolean(mod)
)

class ASTAsOperator(
	val safe: Boolean
) : ASTNode(
	"asOperator",
	"safe" to ASTBoolean(safe)
)

class ASTPrefixUnaryOperator(
	val increment: Boolean,
	val decrement: Boolean,
	val sub: Boolean,
	val add: Boolean,
	val excl: Boolean
) : ASTNode(
	"prefixUnaryOperator",
	"increment" to ASTBoolean(increment),
	"decrement" to ASTBoolean(decrement),
	"sub" to ASTBoolean(sub),
	"add" to ASTBoolean(add),
	"excl" to ASTBoolean(excl)
)

class ASTPostfixUnaryOperator(
	val increment: Boolean,
	val decrement: Boolean,
	val excl: Boolean
) : ASTNode(
	"postfixUnaryOperator",
	"increment" to ASTBoolean(increment),
	"decrement" to ASTBoolean(decrement),
	"excl" to ASTBoolean(excl)
)

class ASTMemberAccessOperator(
	val safe: Boolean,
	val reference: Boolean
) : ASTNode(
	"memberAccessOperator",
	"safe" to ASTBoolean(safe),
	"reference" to ASTBoolean(reference)
)