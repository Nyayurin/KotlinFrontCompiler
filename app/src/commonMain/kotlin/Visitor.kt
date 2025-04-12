import com.strumenta.antlrkotlin.parsers.generated.KotlinLexer
import com.strumenta.antlrkotlin.parsers.generated.KotlinParser
import org.antlr.v4.kotlinruntime.tree.TerminalNode
import tree.ast.*

fun KotlinParser.KotlinFileContext.visit(): ASTKotlinFile {
	return ASTKotlinFile(
		fileAnnotation = fileAnnotation().map { it.visit() },
		packageHeader =packageHeader().visit(),
		importList = importList().visit(),
		topLevelObject = topLevelObject().map { it.visit() }
	)
}

fun KotlinParser.ScriptContext.visit(): ASTScript {
	return ASTScript(
		fileAnnotation = fileAnnotation().map { it.visit() },
		packageHeader =packageHeader().visit(),
		importList = importList().visit(),
		statement = statement().map { it.visit() }
	)
}

fun KotlinParser.FileAnnotationContext.visit(): ASTFileAnnotation {
	return ASTFileAnnotation(
		unescapedAnnotation = unescapedAnnotation().map { it.visit() }
	)
}

fun KotlinParser.PackageHeaderContext.visit(): ASTPackageHeader {
	return ASTPackageHeader(
		identifier = identifier()?.visit()
	)
}

fun KotlinParser.ImportListContext.visit(): ASTImportList {
	return ASTImportList(
		importHeader = importHeader().map { it.visit() }
	)
}

fun KotlinParser.ImportHeaderContext.visit(): ASTImportHeader {
	return ASTImportHeader(
		identifier = identifier().visit(),
		multi = MULT() != null,
		importAlias = importAlias()?.visit()
	)
}

fun KotlinParser.ImportAliasContext.visit(): ASTImportAlias {
	return ASTImportAlias(
		simpleIdentifier = simpleIdentifier().visit()
	)
}

fun KotlinParser.TopLevelObjectContext.visit(): ASTTopLevelObject {
	return ASTTopLevelObject(
		declaration = declaration().visit()
	)
}

fun KotlinParser.TypeAliasContext.visit(): ASTTypeAlias {
	return ASTTypeAlias(
		modifiers = modifiers()?.visit(),
		simpleIdentifier = simpleIdentifier().visit(),
		typeParameters = typeParameters()?.visit(),
		type = type().visit()
	)
}

fun KotlinParser.DeclarationContext.visit(): ASTDeclaration {
	return ASTDeclaration(
		classDeclaration = classDeclaration()?.visit(),
		objectDeclaration = objectDeclaration()?.visit(),
		functionDeclaration = functionDeclaration()?.visit(),
		propertyDeclaration = propertyDeclaration()?.visit(),
		typeAlias = typeAlias()?.visit()
	)
}

fun KotlinParser.ClassDeclarationContext.visit(): ASTClassDeclaration {
	return ASTClassDeclaration(
		modifiers = modifiers()?.visit(),
		`class` = CLASS() != null,
		`fun` = FUN() != null,
		`interface` = INTERFACE() != null,
		simpleIdentifier = simpleIdentifier().visit(),
		typeParameters = typeParameters()?.visit(),
		primaryConstructor = primaryConstructor()?.visit(),
		delegationSpecifiers = delegationSpecifiers()?.visit(),
		typeConstraints = typeConstraints()?.visit(),
		classBody = classBody()?.visit(),
		enumClassBody = enumClassBody()?.visit()
	)
}

fun KotlinParser.PrimaryConstructorContext.visit(): ASTPrimaryConstructor {
	return ASTPrimaryConstructor(
		modifiers = modifiers()?.visit(),
		classParameters = classParameters().visit()
	)
}

fun KotlinParser.ClassBodyContext.visit(): ASTClassBody {
	return ASTClassBody(
		classMemberDeclarations = classMemberDeclarations().visit()
	)
}

fun KotlinParser.ClassParametersContext.visit(): ASTClassParameters {
	return ASTClassParameters(
		classParameter = classParameter().map { it.visit() }
	)
}

fun KotlinParser.ClassParameterContext.visit(): ASTClassParameter {
	return ASTClassParameter(
		modifiers = modifiers()?.visit(),
		mutable = VAR() != null,
		simpleIdentifier = simpleIdentifier().visit(),
		type = type().visit(),
		expression = expression()?.visit()
	)
}

fun KotlinParser.DelegationSpecifiersContext.visit(): ASTDelegationSpecifiers {
	return ASTDelegationSpecifiers(
		annotatedDelegationSpecifier = annotatedDelegationSpecifier().map { it.visit() }
	)
}

fun KotlinParser.DelegationSpecifierContext.visit(): ASTDelegationSpecifier {
	return ASTDelegationSpecifier(
		constructorInvocation = constructorInvocation()?.visit(),
		explicitDelegation = explicitDelegation()?.visit(),
		userType = userType()?.visit(),
		suspend = SUSPEND() != null,
		functionType = functionType()?.visit()
	)
}

fun KotlinParser.ConstructorInvocationContext.visit(): ASTConstructorInvocation {
	return ASTConstructorInvocation(
		userType = userType().visit(),
		valueArguments = valueArguments().visit()
	)
}

fun KotlinParser.AnnotatedDelegationSpecifierContext.visit(): ASTAnnotatedDelegationSpecifier {
	return ASTAnnotatedDelegationSpecifier(
		annotation = annotation().map { it.visit() },
		delegationSpecifier = delegationSpecifier().visit()
	)
}

fun KotlinParser.ExplicitDelegationContext.visit(): ASTExplicitDelegation {
	return ASTExplicitDelegation(
		userType = userType()?.visit(),
		functionType = functionType()?.visit(),
		expression = expression().visit()
	)
}

fun KotlinParser.TypeParametersContext.visit(): ASTTypeParameters {
	return ASTTypeParameters(
		typeParameter = typeParameter().map { it.visit() }
	)
}

fun KotlinParser.TypeParameterContext.visit(): ASTTypeParameter {
	return ASTTypeParameter(
		typeParameterModifiers = typeParameterModifiers()?.visit(),
		simpleIdentifier = simpleIdentifier().visit(),
		type = type()?.visit()
	)
}

