package tree.ast

class ASTAnnotation(
	val singleAnnotation: ASTSingleAnnotation?,
	val multiAnnotation: ASTMultiAnnotation?
) : ASTNode(
	"annotation",
	"singleAnnotation" to singleAnnotation,
	"multiAnnotation" to multiAnnotation
)

class ASTSingleAnnotation(
	val annotationUseSiteTarget: ASTAnnotationUseSiteTarget?,
	val unescapedAnnotation: ASTUnescapedAnnotation
) : ASTNode(
	"singleAnnotation",
	"annotationUseSiteTarget" to annotationUseSiteTarget,
	"unescapedAnnotation" to unescapedAnnotation
)

class ASTMultiAnnotation(
	val annotationUseSiteTarget: ASTAnnotationUseSiteTarget?,
	val unescapedAnnotation: List<ASTUnescapedAnnotation>
) : ASTNode(
	"multiAnnotation",
	"annotationUseSiteTarget" to annotationUseSiteTarget,
	"unescapedAnnotation" to ASTList(unescapedAnnotation)
)

class ASTAnnotationUseSiteTarget(
	val field: Boolean,
	val property: Boolean,
	val get: Boolean,
	val set: Boolean,
	val receiver: Boolean,
	val param: Boolean,
	val setParam: Boolean,
	val delegate: Boolean
) : ASTNode(
	"annotationUseSiteTarget",
	"field" to ASTBoolean(field),
	"property" to ASTBoolean(property),
	"get" to ASTBoolean(get),
	"set" to ASTBoolean(set),
	"receiver" to ASTBoolean(receiver),
	"param" to ASTBoolean(param),
	"setParam" to ASTBoolean(setParam),
	"delegate" to ASTBoolean(delegate)
)

class ASTUnescapedAnnotation(
	val constructorInvocation: ASTConstructorInvocation?,
	val userType: ASTUserType?
) : ASTNode(
	"unescapedAnnotation",
	"constructorInvocation" to constructorInvocation,
	"userType" to userType
)