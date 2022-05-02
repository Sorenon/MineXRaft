plugins {
    id("fabric-loom") version "0.11-SNAPSHOT"
    id("io.github.juuxel.loom-quiltflower") version "1.7.1"
    id("maven-publish")
    id("org.quiltmc.quilt-mappings-on-loom") version "4.2.0"
    id("org.ajoberstar.grgit") version "4.1.0"
}

base {
    archivesBaseName = "mcxr-play"
}
version = "${properties["play_version"].toString()}+${getVersionMetadata()}"
group = properties["maven_group"].toString()

repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(project(path = ":mcxr-core", configuration = "namedElements"))

    minecraft("com.mojang:minecraft:${properties["minecraft_version"].toString()}")
    mappings(loom.layered {
        this.addLayer(quiltMappings.mappings("org.quiltmc:quilt-mappings:${properties["minecraft_version"].toString()}+build.${properties["quilt_mappings"].toString()}:v2"))
        officialMojangMappings()
    })
    modImplementation("net.fabricmc:fabric-loader:${properties["loader_version"].toString()}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${properties["fabric_version"].toString()}")

    modCompileOnly("com.github.Virtuoel:Pehkui:${properties["pehkui_version"].toString()}") {
        exclude(group = "net.fabricmc.fabric-api")
    }

    implementation("org.joml:joml:${properties["joml_version"].toString()}")
    implementation("com.electronwill.night-config:core:${properties["night_config_version"].toString()}")
    implementation("com.electronwill.night-config:toml:${properties["night_config_version"].toString()}")
    include(modImplementation("com.github.Sorenon:fart:51f6a721e7")!!)
}

sourceSets {
    main {
        resources {
            srcDir("loader")
        }
    }
}

tasks {
    processResources {
        val playVersion = project.properties["play_version"].toString();
        val coreVersion = project.properties["core_version"].toString();
        inputs.property("play_version", playVersion)
        inputs.property("core_version", coreVersion)

        filesMatching("fabric.mod.json") {
            expand("play_version" to playVersion, "core_version" to coreVersion)
        }
    }

    withType<JavaCompile> {
        options.release.set(17)
    }

    jar {
        from("LICENSE") {
            rename { "${it}_${project.properties["archivesBaseName"].toString()}" }
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

// configure the maven publication
publishing {
    publications {
        create<MavenPublication>("mod") {
            from(components["java"])
        }
    }

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    repositories {
        // Add repositories to publish to here.
        // Notice: This block does NOT have the same function as the block in the top level.
        // The repositories here will be used for publishing your artifact, not for
        // retrieving dependencies.
    }
}

loom {
    runs {
        create("playClient") {
            client()
            configName = "MCXR Play Client"
            ideConfigGenerated(true)
        }
    }
}

fun getVersionMetadata(): String {
    val buildId = System.getenv("GITHUB_RUN_NUMBER")

    // CI builds only
    if (buildId != null) {
        return "build.${buildId}"
    }

    val grgit = extensions.getByName("grgit") as org.ajoberstar.grgit.Grgit;
    val head = grgit.head()
    var id = head.abbreviatedId

    // Flag the build if the build tree is not clean
    if (!grgit.status().isClean) {
        id += "-dirty"
    }

    return "rev.${id}"
}