fun KotlinParser.TypeConstraintsContext.visit(): ASTTypeConstraints {
	return ASTTypeConstraints(
		typeConstraint = typeConstraint().map { it.visit() }
	)
}

fun KotlinParser.TypeConstraintContext.visit(): ASTTypeConstraint {
	return ASTTypeConstraint(
		annotation = annotation().map { it.visit() },
		simpleIdentifier = simpleIdentifier().visit(),
		type = type().visit()
	)
}

fun KotlinParser.ClassMemberDeclarationsContext.visit(): ASTClassMemberDeclarations {
	return ASTClassMemberDeclarations(
		classMemberDeclaration = classMemberDeclaration().map { it.visit() }
	)
}

fun KotlinParser.ClassMemberDeclarationContext.visit(): ASTClassMemberDeclaration {
	return ASTClassMemberDeclaration(
		declaration = declaration()?.visit(),
		companionObject = companionObject()?.visit(),
		anonymousInitializer = anonymousInitializer()?.visit(),
		secondaryConstructor = secondaryConstructor()?.visit()
	)
}

fun KotlinParser.AnonymousInitializerContext.visit(): ASTAnonymousInitializer {
	return ASTAnonymousInitializer(
		block = block().visit()
	)
}

fun KotlinParser.CompanionObjectContext.visit(): ASTCompanionObject {
	return ASTCompanionObject(
		modifiers = modifiers()?.visit(),
		data = DATA() != null,
		simpleIdentifier = simpleIdentifier()?.visit(),
		delegationSpecifiers = delegationSpecifiers()?.visit(),
		classBody = classBody()?.visit()
	)
}

fun KotlinParser.FunctionValueParametersContext.visit(): ASTFunctionValueParameters {
	return ASTFunctionValueParameters(
		functionValueParameter = functionValueParameter().map { it.visit() }
	)
}

fun KotlinParser.FunctionValueParameterContext.visit(): ASTFunctionValueParameter {
	return ASTFunctionValueParameter(
		parameterModifiers = parameterModifiers()?.visit(),
		parameter = parameter().visit(),
		expression = expression()?.visit()
	)
}

fun KotlinParser.FunctionDeclarationContext.visit(): ASTFunctionDeclaration {
	return ASTFunctionDeclaration(
		modifiers = modifiers()?.visit(),
		typeParameters = typeParameters()?.visit(),
		receiverType = receiverType()?.visit(),
		simpleIdentifier = simpleIdentifier().visit(),
		functionValueParameters = functionValueParameters().visit(),
		type = type()?.visit(),
		typeConstraints = typeConstraints()?.visit(),
		functionBody = functionBody()?.visit()
	)
}

fun KotlinParser.FunctionBodyContext.visit(): ASTFunctionBody {
	return ASTFunctionBody(
		block = block()?.visit(),
		expression = expression()?.visit()
	)
}

fun KotlinParser.VariableDeclarationContext.visit(): ASTVariableDeclaration {
	return ASTVariableDeclaration(
		annotation = annotation().map { it.visit() },
		simpleIdentifier = simpleIdentifier().visit(),
		type = type()?.visit()
	)
}

fun KotlinParser.MultiVariableDeclarationContext.visit(): ASTMultiVariableDeclaration {
	return ASTMultiVariableDeclaration(
		variableDeclaration = variableDeclaration().map { it.visit() }
	)
}

fun KotlinParser.PropertyDeclarationContext.visit(): ASTPropertyDeclaration {
	return ASTPropertyDeclaration(
		modifiers = modifiers()?.visit(),
		mutable = VAR() != null,
		typeParameters = typeParameters()?.visit(),
		receiverType = receiverType()?.visit(),
		multiVariableDeclaration = multiVariableDeclaration()?.visit(),
		variableDeclaration = variableDeclaration()?.visit(),
		typeConstraints = typeConstraints()?.visit(),
		expression = expression()?.visit(),
		propertyDelegate = propertyDelegate()?.visit(),
		getter = getter()?.visit(),
		setter = setter()?.visit()
	)
}

fun KotlinParser.PropertyDelegateContext.visit(): ASTPropertyDelegate {
	return ASTPropertyDelegate(
		expression = expression().visit()
	)
}

fun KotlinParser.GetterContext.visit(): ASTGetter {
	return ASTGetter(
		modifiers = modifiers()?.visit(),
		type = type()?.visit(),
		functionBody = functionBody()?.visit()
	)
}

fun KotlinParser.SetterContext.visit(): ASTSetter {
	return ASTSetter(
		modifiers = modifiers()?.visit(),
		functionValueParameterWithOptionalType = functionValueParameterWithOptionalType()?.visit(),
		type = type()?.visit(),
		functionBody = functionBody()?.visit()
	)
}

fun KotlinParser.ParametersWithOptionalTypeContext.visit(): ASTParametersWithOptionalType {
	return ASTParametersWithOptionalType(
		functionValueParameterWithOptionalType = functionValueParameterWithOptionalType().map { it.visit() }
	)
}

fun KotlinParser.FunctionValueParameterWithOptionalTypeContext.visit(): ASTFunctionValueParameterWithOptionalType {
	return ASTFunctionValueParameterWithOptionalType(
		parameterModifiers = parameterModifiers()?.visit(),
		parameterWithOptionalType = parameterWithOptionalType().visit(),
		expression = expression()?.visit()
	)
}

fun KotlinParser.ParameterWithOptionalTypeContext.visit(): ASTParameterWithOptionalType {
	return ASTParameterWithOptionalType(
		simpleIdentifier = simpleIdentifier().visit(),
		type = type()?.visit()
	)
}

fun KotlinParser.ParameterContext.visit(): ASTParameter {
	return ASTParameter(
		simpleIdentifier = simpleIdentifier().visit(),
		type = type().visit()
	)
}

fun KotlinParser.ObjectDeclarationContext.visit(): ASTObjectDeclaration {
	return ASTObjectDeclaration(
		modifiers = modifiers()?.visit(),
		simpleIdentifier = simpleIdentifier().visit(),
		delegationSpecifiers = delegationSpecifiers()?.visit(),
		classBody = classBody()?.visit()
	)
}

fun KotlinParser.SecondaryConstructorContext.visit(): ASTSecondaryConstructor {
	return ASTSecondaryConstructor(
		modifiers = modifiers()?.visit(),
		functionValueParameters = functionValueParameters().visit(),
		constructorDelegationCall = constructorDelegationCall()?.visit(),
		block = block()?.visit()
	)
}

