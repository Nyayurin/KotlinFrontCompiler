package tree.ast

class ASTClassDeclaration(
	val modifiers: ASTModifiers?,
	val `class`: Boolean,
	val `fun`: Boolean,
	val `interface`: Boolean,
	val simpleIdentifier: ASTSimpleIdentifier,
	val typeParameters: ASTTypeParameters?,
	val primaryConstructor: ASTPrimaryConstructor?,
	val delegationSpecifiers: ASTDelegationSpecifiers?,
	val typeConstraints: ASTTypeConstraints?,
	val classBody: ASTClassBody?,
	val enumClassBody: ASTEnumClassBody?
) : ASTNode(
	"classDeclaration",
	"modifiers" to modifiers,
	"class" to ASTBoolean(`class`),
	"fun" to ASTBoolean(`fun`),
	"interface" to ASTBoolean(`interface`),
	"simpleIdentifier" to simpleIdentifier,
	"typeParameters" to typeParameters,
	"primaryConstructor" to primaryConstructor,
	"delegationSpecifiers" to delegationSpecifiers,
	"typeConstraints" to typeConstraints,
	"classBody" to classBody,
	"enumClassBody" to enumClassBody
)

class ASTPrimaryConstructor(
	val modifiers: ASTModifiers?,
	val classParameters: ASTClassParameters
) : ASTNode(
	"primaryConstructor",
	"modifiers" to modifiers,
	"classParameters" to classParameters
)

class ASTClassBody(
	val classMemberDeclarations: ASTClassMemberDeclarations
) : ASTNode(
	"classBody",
	"classMemberDeclarations" to classMemberDeclarations
)

class ASTClassParameters(
	val classParameter: List<ASTClassParameter>
) : ASTNode(
	"classParameters",
	"classParameter" to ASTList(classParameter)
)

class ASTClassParameter(
	val modifiers: ASTModifiers?,
	val mutable: Boolean,
	val simpleIdentifier: ASTSimpleIdentifier,
	val type: ASTType,
	val expression: ASTExpression?
) : ASTNode(
	"classParameter",
	"modifiers" to modifiers,
	"mutable" to ASTBoolean(mutable),
	"simpleIdentifier" to simpleIdentifier,
	"type" to type,
	"expression" to expression
)

class ASTDelegationSpecifiers(
	val annotatedDelegationSpecifier: List<ASTAnnotatedDelegationSpecifier>
) : ASTNode(
	"delegationSpecifiers",
	"annotatedDelegationSpecifier" to ASTList(annotatedDelegationSpecifier)
)

class ASTDelegationSpecifier(
	val constructorInvocation: ASTConstructorInvocation?,
	val explicitDelegation: ASTExplicitDelegation?,
	val userType: ASTUserType?,
	val suspend: Boolean?,
	val functionType: ASTFunctionType?,
) : ASTNode(
	"delegationSpecifier",
	"constructorInvocation" to constructorInvocation,
	"explicitDelegation" to explicitDelegation,
	"userType" to userType,
	"suspend" to suspend?.let { ASTBoolean(it) },
	"functionType" to functionType
)

class ASTConstructorInvocation(
	val userType: ASTUserType,
	val valueArguments: ASTValueArguments
) : ASTNode(
	"constructorInvocation",
	"userType" to userType,
	"valueArguments" to valueArguments
)

class ASTAnnotatedDelegationSpecifier(
	val annotation: List<ASTAnnotation>,
	val delegationSpecifier: ASTDelegationSpecifier
) : ASTNode(
	"annotatedDelegationSpecifier",
	"annotation" to ASTList(annotation),
	"delegationSpecifier" to delegationSpecifier
)

class ASTExplicitDelegation(
	val userType: ASTUserType?,
	val functionType: ASTFunctionType?,
	val expression: ASTExpression
) : ASTNode(
	"explicitDelegation",
	"userType" to userType,
	"functionType" to functionType,
	"expression" to expression
)

class ASTTypeParameters(
	val typeParameter: List<ASTTypeParameter>
) : ASTNode(
	"typeParameters",
	"typeParameter" to ASTList(typeParameter)
)

class ASTTypeParameter(
	val typeParameterModifiers: ASTTypeParameterModifiers?,
	val simpleIdentifier: ASTSimpleIdentifier,
	val type: ASTType?
) : ASTNode(
	"typeParameter",
	"typeParameterModifiers" to typeParameterModifiers,
	"simpleIdentifier" to simpleIdentifier,
	"type" to type
)

class ASTTypeConstraints(
	val typeConstraint: List<ASTTypeConstraint>
) : ASTNode(
	"typeConstraints",
	"typeConstraint" to ASTList(typeConstraint)
)

class ASTTypeConstraint(
	val annotation: List<ASTAnnotation>,
	val simpleIdentifier: ASTSimpleIdentifier,
	val type: ASTType
) : ASTNode(
	"typeConstraint",
	"annotation" to ASTList(annotation),
	"simpleIdentifier" to simpleIdentifier,
	"type" to type
)