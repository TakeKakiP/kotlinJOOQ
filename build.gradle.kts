import org.jetbrains.kotlin.ir.backend.js.compile
import org.jooq.meta.jaxb.*


plugins {
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
	id("org.jooq.jooq-codegen-gradle") version "3.19.10"


	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
}

group = "com.book_manage"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenLocal()
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	jooqCodegen("com.mysql:mysql-connector-j")

}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jooq{
	configuration{
		jdbc {
			driver = "com.mysql.cj.jdbc.Driver"
			url = "jdbc:mysql://localhost:3306/book_db"

			// "username" is a valid synonym for "user"
			user = "root"
			password = "root"
		}

		generator{

			name = "org.jooq.codegen.KotlinGenerator"

			database {
				inputSchema = "book_db"
			}

			generate{}

			target{
				packageName="jooq"
				directory = "/src/main/kotlin/com/book_manage"
			}
		}
	}
}
