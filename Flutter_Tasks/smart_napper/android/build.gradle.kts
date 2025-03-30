allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// Define a new build directory for all subprojects
val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.set(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.set(newSubprojectBuildDir)

    // Ensure the app module is evaluated first
    if (project.name != "app") {
        project.evaluationDependsOn(":app")
    }
}

// Register a clean task
tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
