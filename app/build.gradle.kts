import com.strumenta.antlrkotlin.gradle.AntlrKotlinTask

plugins {
	kotlin("multiplatform") version "2.1.10"
	id("com.strumenta.antlr-kotlin") version "1.0.2"
}

kotlin {
	jvmToolchain(17)

	jvm()

	sourceSets {
		commonMain {
			dependencies {
				implementation("com.strumenta:antlr-kotlin-runtime:1.0.2")
			}

			kotlin {
				srcDir(layout.buildDirectory.dir("generatedAntlr"))
			}
		}
	}
}

tasks.register<AntlrKotlinTask>("generateKotlinGrammarSource") {
	dependsOn("cleanGenerateKotlinGrammarSource")

	source = fileTree(layout.projectDirectory.dir("antlr")) {
		include("**/*.g4")
	}

	val pkgName = "com.strumenta.antlrkotlin.parsers.generated"
	packageName = pkgName

	arguments = listOf("-visitor")

	val outDir = "generatedAntlr/${pkgName.replace(".", "/")}"
	outputDirectory = layout.buildDirectory.dir(outDir).get().asFile
}