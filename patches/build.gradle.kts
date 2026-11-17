group = "app.liquidmusic"

patches {
    about {
        name = "LiquidMusic Patches"
        description = "Clean, native Liquid Glass patches for Apple Music on Android"
        source = "https://github.com/OWNER/LiquidMusic"
        author = "LiquidMusic"
        contact = ""
        website = ""
        license = "GPLv3"
    }
}

val patchListGeneratorClasspath: Configuration = configurations.create("patchListGeneratorClasspath")

dependencies {
    compileOnly(libs.gson)
    patchListGeneratorClasspath(libs.gson)
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Generate patches-list.json from built .mpp"
        dependsOn(build)
        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("util.PatchListGeneratorKt")
    }
}
