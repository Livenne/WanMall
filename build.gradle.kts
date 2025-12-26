import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "io.github.livenne"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks {
    withType<ShadowJar> {
        manifest {
            attributes(
                "Main-Class" to "io.github.livenne.Main"
            )
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("io.github.livenne:aero:1.0.3")
    implementation(platform("io.github.livenne:aero-bom:1.0.3"))
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}

tasks.test {
    useJUnitPlatform()
}