fun KotlinParser.ConstructorDelegationCallContext.visit(): ASTConstructorDelegationCall {
	return ASTConstructorDelegationCall(
		`super` = SUPER() != null,
		valueArguments = valueArguments().visit()
	)
}

fun KotlinParser.EnumClassBodyContext.visit(): ASTEnumClassBody {
	return ASTEnumClassBody(
		enumEntries = enumEntries()?.visit(),
		classMemberDeclarations = classMemberDeclarations()?.visit()
	)
}

fun KotlinParser.EnumEntriesContext.visit(): ASTEnumEntries {
	return ASTEnumEntries(
		enumEntry = enumEntry().map { it.visit() }
	)
}

fun KotlinParser.EnumEntryContext.visit(): ASTEnumEntry {
	return ASTEnumEntry(
		modifiers = modifiers()?.visit(),
		simpleIdentifier = simpleIdentifier().visit(),
		valueArguments = valueArguments()?.visit(),
		classBody = classBody()?.visit()
	)
}

fun KotlinParser.TypeContext.visit(): ASTType {
	return ASTType(
		typeModifiers = typeModifiers()?.visit(),
		functionType = functionType()?.visit(),
		parenthesizedType = parenthesizedType()?.visit(),
		nullableType = nullableType()?.visit(),
		typeReference = typeReference()?.visit(),
		definitelyNonNullableType = definitelyNonNullableType()?.visit()
	)
}

fun KotlinParser.TypeReferenceContext.visit(): ASTTypeReference {
	return ASTTypeReference(
		userType = userType()?.visit(),
		dynamic = DYNAMIC() != null
	)
}

fun KotlinParser.NullableTypeContext.visit(): ASTNullableType {
	return ASTNullableType(
		typeReference = typeReference()?.visit(),
		parenthesizedType = parenthesizedType()?.visit()
	)
}

fun KotlinParser.UserTypeContext.visit(): ASTUserType {
	return ASTUserType(
		simpleUserType = simpleUserType().map { it.visit() }
	)
}

fun KotlinParser.SimpleUserTypeContext.visit(): ASTSimpleUserType {
	return ASTSimpleUserType(
		simpleIdentifier = simpleIdentifier().visit(),
		typeArguments = typeArguments()?.visit()
	)
}

fun KotlinParser.TypeProjectionContext.visit(): ASTTypeProjection {
	return ASTTypeProjection(
		typeProjectionModifiers = typeProjectionModifiers()?.visit(),
		type = type()?.visit(),
		multi = MULT() != null
	)
}

fun KotlinParser.TypeProjectionModifiersContext.visit(): ASTTypeProjectionModifiers {
	return ASTTypeProjectionModifiers(
		typeProjectionModifier = typeProjectionModifier().map { it.visit() }
	)
}

fun KotlinParser.TypeProjectionModifierContext.visit(): ASTTypeProjectionModifier {
	return ASTTypeProjectionModifier(
		varianceModifier = varianceModifier()?.visit(),
		annotation = annotation()?.visit()
	)
}

fun KotlinParser.FunctionTypeContext.visit(): ASTFunctionType {
	return ASTFunctionType(
		receiverType = receiverType()?.visit(),
		functionTypeParameters = functionTypeParameters().visit(),
		type = type().visit()
	)
}

fun KotlinParser.FunctionTypeParametersContext.visit(): ASTFunctionTypeParameters {
	return ASTFunctionTypeParameters(
		parameter = parameter().map { it.visit() },
		type = type().map { it.visit() }
	)
}

fun KotlinParser.ParenthesizedTypeContext.visit(): ASTParenthesizedType {
	return ASTParenthesizedType(
		type = type().visit()
	)
}

fun KotlinParser.ReceiverTypeContext.visit(): ASTReceiverType {
	return ASTReceiverType(
		typeModifiers = typeModifiers()?.visit(),
		parenthesizedType = parenthesizedType()?.visit(),
		nullableType = nullableType()?.visit(),
		typeReference = typeReference()?.visit()
	)
}

fun KotlinParser.ParenthesizedUserTypeContext.visit(): ASTParenthesizedUserType {
	return ASTParenthesizedUserType(
		userType = userType()?.visit(),
		parenthesizedUserType = parenthesizedUserType()?.visit()
	)
}

fun KotlinParser.DefinitelyNonNullableTypeContext.visit(): ASTDefinitelyNonNullableType {
	val child = children!!.filter { !(it is TerminalNode && it.symbol.type == KotlinLexer.Tokens.NL) }
	val typeModifiersLeft = child[0].let {
		when (it) {
			is KotlinParser.TypeModifiersContext -> it.visit()
			else -> null
		}
	}
	val subLeft = when (typeModifiersLeft) {
		null -> child[0]
		else -> child[1]
	}
	val userTypeLeft = when (subLeft) {
		is KotlinParser.UserTypeContext -> subLeft.visit()
		else -> null
	}
	val parenthesizedUserTypeLeft = when (subLeft) {
		is KotlinParser.ParenthesizedUserTypeContext -> subLeft.visit()
		else -> null
	}

	val childRight = child.drop(
		child.indexOfFirst {
			it is TerminalNode && it.symbol.type == KotlinLexer.Tokens.AMP
		} + 1
	)
	val typeModifiersRight = childRight[0].let {
		when (it) {
			is KotlinParser.TypeModifiersContext -> it.visit()
			else -> null
		}
	}
	val subRight = when (typeModifiersRight) {
		null -> childRight[0]
		else -> childRight[1]
	}
	val userTypeRight = when (subRight) {
		is KotlinParser.UserTypeContext -> subRight.visit()
		else -> null
	}
	val parenthesizedUserTypeRight = when (subRight) {
		is KotlinParser.ParenthesizedUserTypeContext -> subRight.visit()
		else -> null
	}

	return ASTDefinitelyNonNullableType(
		typeModifiersLeft = typeModifiersLeft,
		userTypeLeft = userTypeLeft,
		parenthesizedUserTypeLeft = parenthesizedUserTypeLeft,
		typeModifiersRight = typeModifiersRight,
		userTypeRight = userTypeRight,
		parenthesizedUserTypeRight = parenthesizedUserTypeRight
	)
}

fun KotlinParser.StatementsContext.visit(): ASTStatements {
	return ASTStatements(
		statement = statement().map { it.visit() }
	)
}

