package tree.ast

class ASTClassMemberDeclarations(
	val classMemberDeclaration: List<ASTClassMemberDeclaration>
) : ASTNode(
	"classMemberDeclarations",
	"classMemberDeclaration" to ASTList(classMemberDeclaration)
)

class ASTClassMemberDeclaration(
	val declaration: ASTDeclaration?,
	val companionObject: ASTCompanionObject?,
	val anonymousInitializer: ASTAnonymousInitializer?,
	val secondaryConstructor: ASTSecondaryConstructor?
) : ASTNode(
	"classMemberDeclaration",
	"declaration" to declaration,
	"companionObject" to companionObject,
	"anonymousInitializer" to anonymousInitializer,
	"secondaryConstructor" to secondaryConstructor
)

class ASTAnonymousInitializer(
	val block: ASTBlock
) : ASTNode(
	"anonymousInitializer",
	"block" to block
)

class ASTCompanionObject(
	val modifiers: ASTModifiers?,
	val data: Boolean,
	val simpleIdentifier: ASTSimpleIdentifier?,
	val delegationSpecifiers: ASTDelegationSpecifiers?,
	val classBody: ASTClassBody?
) : ASTNode(
	"companionObject",
	"modifiers" to modifiers,
	"data" to ASTBoolean(data),
	"simpleIdentifier" to simpleIdentifier,
	"delegationSpecifiers" to delegationSpecifiers,
	"classBody" to classBody
)

class ASTFunctionValueParameters(
	val functionValueParameter: List<ASTFunctionValueParameter>
) : ASTNode(
	"functionValueParameters",
	"functionValueParameter" to ASTList(functionValueParameter)
)

class ASTFunctionValueParameter(
	val parameterModifiers: ASTParameterModifiers?,
	val parameter: ASTParameter,
	val expression: ASTExpression?
) : ASTNode(
	"functionValueParameter",
	"parameterModifiers" to parameterModifiers,
	"parameter" to parameter,
	"expression" to expression
)

class ASTFunctionDeclaration(
	val modifiers: ASTModifiers?,
	val typeParameters: ASTTypeParameters?,
	val receiverType: ASTReceiverType?,
	val simpleIdentifier: ASTSimpleIdentifier,
	val functionValueParameters: ASTFunctionValueParameters,
	val type: ASTType?,
	val typeConstraints: ASTTypeConstraints?,
	val functionBody: ASTFunctionBody?
) : ASTNode(
	"functionDeclaration",
	"modifiers" to modifiers,
	"typeParameters" to typeParameters,
	"receiverType" to receiverType,
	"simpleIdentifier" to simpleIdentifier,
	"functionValueParameters" to functionValueParameters,
	"type" to type,
	"typeConstraints" to typeConstraints,
	"functionBody" to functionBody
)

class ASTFunctionBody(
	val block: ASTBlock?,
	val expression: ASTExpression?
) : ASTNode(
	"functionBody",
	"block" to block,
	"expression" to expression
)

class ASTVariableDeclaration(
	val annotation: List<ASTAnnotation>,
	val simpleIdentifier: ASTSimpleIdentifier,
	val type: ASTType?
) : ASTNode(
	"variableDeclaration",
	"annotation" to ASTList(annotation),
	"simpleIdentifier" to simpleIdentifier,
	"type" to type
)

class ASTMultiVariableDeclaration(
	val variableDeclaration: List<ASTVariableDeclaration>
) : ASTNode(
	"multiVariableDeclaration",
	"variableDeclaration" to ASTList(variableDeclaration)
)

