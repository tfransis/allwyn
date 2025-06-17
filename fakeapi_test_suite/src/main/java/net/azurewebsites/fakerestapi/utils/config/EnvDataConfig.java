package net.azurewebsites.fakerestapi.utils.config;

import net.azurewebsites.fakerestapi.utils.Logger;
import net.azurewebsites.fakerestapi.utils.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Properties;

public class EnvDataConfig {
    final Test test;

    public EnvDataConfig(Test test) {
        this.test = test;
    }

    public String getApplicationUrl() {
        return getEnvProperties().getProperty("URL");
    }

    private Properties getEnvProperties() {
        return getProperties(loadProperties(test.resourceConfig().getEnvironmentProperties()));
    }

    private static Properties loadProperties(String testDataFile) {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream(testDataFile)){
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            prop.load(reader);
        } catch (Exception e) {
            new Logger().error(e.getMessage());
        }
        return prop;
    }

    private static Properties getProperties(Properties params) {
        Properties result = new Properties();
        Enumeration<?> names = params.propertyNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            result.put(name, params.get(name));
        }
        return result;
    }
}