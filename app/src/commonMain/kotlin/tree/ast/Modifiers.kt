package tree.ast

class ASTModifiers(
	val sub: List<Sub>
) : ASTNode(
	"modifiers",
	"sub" to ASTList(sub)
) {
	class Sub(
		val annotation: ASTAnnotation?,
		val modifier: ASTModifier?
	) : ASTNode(
		"sub",
		"annotation" to annotation,
		"modifier" to modifier
	)
}

class ASTParameterModifiers(
	val sub: List<Sub>
) : ASTNode(
	"modifiers",
	"sub" to ASTList(sub)
) {
	class Sub(
		val annotation: ASTAnnotation?,
		val parameterModifier: ASTParameterModifier?
	) : ASTNode(
		"sub",
		"annotation" to annotation,
		"parameterModifier" to parameterModifier
	)
}

class ASTModifier(
	val classModifier: ASTClassModifier?,
	val memberModifier: ASTMemberModifier?,
	val visibilityModifier: ASTVisibilityModifier?,
	val functionModifier: ASTFunctionModifier?,
	val propertyModifier: ASTPropertyModifier?,
	val inheritanceModifier: ASTInheritanceModifier?,
	val parameterModifier: ASTParameterModifier?,
	val platformModifier: ASTPlatformModifier?
) : ASTNode(
	"modifier",
	"classModifier" to classModifier,
	"memberModifier" to memberModifier,
	"visibilityModifier" to visibilityModifier,
	"functionModifier" to functionModifier,
	"propertyModifier" to propertyModifier,
	"inheritanceModifier" to inheritanceModifier,
	"parameterModifier" to parameterModifier,
	"platformModifier" to platformModifier
)

class ASTTypeModifiers(
	val typeModifier: List<ASTTypeModifier>
) : ASTNode(
	"typeModifiers",
	"typeModifiers" to ASTList(typeModifier)
)

class ASTTypeModifier(
	val annotation: ASTAnnotation?,
	val suspend: Boolean
) : ASTNode(
	"typeModifier",
	"annotation" to annotation,
	"suspend" to ASTBoolean(suspend)
)

class ASTClassModifier(
	val enum: Boolean,
	val sealed: Boolean,
	val annotation: Boolean,
	val data: Boolean,
	val inner: Boolean,
	val value: Boolean
) : ASTNode(
	"classModifier",
	"enum" to ASTBoolean(enum),
	"sealed" to ASTBoolean(sealed),
	"annotation" to ASTBoolean(annotation),
	"data" to ASTBoolean(data),
	"inner" to ASTBoolean(inner),
	"value" to ASTBoolean(value)
)

class ASTMemberModifier(
	val override: Boolean,
	val lateInit: Boolean
) : ASTNode(
	"memberModifier",
	"override" to ASTBoolean(override),
	"lateInit" to ASTBoolean(lateInit)
)

class ASTVisibilityModifier(
	val public: Boolean,
	val private: Boolean,
	val internal: Boolean,
	val protected: Boolean
) : ASTNode(
	"visibilityModifier",
	"public" to ASTBoolean(public),
	"private" to ASTBoolean(private),
	"internal" to ASTBoolean(internal),
	"protected" to ASTBoolean(protected)
)

class ASTVarianceModifier(
	val out: Boolean
) : ASTNode(
	"varianceModifier",
	"out" to ASTBoolean(out)
)

class ASTTypeParameterModifiers(
	val typeParameterModifier: List<ASTTypeParameterModifier>
) : ASTNode(
	"typeParameterModifiers",
	"typeParameterModifier" to ASTList(typeParameterModifier)
)

class ASTTypeParameterModifier(
	val reificationModifier: ASTReificationModifier?,
	val varianceModifier: ASTVarianceModifier?,
	val annotation: ASTAnnotation?
) : ASTNode(
	"typeParameterModifier",
	"reificationModifier" to reificationModifier,
	"varianceModifier" to varianceModifier,
	"annotation" to annotation
)

class ASTFunctionModifier(
	val tailrec: Boolean,
	val operator: Boolean,
	val infix: Boolean,
	val inline: Boolean,
	val external: Boolean,
	val suspend: Boolean
) : ASTNode(
	"functionModifier",
	"tailrec" to ASTBoolean(tailrec),
	"operator" to ASTBoolean(operator),
	"infix" to ASTBoolean(infix),
	"inline" to ASTBoolean(inline),
	"external" to ASTBoolean(external),
	"suspend" to ASTBoolean(suspend)
)

object ASTPropertyModifier : ASTNode("propertyModifier")

class ASTInheritanceModifier(
	val abstract: Boolean,
	val final: Boolean,
	val open: Boolean
) : ASTNode(
	"inheritanceModifier",
	"abstract" to ASTBoolean(abstract),
	"final" to ASTBoolean(final),
	"open" to ASTBoolean(open)
)

class ASTParameterModifier(
	val vararg: Boolean,
	val noInline: Boolean,
	val crossInline: Boolean
) : ASTNode(
	"parameterModifier",
	"vararg" to ASTBoolean(vararg),
	"noInline" to ASTBoolean(noInline),
	"crossInline" to ASTBoolean(crossInline)
)

object ASTReificationModifier : ASTNode("reificationModifier")

class ASTPlatformModifier(
	val actual: Boolean
) : ASTNode(
	"platformModifier",
	"actual" to ASTBoolean(actual)
)