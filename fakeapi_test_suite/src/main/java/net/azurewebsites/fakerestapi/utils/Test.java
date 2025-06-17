package net.azurewebsites.fakerestapi.utils;

import net.azurewebsites.fakerestapi.utils.config.EnvDataConfig;
import net.azurewebsites.fakerestapi.utils.config.ResourcesConfig;
import net.azurewebsites.fakerestapi.utils.factories.ContextFactory;
import net.azurewebsites.fakerestapi.utils.factories.WebServiceFactory;

import java.util.Objects;

public class Test {
    EnvDataConfig envDataConfig;
    ResourcesConfig resourceConfig;
    WebServiceFactory api;
    ContextFactory context;

    public Test() {
    }

    public EnvDataConfig envDataConfig() {
        return Objects.requireNonNullElseGet(envDataConfig, () -> envDataConfig = new EnvDataConfig(this));
    }

    public ResourcesConfig resourceConfig() {
        return Objects.requireNonNullElseGet(resourceConfig, () -> resourceConfig = new ResourcesConfig());
    }

    public WebServiceFactory api() {
        return Objects.requireNonNullElseGet(api, () -> api = new WebServiceFactory(this));
    }

    public ContextFactory context() {
        return Objects.requireNonNullElseGet(context, () -> context = new ContextFactory());
    }
}
