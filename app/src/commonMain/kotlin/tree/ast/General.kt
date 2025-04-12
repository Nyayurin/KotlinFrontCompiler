package tree.ast

class ASTKotlinFile(
	val fileAnnotation: List<ASTFileAnnotation>,
	val packageHeader: ASTPackageHeader,
	val importList: ASTImportList,
	val topLevelObject: List<ASTTopLevelObject>
) : ASTNode(
	"kotlinFile",
	"fileAnnotation" to ASTList(fileAnnotation),
	"packageHeader" to packageHeader,
	"importList" to importList,
	"topLevelObject" to ASTList(topLevelObject)
)

class ASTScript(
	val fileAnnotation: List<ASTFileAnnotation>,
	val packageHeader: ASTPackageHeader,
	val importList: ASTImportList,
	val statement: List<ASTStatement>
) : ASTNode(
	"script",
	"fileAnnotation" to ASTList(fileAnnotation),
	"packageHeader" to packageHeader,
	"importList" to importList,
	"statement" to ASTList(statement)
)

class ASTFileAnnotation(
	val unescapedAnnotation: List<ASTUnescapedAnnotation>
) : ASTNode(
	"fileAnnotation",
	"unescapedAnnotation" to ASTList(unescapedAnnotation)
)

class ASTPackageHeader(
	val identifier: ASTIdentifier?
) : ASTNode(
	"packageHeader",
	"identifier" to identifier
)

class ASTImportList(
	val importHeader: List<ASTImportHeader>
) : ASTNode(
	"importList",
	"importHeader" to ASTList(importHeader)
)

class ASTImportHeader(
	val identifier: ASTIdentifier,
	val multi: Boolean,
	val importAlias: ASTImportAlias?
) : ASTNode(
	"importHeader",
	"identifier" to identifier,
	"multi" to ASTBoolean(multi),
	"importAlias" to importAlias
)

class ASTImportAlias(
	val simpleIdentifier: ASTSimpleIdentifier
) : ASTNode(
	"importAlias",
	"simpleIdentifier" to simpleIdentifier
)

class ASTTopLevelObject(
	val declaration: ASTDeclaration
) : ASTNode(
	"topLevelObject",
	"declaration" to declaration
)

class ASTTypeAlias(
	val modifiers: ASTModifiers?,
	val simpleIdentifier: ASTSimpleIdentifier,
	val typeParameters: ASTTypeParameters?,
	val type: ASTType
) : ASTNode(
	"typeAlias",
	"modifiers" to modifiers,
	"simpleIdentifier" to simpleIdentifier,
	"typeParameters" to typeParameters,
	"type" to type
)

class ASTDeclaration(
	val classDeclaration: ASTClassDeclaration?,
	val objectDeclaration: ASTObjectDeclaration?,
	val functionDeclaration: ASTFunctionDeclaration?,
	val propertyDeclaration: ASTPropertyDeclaration?,
	val typeAlias: ASTTypeAlias?
) : ASTNode(
	"declaration",
	"classDeclaration" to classDeclaration,
	"objectDeclaration" to objectDeclaration,
	"functionDeclaration" to functionDeclaration,
	"propertyDeclaration" to propertyDeclaration,
	"typeAlias" to typeAlias
)