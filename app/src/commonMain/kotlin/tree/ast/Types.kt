package tree.ast

class ASTType(
	val typeModifiers: ASTTypeModifiers?,
	val functionType: ASTFunctionType?,
	val parenthesizedType: ASTParenthesizedType?,
	val nullableType: ASTNullableType?,
	val typeReference: ASTTypeReference?,
	val definitelyNonNullableType: ASTDefinitelyNonNullableType?
) : ASTNode(
	"type",
	"typeModifiers" to typeModifiers,
	"functionType" to functionType,
	"parenthesizedType" to parenthesizedType,
	"nullableType" to nullableType,
	"typeReference" to typeReference,
	"definitelyNonNullableType" to definitelyNonNullableType
)

class ASTTypeReference(
	val userType: ASTUserType?,
	val dynamic: Boolean
) : ASTNode(
	"typeReference",
	"userType" to userType,
	"dynamic" to ASTBoolean(dynamic)
)

class ASTNullableType(
	val typeReference: ASTTypeReference?,
	val parenthesizedType: ASTParenthesizedType?
) : ASTNode(
	"nullableType",
	"typeReference" to typeReference,
	"parenthesizedType" to parenthesizedType
)

class ASTUserType(
	val simpleUserType: List<ASTSimpleUserType>
) : ASTNode(
	"userType",
	"simpleUserType" to ASTList(simpleUserType)
)

class ASTSimpleUserType(
	val simpleIdentifier: ASTSimpleIdentifier,
	val typeArguments: ASTTypeArguments?
) : ASTNode(
	"simpleUserType",
	"simpleIdentifier" to simpleIdentifier,
	"typeArguments" to typeArguments
)

class ASTTypeProjection(
	val typeProjectionModifiers: ASTTypeProjectionModifiers?,
	val type: ASTType?,
	val multi: Boolean
) : ASTNode(
	"typeProjection",
	"typeProjectionModifiers" to typeProjectionModifiers,
	"type" to type,
	"multi" to ASTBoolean(multi)
)

class ASTTypeProjectionModifiers(
	val typeProjectionModifier: List<ASTTypeProjectionModifier>
) : ASTNode(
	"typeProjectionModifiers",
	"typeProjectionModifier" to ASTList(typeProjectionModifier)
)

class ASTTypeProjectionModifier(
	val varianceModifier: ASTVarianceModifier?,
	val annotation: ASTAnnotation?
) : ASTNode(
	"typeProjectionModifier",
	"varianceModifier" to varianceModifier,
	"annotation" to annotation
)

class ASTFunctionType(
	val receiverType: ASTReceiverType?,
	val functionTypeParameters: ASTFunctionTypeParameters,
	val type: ASTType
) : ASTNode(
	"functionType",
	"receiverType" to receiverType,
	"functionTypeParameters" to functionTypeParameters,
	"type" to type
)

class ASTFunctionTypeParameters(
	val parameter: List<ASTParameter>,
	val type: List<ASTType>
) : ASTNode(
	"functionTypeParameters",
	"parameter" to ASTList(parameter),
	"type" to ASTList(type)
)

class ASTParenthesizedType(
	val type: ASTType
) : ASTNode(
	"parenthesizedType",
	"type" to type
)

class ASTReceiverType(
	val typeModifiers: ASTTypeModifiers?,
	val parenthesizedType: ASTParenthesizedType?,
	val nullableType: ASTNullableType?,
	val typeReference: ASTTypeReference?
) : ASTNode(
	"receiverType",
	"typeModifiers" to typeModifiers,
	"parenthesizedType" to parenthesizedType,
	"nullableType" to nullableType,
	"typeReference" to typeReference
)

class ASTParenthesizedUserType(
	val userType: ASTUserType?,
	val parenthesizedUserType: ASTParenthesizedUserType?
) : ASTNode(
	"parenthesizedUserType",
	"userType" to userType,
	"parenthesizedUserType" to parenthesizedUserType
)

class ASTDefinitelyNonNullableType(
	val typeModifiersLeft: ASTTypeModifiers?,
	val userTypeLeft: ASTUserType?,
	val parenthesizedUserTypeLeft: ASTParenthesizedUserType?,
	val typeModifiersRight: ASTTypeModifiers?,
	val userTypeRight: ASTUserType?,
	val parenthesizedUserTypeRight: ASTParenthesizedUserType?
) : ASTNode(
	"definitelyNonNullableType",
	"typeModifiersLeft" to typeModifiersLeft,
	"userTypeLeft" to userTypeLeft,
	"parenthesizedUserTypeLeft" to parenthesizedUserTypeLeft,
	"typeModifiersRight" to typeModifiersLeft,
	"userTypeRight" to userTypeLeft,
	"parenthesizedUserTypeRight" to parenthesizedUserTypeLeft
)