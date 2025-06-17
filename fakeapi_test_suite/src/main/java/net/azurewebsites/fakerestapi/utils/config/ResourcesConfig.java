package net.azurewebsites.fakerestapi.utils.config;

import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

public class ResourcesConfig {
    public String getEnvironmentProperties() {
        final String envProperties = "env.properties";
        return System.getProperty(envProperties) == null ? getResourcesPath() + "/" + envProperties : getAbsolutePath() + System.getProperty(envProperties);
    }


    public String getAbsolutePath() {
        String absPath = Paths.get(".")
                .toAbsolutePath().normalize().toString().replace("\\", "/");

        String modulePath = Objects.requireNonNull(this.getClass().getClassLoader().getResource(".")).getPath();
        modulePath = modulePath.replace("\\", "/");
        modulePath = modulePath.replace("/target/test-classes", "");
        modulePath = modulePath.replace(absPath, "");
        modulePath = modulePath.replace("//", "/");

        return absPath + modulePath;
    }

    private String getResourcesPath() {
        return getResourcesPath("main");
    }

    private String getResourcesPath(String packageName) {
        String filePathString = getAbsolutePath() + "src/" + packageName + "/resources";
        File f = new File(filePathString);
        if (!f.exists())
            filePathString = getAbsolutePath();
        return filePathString;
    }
}
