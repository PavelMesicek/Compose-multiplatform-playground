pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "composeplayground"

// https://docs.gradle.org/8.1.1/userguide/declaring_dependencies.html#sec:type-safe-project-accessors
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":androidApp")
include(":shared:app")
include(":shared:network:graphql")
include(":shared:network:rest")
include(":shared:feature")
include(":shared:persistence")
include(":shared:platform")
include(":shared:util")
include(":shared:resources")

includeBuild("convention-plugins")