fun KotlinParser.StatementContext.visit(): ASTStatement {
	return ASTStatement(
		label = label().map { it.visit() },
		annotation = annotation().map { it.visit() },
		declaration = declaration()?.visit(),
		assignment = assignment()?.visit(),
		loopStatement = loopStatement()?.visit(),
		expression = expression()?.visit()
	)
}

fun KotlinParser.LabelContext.visit(): ASTLabel {
	return ASTLabel(
		simpleIdentifier = simpleIdentifier().visit()
	)
}

fun KotlinParser.ControlStructureBodyContext.visit(): ASTControlStructureBody {
	return ASTControlStructureBody(
		block = block()?.visit(),
		statement = statement()?.visit()
	)
}

fun KotlinParser.BlockContext.visit(): ASTBlock {
	return ASTBlock(
		statements = statements().visit()
	)
}

fun KotlinParser.LoopStatementContext.visit(): ASTLoopStatement {
	return ASTLoopStatement(
		forStatement = forStatement()?.visit(),
		whileStatement = whileStatement()?.visit(),
		doWhileStatement = doWhileStatement()?.visit()
	)
}

fun KotlinParser.ForStatementContext.visit(): ASTForStatement {
	return ASTForStatement(
		annotation = annotation().map { it.visit() },
		variableDeclaration = variableDeclaration()?.visit(),
		multiVariableDeclaration = multiVariableDeclaration()?.visit(),
		expression = expression().visit(),
		controlStructureBody = controlStructureBody()?.visit()
	)
}

fun KotlinParser.WhileStatementContext.visit(): ASTWhileStatement {
	return ASTWhileStatement(
		expression = expression().visit(),
		controlStructureBody = controlStructureBody()?.visit()
	)
}

fun KotlinParser.DoWhileStatementContext.visit(): ASTDoWhileStatement {
	return ASTDoWhileStatement(
		controlStructureBody = controlStructureBody()?.visit(),
		expression = expression().visit()
	)
}

fun KotlinParser.AssignmentContext.visit(): ASTAssignment {
	return ASTAssignment(
		directlyAssignableExpression = directlyAssignableExpression()?.visit(),
		assignableExpression = assignableExpression()?.visit(),
		assignmentAndOperator = assignmentAndOperator()?.visit(),
		expression = expression().visit()
	)
}

fun KotlinParser.ExpressionContext.visit(): ASTExpression {
	return ASTExpression(
		disjunction = disjunction().visit()
	)
}

fun KotlinParser.DisjunctionContext.visit(): ASTDisjunction {
	return ASTDisjunction(
		conjunction = conjunction().map { it.visit() }
	)
}

fun KotlinParser.ConjunctionContext.visit(): ASTConjunction {
	return ASTConjunction(
		equality = equality().map { it.visit() }
	)
}

fun KotlinParser.EqualityContext.visit(): ASTEquality {
	return ASTEquality(
		comparison = comparison().map { it.visit() },
		equalityOperator = equalityOperator().map { it.visit() }
	)
}

fun KotlinParser.ComparisonContext.visit(): ASTComparison {
	return ASTComparison(
		genericCallLikeComparison = genericCallLikeComparison().map { it.visit() },
		comparisonOperator = comparisonOperator().map { it.visit() }
	)
}

fun KotlinParser.GenericCallLikeComparisonContext.visit(): ASTGenericCallLikeComparison {
	return ASTGenericCallLikeComparison(
		infixOperation = infixOperation().visit(),
		callSuffix = callSuffix().map { it.visit() }
	)
}

fun KotlinParser.InfixOperationContext.visit(): ASTInfixOperation {
	return ASTInfixOperation(
		elvisExpression = elvisExpression(0)!!.visit(),
		sub = buildList {
			val list = children!!.drop(1).dropWhile {
				it is TerminalNode && it.symbol.type == KotlinLexer.Tokens.NL
			}
			for (i in 0 until list.size / 2) {
				val operator = list[i * 2]
				val right = list[i * 2 + 1]
				add(
					when {
						operator is KotlinParser.InOperatorContext && right is KotlinParser.ElvisExpressionContext -> {
							ASTInfixOperation.In(
								operator = operator.visit(),
								right = right.visit()
							)
						}

						operator is KotlinParser.IsOperatorContext && right is KotlinParser.TypeContext -> {
							ASTInfixOperation.Is(
								operator = operator.visit(),
								right = right.visit()
							)
						}

						else -> error("operator: $operator, right: $right")
					}
				)
			}
		}
	)
}

fun KotlinParser.ElvisExpressionContext.visit(): ASTElvisExpression {
	return ASTElvisExpression(
		infixFunctionCall = infixFunctionCall().map { it.visit() }
	)
}

fun KotlinParser.InfixFunctionCallContext.visit(): ASTInfixFunctionCall {
	return ASTInfixFunctionCall(
		rangeExpression = rangeExpression().map { it.visit() },
		simpleIdentifier = simpleIdentifier().map { it.visit() }
	)
}

fun KotlinParser.RangeExpressionContext.visit(): ASTRangeExpression {
	return ASTRangeExpression(
		additiveExpression = additiveExpression().map { it.visit() },
		sub = buildList {
			val list = children!!.drop(1).dropWhile {
				it is TerminalNode && it.symbol.type == KotlinLexer.Tokens.NL
			}
			for (i in 0 until list.size / 2) {
				val operator = list[i * 2] as TerminalNode
				add(
					when (operator.symbol.type) {
						KotlinLexer.Tokens.RANGE -> ASTRangeExpression.Range
						KotlinLexer.Tokens.RANGE_UNTIL -> ASTRangeExpression.RangeUntil
						else -> error(operator)
					}
				)
			}
		}
	)
}

fun KotlinParser.AdditiveExpressionContext.visit(): ASTAdditiveExpression {
	return ASTAdditiveExpression(
		multiplicativeExpression = multiplicativeExpression().map { it.visit() },
		additiveOperator = additiveOperator().map { it.visit() }
	)
}

fun KotlinParser.MultiplicativeExpressionContext.visit(): ASTMultiplicativeExpression {
	return ASTMultiplicativeExpression(
		asExpression = asExpression().map { it.visit() },
		multiplicativeOperator = multiplicativeOperator().map { it.visit() }
	)
}

