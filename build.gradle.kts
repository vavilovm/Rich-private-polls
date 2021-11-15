plugins {
    kotlin("jvm") version "1.5.10"
    jacoco
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

jacoco {
    toolVersion = "0.8.7"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(platform("org.junit:junit-bom:5.8.1"))
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("junit:junit:4.12")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
    finalizedBy(project.tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.required.set(true)
    }
}

application {
    mainClass.set("com.hse.MainKt")
}