class ASTPropertyDeclaration(
	val modifiers: ASTModifiers?,
	val mutable: Boolean,
	val typeParameters: ASTTypeParameters?,
	val receiverType: ASTReceiverType?,
	val multiVariableDeclaration: ASTMultiVariableDeclaration?,
	val variableDeclaration: ASTVariableDeclaration?,
	val typeConstraints: ASTTypeConstraints?,
	val expression: ASTExpression?,
	val propertyDelegate: ASTPropertyDelegate?,
	val getter: ASTGetter?,
	val setter: ASTSetter?
) : ASTNode(
	"propertyDeclaration",
	"modifiers" to modifiers,
	"mutable" to ASTBoolean(mutable),
	"typeParameters" to typeParameters,
	"receiverType" to receiverType,
	"multiVariableDeclaration" to multiVariableDeclaration,
	"variableDeclaration" to variableDeclaration,
	"typeConstraints" to typeConstraints,
	"expression" to expression,
	"propertyDelegate" to propertyDelegate,
	"getter" to getter,
	"setter" to setter
)

class ASTPropertyDelegate(
	val expression: ASTExpression
) : ASTNode(
	"propertyDelegate",
	"expression" to expression
)

class ASTGetter(
	val modifiers: ASTModifiers?,
	val type: ASTType?,
	val functionBody: ASTFunctionBody?
) : ASTNode(
	"getter",
	"modifiers" to modifiers,
	"type" to type,
	"functionBody" to functionBody
)

class ASTSetter(
	val modifiers: ASTModifiers?,
	val functionValueParameterWithOptionalType: ASTFunctionValueParameterWithOptionalType?,
	val type: ASTType?,
	val functionBody: ASTFunctionBody?
) : ASTNode(
	"setter",
	"modifiers" to modifiers,
	"functionValueParameterWithOptionalType" to functionValueParameterWithOptionalType,
	"type" to type,
	"functionBody" to functionBody
)

class ASTParametersWithOptionalType(
	val functionValueParameterWithOptionalType: List<ASTFunctionValueParameterWithOptionalType>
) : ASTNode(
	"parametersWithOptionalType",
	"functionValueParameterWithOptionalType" to ASTList(functionValueParameterWithOptionalType)
)

class ASTFunctionValueParameterWithOptionalType(
	val parameterModifiers: ASTParameterModifiers?,
	val parameterWithOptionalType: ASTParameterWithOptionalType,
	val expression: ASTExpression?
) : ASTNode(
	"functionValueParameterWithOptionalType",
	"parameterModifiers" to parameterModifiers,
	"parameterWithOptionalType" to parameterWithOptionalType,
	"expression" to expression
)

class ASTParameterWithOptionalType(
	val simpleIdentifier: ASTSimpleIdentifier,
	val type: ASTType?
) : ASTNode(
	"parameterWithOptionalType",
	"simpleIdentifier" to simpleIdentifier,
	"type" to type
)

class ASTParameter(
	val simpleIdentifier: ASTSimpleIdentifier,
	val type: ASTType
) : ASTNode(
	"parameterWithOptionalType",
	"simpleIdentifier" to simpleIdentifier,
	"type" to type
)

class ASTObjectDeclaration(
	val modifiers: ASTModifiers?,
	val simpleIdentifier: ASTSimpleIdentifier,
	val delegationSpecifiers: ASTDelegationSpecifiers?,
	val classBody: ASTClassBody?
) : ASTNode(
	"objectDeclaration",
	"modifiers" to modifiers,
	"simpleIdentifier" to simpleIdentifier,
	"delegationSpecifiers" to delegationSpecifiers,
	"classBody" to classBody
)

class ASTSecondaryConstructor(
	val modifiers: ASTModifiers?,
	val functionValueParameters: ASTFunctionValueParameters,
	val constructorDelegationCall: ASTConstructorDelegationCall?,
	val block: ASTBlock?
) : ASTNode(
	"secondaryConstructor",
	"modifiers" to modifiers,
	"functionValueParameters" to functionValueParameters,
	"constructorDelegationCall" to constructorDelegationCall,
	"block" to block
)

class ASTConstructorDelegationCall(
	val `super`: Boolean,
	val valueArguments: ASTValueArguments
) : ASTNode(
	"constructorDelegationCall",
	"super" to ASTBoolean(`super`),
	"valueArguments" to valueArguments
)