fun KotlinParser.AsExpressionContext.visit(): ASTAsExpression {
	return ASTAsExpression(
		prefixUnaryExpression = prefixUnaryExpression().visit(),
		asOperator = asOperator().map { it.visit() },
		type = type().map { it.visit() }
	)
}

fun KotlinParser.PrefixUnaryExpressionContext.visit(): ASTPrefixUnaryExpression {
	return ASTPrefixUnaryExpression(
		unaryPrefix = unaryPrefix().map { it.visit() },
		postfixUnaryExpression = postfixUnaryExpression().visit()
	)
}

fun KotlinParser.UnaryPrefixContext.visit(): ASTUnaryPrefix {
	return ASTUnaryPrefix(
		annotation = annotation()?.visit(),
		label = label()?.visit(),
		prefixUnaryOperator = prefixUnaryOperator()?.visit()
	)
}

fun KotlinParser.PostfixUnaryExpressionContext.visit(): ASTPostfixUnaryExpression {
	return ASTPostfixUnaryExpression(
		primaryExpression = primaryExpression().visit(),
		postfixUnarySuffix = postfixUnarySuffix().map { it.visit() }
	)
}

fun KotlinParser.PostfixUnarySuffixContext.visit(): ASTPostfixUnarySuffix {
	return ASTPostfixUnarySuffix(
		postfixUnaryOperator = postfixUnaryOperator()?.visit(),
		typeArguments = typeArguments()?.visit(),
		callSuffix = callSuffix()?.visit(),
		indexingSuffix = indexingSuffix()?.visit(),
		navigationSuffix = navigationSuffix()?.visit()
	)
}

fun KotlinParser.DirectlyAssignableExpressionContext.visit(): ASTDirectlyAssignableExpression {
	return ASTDirectlyAssignableExpression(
		postfixUnaryExpression = postfixUnaryExpression()?.visit(),
		assignableSuffix = assignableSuffix()?.visit(),
		simpleIdentifier = simpleIdentifier()?.visit(),
		parenthesizedDirectlyAssignableExpression = parenthesizedDirectlyAssignableExpression()?.visit()
	)
}

fun KotlinParser.ParenthesizedDirectlyAssignableExpressionContext.visit(): ASTParenthesizedDirectlyAssignableExpression {
	return ASTParenthesizedDirectlyAssignableExpression(
		directlyAssignableExpression = directlyAssignableExpression().visit()
	)
}

fun KotlinParser.AssignableExpressionContext.visit(): ASTAssignableExpression {
	return ASTAssignableExpression(
		prefixUnaryExpression = prefixUnaryExpression()?.visit(),
		parenthesizedAssignableExpression = parenthesizedAssignableExpression()?.visit()
	)
}

fun KotlinParser.ParenthesizedAssignableExpressionContext.visit(): ASTParenthesizedAssignableExpression {
	return ASTParenthesizedAssignableExpression(
		assignableExpression = assignableExpression().visit()
	)
}

fun KotlinParser.AssignableSuffixContext.visit(): ASTAssignableSuffix {
	return ASTAssignableSuffix(
		typeArguments = typeArguments()?.visit(),
		indexingSuffix = indexingSuffix()?.visit(),
		navigationSuffix = navigationSuffix()?.visit()
	)
}

fun KotlinParser.IndexingSuffixContext.visit(): ASTIndexingSuffix {
	return ASTIndexingSuffix(
		expression = expression().map { it.visit() }
	)
}

fun KotlinParser.NavigationSuffixContext.visit(): ASTNavigationSuffix {
	return ASTNavigationSuffix(
		memberAccessOperator = memberAccessOperator().visit(),
		simpleIdentifier = simpleIdentifier()?.visit(),
		parenthesizedExpression = parenthesizedExpression()?.visit(),
		`class` = CLASS() != null
	)
}

fun KotlinParser.CallSuffixContext.visit(): ASTCallSuffix {
	return ASTCallSuffix(
		typeArguments = typeArguments()?.visit(),
		valueArguments = valueArguments()?.visit(),
		annotatedLambda = annotatedLambda()?.visit()
	)
}

fun KotlinParser.AnnotatedLambdaContext.visit(): ASTAnnotatedLambda {
	return ASTAnnotatedLambda(
		annotation = annotation().map { it.visit() },
		label = label()?.visit(),
		lambdaLiteral = lambdaLiteral().visit()
	)
}

fun KotlinParser.TypeArgumentsContext.visit(): ASTTypeArguments {
	return ASTTypeArguments(
		typeProjection = typeProjection().map { it.visit() }
	)
}

fun KotlinParser.ValueArgumentsContext.visit(): ASTValueArguments {
	return ASTValueArguments(
		valueArgument = valueArgument().map { it.visit() }
	)
}

fun KotlinParser.ValueArgumentContext.visit(): ASTValueArgument {
	return ASTValueArgument(
		annotation = annotation()?.visit(),
		simpleIdentifier = simpleIdentifier()?.visit(),
		multi = MULT() != null,
		expression = expression().visit()
	)
}

fun KotlinParser.PrimaryExpressionContext.visit(): ASTPrimaryExpression {
	return ASTPrimaryExpression(
		parenthesizedExpression = parenthesizedExpression()?.visit(),
		simpleIdentifier = simpleIdentifier()?.visit(),
		literalConstant = literalConstant()?.visit(),
		stringLiteral = stringLiteral()?.visit(),
		callableReference = callableReference()?.visit(),
		functionLiteral = functionLiteral()?.visit(),
		objectLiteral = objectLiteral()?.visit(),
		collectionLiteral = collectionLiteral()?.visit(),
		thisExpression = thisExpression()?.visit(),
		superExpression = superExpression()?.visit(),
		ifExpression = ifExpression()?.visit(),
		whenExpression = whenExpression()?.visit(),
		tryExpression = tryExpression()?.visit(),
		jumpExpression = jumpExpression()?.visit()
	)
}

fun KotlinParser.ParenthesizedExpressionContext.visit(): ASTParenthesizedExpression {
	return ASTParenthesizedExpression(
		expression = expression().visit()
	)
}

fun KotlinParser.CollectionLiteralContext.visit(): ASTCollectionLiteral {
	return ASTCollectionLiteral(
		expression = expression().map { it.visit() }
	)
}

fun KotlinParser.LiteralConstantContext.visit(): ASTLiteralConstant {
	return ASTLiteralConstant(
		booleanLiteral = BooleanLiteral()?.let { ASTBooleanLiteral(it.text.toBoolean()) },
		integerLiteral = IntegerLiteral()?.let { ASTIntegerLiteral(it.text) },
		hexLiteral = HexLiteral()?.let { ASTHexLiteral(it.text) },
		binLiteral = BinLiteral()?.let { ASTBinLiteral(it.text) },
		characterLiteral = CharacterLiteral()?.let { ASTCharacterLiteral(it.text) },
		realLiteral = RealLiteral()?.let { ASTRealLiteral(it.text) },
		nullLiteral = NullLiteral()?.let { ASTNullLiteral },
		longLiteral = LongLiteral()?.let { ASTLongLiteral(it.text) },
		unsignedLiteral = UnsignedLiteral()?.let { ASTUnsignedLiteral(it.text) }
	)
}

fun KotlinParser.StringLiteralContext.visit(): ASTStringLiteral {
	return ASTStringLiteral(
		lineStringLiteral = lineStringLiteral()?.visit(),
		multiLineStringLiteral = multiLineStringLiteral()?.visit()
	)
}

fun KotlinParser.LineStringLiteralContext.visit(): ASTLineStringLiteral {
	return ASTLineStringLiteral(
		sub = children!!.drop(1).dropLast(1).map {
			when (it) {
				is KotlinParser.LineStringContentContext -> ASTLineStringLiteral.Sub(
					lineStringContent = it.visit(),
					lineStringExpression = null
				)

				is KotlinParser.LineStringExpressionContext -> ASTLineStringLiteral.Sub(
					lineStringContent = null,
					lineStringExpression = it.visit()
				)

				else -> error(it)
			}
		}
	)
}

fun KotlinParser.MultiLineStringLiteralContext.visit(): ASTMultiLineStringLiteral {
	return ASTMultiLineStringLiteral(
		sub = buildList {
			children!!.filter {
				!(it is TerminalNode &&
						(it.symbol.type == KotlinLexer.Tokens.TRIPLE_QUOTE_OPEN ||
								it.symbol.type == KotlinLexer.Tokens.TRIPLE_QUOTE_CLOSE))
			}.forEach {
				add(
					ASTMultiLineStringLiteral.Sub(
						multiLineStringContent = (it as? KotlinParser.MultiLineStringContentContext)?.visit(),
						multiLineStringExpression = (it as? KotlinParser.MultiLineStringExpressionContext)?.visit(),
						multiLineStringQuote = it is TerminalNode
					)
				)
			}
		}
	)
}

fun KotlinParser.LineStringContentContext.visit(): ASTLineStringContent {
	return ASTLineStringContent(
		lineStrText = LineStrText()?.let { ASTLineStrText(it.text) },
		lineStrEscapedChar = LineStrEscapedChar()?.let { ASTLineStrEscapedChar(it.text) },
		lineStrRef = LineStrRef()?.let { ASTLineStrRef(it.text) }
	)
}

fun KotlinParser.LineStringExpressionContext.visit(): ASTLineStringExpression {
	return ASTLineStringExpression(
		expression = expression().visit()
	)
}

fun KotlinParser.MultiLineStringContentContext.visit(): ASTMultiLineStringContent {
	return ASTMultiLineStringContent(
		multiLineStrText = MultiLineStrText()?.let { ASTMultiLineStrText(it.text) },
		multiLineStringQuote = MultiLineStringQuote()?.let { ASTMultiLineStringQuote(it.text.length) },
		multiLineStrRef = MultiLineStrRef()?.let { ASTMultiLineStrRef(it.text) }
	)
}

fun KotlinParser.MultiLineStringExpressionContext.visit(): ASTMultiLineStringExpression {
	return ASTMultiLineStringExpression(
		expression = expression().visit()
	)
}

fun KotlinParser.LambdaLiteralContext.visit(): ASTLambdaLiteral {
	return ASTLambdaLiteral(
		lambdaParameters = lambdaParameters()?.visit(),
		statements = statements().visit()
	)
}

fun KotlinParser.LambdaParametersContext.visit(): ASTLambdaParameters {
	return ASTLambdaParameters(
		lambdaParameter = lambdaParameter().map { it.visit() }
	)
}

fun KotlinParser.LambdaParameterContext.visit(): ASTLambdaParameter {
	return ASTLambdaParameter(
		variableDeclaration = variableDeclaration()?.visit(),
		multiVariableDeclaration = multiVariableDeclaration()?.visit(),
		type = type()?.visit()
	)
}

fun KotlinParser.AnonymousFunctionContext.visit(): ASTAnonymousFunction {
	val list = children!!.filter { it !is TerminalNode }
	val type = list[0].let {
		when (it) {
			is KotlinParser.TypeContext -> it.visit()
			else -> null
		}
	}
	val typeRightIndex = when (type) {
		null -> 1
		else -> 2
	}
	val typeRight = list[typeRightIndex].let {
		when (it) {
			is KotlinParser.TypeContext -> it.visit()
			else -> null
		}
	}
	return ASTAnonymousFunction(
		suspend = SUSPEND() != null,
		type = type,
		parametersWithOptionalType = parametersWithOptionalType().visit(),
		typeRight = typeRight,
		typeConstraints = typeConstraints()?.visit(),
		functionBody = functionBody()?.visit()
	)
}

fun KotlinParser.FunctionLiteralContext.visit(): ASTFunctionLiteral {
	return ASTFunctionLiteral(
		lambdaLiteral = lambdaLiteral()?.visit(),
		anonymousFunction = anonymousFunction()?.visit()
	)
}

fun KotlinParser.ObjectLiteralContext.visit(): ASTObjectLiteral {
	return ASTObjectLiteral(
		data = DATA() != null,
		delegationSpecifiers = delegationSpecifiers()?.visit(),
		classBody = classBody()?.visit()
	)
}

fun KotlinParser.ThisExpressionContext.visit(): ASTThisExpression {
	return ASTThisExpression(
		at = THIS_AT()?.text?.drop("this@".length)
	)
}

fun KotlinParser.SuperExpressionContext.visit(): ASTSuperExpression {
	return ASTSuperExpression(
		type = type()?.visit(),
		simpleIdentifier = simpleIdentifier()?.visit(),
		at = SUPER_AT()?.text?.drop("super@".length)
	)
}

fun KotlinParser.IfExpressionContext.visit(): ASTIfExpression {
	val list = children!!.filter {
		it is KotlinParser.ControlStructureBodyContext ||
				(it is TerminalNode && it.symbol.type == KotlinLexer.Tokens.ELSE)
	}
	val controlStructureBody = list[0].let {
		when (it) {
			is KotlinParser.ControlStructureBodyContext -> it.visit()
			else -> null
		}
	}
	val elseControlStructureBody = when {
		list.any { it is TerminalNode } -> (list.last() as KotlinParser.ControlStructureBodyContext).visit()
		else -> null
	}
	return ASTIfExpression(
		expression = expression().visit(),
		controlStructureBody = controlStructureBody,
		elseControlStructureBody = elseControlStructureBody
	)
}

fun KotlinParser.WhenSubjectContext.visit(): ASTWhenSubject {
	return ASTWhenSubject(
		annotation = annotation().map { it.visit() },
		variableDeclaration = variableDeclaration()?.visit(),
		expression = expression().visit()
	)
}

fun KotlinParser.WhenExpressionContext.visit(): ASTWhenExpression {
	return ASTWhenExpression(
		whenSubject = whenSubject()?.visit(),
		whenEntry = whenEntry().map { it.visit() }
	)
}

fun KotlinParser.WhenEntryContext.visit(): ASTWhenEntry {
	return ASTWhenEntry(
		whenCondition = whenCondition().map { it.visit() },
		`else` = ELSE() != null,
		controlStructureBody = controlStructureBody().visit()
	)
}

fun KotlinParser.WhenConditionContext.visit(): ASTWhenCondition {
	return ASTWhenCondition(
		expression = expression()?.visit(),
		rangeTest = rangeTest()?.visit(),
		typeTest = typeTest()?.visit()
	)
}

fun KotlinParser.RangeTestContext.visit(): ASTRangeTest {
	return ASTRangeTest(
		inOperator = inOperator().visit(),
		expression = expression().visit()
	)
}

fun KotlinParser.TypeTestContext.visit(): ASTTypeTest {
	return ASTTypeTest(
		isOperator = isOperator().visit(),
		type = type().visit()
	)
}

fun KotlinParser.TryExpressionContext.visit(): ASTTryExpression {
	return ASTTryExpression(
		block = block().visit(),
		catchBlock = catchBlock().map { it.visit() },
		finallyBlock = finallyBlock()?.visit()
	)
}

fun KotlinParser.CatchBlockContext.visit(): ASTCatchBlock {
	return ASTCatchBlock(
		annotation = annotation().map { it.visit() },
		simpleIdentifier = simpleIdentifier().visit(),
		type = type().visit(),
		block = block().visit()
	)
}

fun KotlinParser.FinallyBlockContext.visit(): ASTFinallyBlock {
	return ASTFinallyBlock(
		block = block().visit()
	)
}

fun KotlinParser.JumpExpressionContext.visit(): ASTJumpExpression {
	return ASTJumpExpression(
		`throw` = THROW() != null,
		`return` = RETURN() != null || RETURN_AT() != null,
		`continue` = CONTINUE() != null || CONTINUE_AT() != null,
		`break` = BREAK() != null || BREAK_AT() != null,
		expression = expression()?.visit(),
		at = (children!![0] as TerminalNode).let {
			when (it.symbol.type) {
				KotlinLexer.Tokens.RETURN_AT -> it.text.drop("return@".length)
				KotlinLexer.Tokens.CONTINUE_AT -> it.text.drop("continue@".length)
				KotlinLexer.Tokens.BREAK_AT -> it.text.drop("break@".length)
				else -> null
			}
		}
	)
}

fun KotlinParser.CallableReferenceContext.visit(): ASTCallableReference {
	return ASTCallableReference(
		receiverType = receiverType()?.visit(),
		simpleIdentifier = simpleIdentifier()?.visit()
	)
}

fun KotlinParser.AssignmentAndOperatorContext.visit(): ASTAssignmentAndOperator {
	return ASTAssignmentAndOperator(
		add = ADD_ASSIGNMENT() != null,
		sub = SUB_ASSIGNMENT() != null,
		mul = MULT_ASSIGNMENT() != null,
		div = DIV_ASSIGNMENT() != null,
		mod = MOD_ASSIGNMENT() != null
	)
}

fun KotlinParser.EqualityOperatorContext.visit(): ASTEqualityOperator {
	return ASTEqualityOperator(
		hardEq = EXCL_EQEQ() != null || EQEQEQ() != null,
		excl = EXCL_EQ() != null || EXCL_EQEQ() != null
	)
}

fun KotlinParser.ComparisonOperatorContext.visit(): ASTComparisonOperator {
	return ASTComparisonOperator(
		eq = LE() != null || GE() != null,
		greater = RANGLE() != null || GE() != null
	)
}

fun KotlinParser.InOperatorContext.visit(): ASTInOperator {
	return ASTInOperator(
		not = NOT_IN() != null
	)
}

fun KotlinParser.IsOperatorContext.visit(): ASTIsOperator {
	return ASTIsOperator(
		not = NOT_IS() != null
	)
}

fun KotlinParser.AdditiveOperatorContext.visit(): ASTAdditiveOperator {
	return ASTAdditiveOperator(
		add = ADD() != null
	)
}

fun KotlinParser.MultiplicativeOperatorContext.visit(): ASTMultiplicativeOperator {
	return ASTMultiplicativeOperator(
		mul = MULT() != null,
		div = DIV() != null,
		mod = MOD() != null
	)
}

fun KotlinParser.AsOperatorContext.visit(): ASTAsOperator {
	return ASTAsOperator(
		safe = AS_SAFE() != null
	)
}

fun KotlinParser.PrefixUnaryOperatorContext.visit(): ASTPrefixUnaryOperator {
	return ASTPrefixUnaryOperator(
		increment = INCR() != null,
		decrement = DECR() != null,
		sub = SUB() != null,
		add = ADD() != null,
		excl = excl() != null
	)
}

fun KotlinParser.PostfixUnaryOperatorContext.visit(): ASTPostfixUnaryOperator {
	return ASTPostfixUnaryOperator(
		increment = INCR() != null,
		decrement = DECR() != null,
		excl = excl() != null
	)
}

fun KotlinParser.MemberAccessOperatorContext.visit(): ASTMemberAccessOperator {
	return ASTMemberAccessOperator(
		safe = safeNav() != null,
		reference = COLONCOLON() != null
	)
}

fun KotlinParser.ModifiersContext.visit(): ASTModifiers {
	return ASTModifiers(
		sub = children!!.map {
			ASTModifiers.Sub(
				annotation = (it as? KotlinParser.AnnotationContext)?.visit(),
				modifier = (it as? KotlinParser.ModifierContext)?.visit()
			)
		}
	)
}

fun KotlinParser.ParameterModifiersContext.visit(): ASTParameterModifiers {
	return ASTParameterModifiers(
		sub = children!!.map {
			ASTParameterModifiers.Sub(
				annotation = (it as? KotlinParser.AnnotationContext)?.visit(),
				parameterModifier = (it as? KotlinParser.ParameterModifierContext)?.visit()
			)
		}
	)
}

fun KotlinParser.ModifierContext.visit(): ASTModifier {
	return ASTModifier(
		classModifier = classModifier()?.visit(),
		memberModifier = memberModifier()?.visit(),
		visibilityModifier = visibilityModifier()?.visit(),
		functionModifier = functionModifier()?.visit(),
		propertyModifier = propertyModifier()?.visit(),
		inheritanceModifier = inheritanceModifier()?.visit(),
		parameterModifier = parameterModifier()?.visit(),
		platformModifier = platformModifier()?.visit()
	)
}

fun KotlinParser.TypeModifiersContext.visit(): ASTTypeModifiers {
	return ASTTypeModifiers(
		typeModifier = typeModifier().map { it.visit() }
	)
}

fun KotlinParser.TypeModifierContext.visit(): ASTTypeModifier {
	return ASTTypeModifier(
		annotation = annotation()?.visit(),
		suspend = SUSPEND() != null
	)
}

fun KotlinParser.ClassModifierContext.visit(): ASTClassModifier {
	return ASTClassModifier(
		enum = ENUM() != null,
		sealed = SEALED() != null,
		annotation = ANNOTATION() != null,
		data = DATA() != null,
		inner = INNER() != null,
		value = VALUE() != null
	)
}

fun KotlinParser.MemberModifierContext.visit(): ASTMemberModifier {
	return ASTMemberModifier(
		override = OVERRIDE() != null,
		lateInit = LATEINIT() != null
	)
}

fun KotlinParser.VisibilityModifierContext.visit(): ASTVisibilityModifier {
	return ASTVisibilityModifier(
		public = PUBLIC() != null,
		private = PRIVATE() != null,
		internal = INTERNAL() != null,
		protected = PROTECTED() != null
	)
}

fun KotlinParser.VarianceModifierContext.visit(): ASTVarianceModifier {
	return ASTVarianceModifier(
		out = OUT() != null
	)
}

fun KotlinParser.TypeParameterModifiersContext.visit(): ASTTypeParameterModifiers {
	return ASTTypeParameterModifiers(
		typeParameterModifier = typeParameterModifier().map { it.visit() }
	)
}

fun KotlinParser.TypeParameterModifierContext.visit(): ASTTypeParameterModifier {
	return ASTTypeParameterModifier(
		reificationModifier = reificationModifier()?.visit(),
		varianceModifier = varianceModifier()?.visit(),
		annotation = annotation()?.visit()
	)
}

fun KotlinParser.FunctionModifierContext.visit(): ASTFunctionModifier {
	return ASTFunctionModifier(
		tailrec = TAILREC() != null,
		operator = OPERATOR() != null,
		infix = INFIX() != null,
		inline = INLINE() != null,
		external = EXTERNAL() != null,
		suspend = SUSPEND() != null
	)
}

fun KotlinParser.PropertyModifierContext.visit(): ASTPropertyModifier {
	return ASTPropertyModifier
}

fun KotlinParser.InheritanceModifierContext.visit(): ASTInheritanceModifier {
	return ASTInheritanceModifier(
		abstract = ABSTRACT() != null,
		final = FINAL() != null,
		open = OPEN() != null
	)
}

fun KotlinParser.ParameterModifierContext.visit(): ASTParameterModifier {
	return ASTParameterModifier(
		vararg = VARARG() != null,
		noInline = NOINLINE() != null,
		crossInline = CROSSINLINE() != null
	)
}

fun KotlinParser.ReificationModifierContext.visit(): ASTReificationModifier {
	return ASTReificationModifier
}

fun KotlinParser.PlatformModifierContext.visit(): ASTPlatformModifier {
	return ASTPlatformModifier(
		actual = ACTUAL() != null
	)
}

fun KotlinParser.AnnotationContext.visit(): ASTAnnotation {
	return ASTAnnotation(
		singleAnnotation = singleAnnotation()?.visit(),
		multiAnnotation = multiAnnotation()?.visit()
	)
}

fun KotlinParser.SingleAnnotationContext.visit(): ASTSingleAnnotation {
	return ASTSingleAnnotation(
		annotationUseSiteTarget = annotationUseSiteTarget()?.visit(),
		unescapedAnnotation = unescapedAnnotation().visit()
	)
}

fun KotlinParser.MultiAnnotationContext.visit(): ASTMultiAnnotation {
	return ASTMultiAnnotation(
		annotationUseSiteTarget = annotationUseSiteTarget()?.visit(),
		unescapedAnnotation = unescapedAnnotation().map { it.visit() }
	)
}

fun KotlinParser.AnnotationUseSiteTargetContext.visit(): ASTAnnotationUseSiteTarget {
	return ASTAnnotationUseSiteTarget(
		field = FIELD() != null,
		property = PROPERTY() != null,
		get = GET() != null,
		set = SET() != null,
		receiver = RECEIVER() != null,
		param = PARAM() != null,
		setParam = SETPARAM() != null,
		delegate = DELEGATE() != null
	)
}

fun KotlinParser.UnescapedAnnotationContext.visit(): ASTUnescapedAnnotation {
	return ASTUnescapedAnnotation(
		constructorInvocation = constructorInvocation()?.visit(),
		userType = userType()?.visit()
	)
}

fun KotlinParser.SimpleIdentifierContext.visit(): ASTSimpleIdentifier {
	return ASTSimpleIdentifier(
		value = text
	)
}

fun KotlinParser.IdentifierContext.visit(): ASTIdentifier {
	return ASTIdentifier(
		simpleIdentifier = simpleIdentifier().map { it.visit() }
	)
}