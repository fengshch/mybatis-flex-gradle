package com.github.fengshch.mybatis.config;

import groovy.lang.Closure;
import lombok.Getter;
import lombok.Setter;
import org.flywaydb.gradle.FlywayExtension;

import javax.inject.Inject;

@Getter
@Setter
public class GlobalConfigBuilder {

    private final String name;
    private boolean entityGenerateEnable = true;
    private boolean mapperGenerateEnable = true;
    private boolean serviceGenerateEnable = true;
    private boolean serviceImplGenerateEnable = true;
    private boolean controllerGenerateEnable = true;
    private boolean tableDefGenerateEnable = true;
    private boolean mapperXmlGenerateEnable = true;
    private boolean packageInfoGenerateEnable = true;

    private final DataSourceConfigBuilder dataSourceConfigBuilder;

    private final JavadocConfigBuilder javadocConfigBuilder;
    private final PackageConfigBuilder packageConfigBuilder;
    private final StrategyConfigBuilder strategyConfigBuilder;
    private final FlywayExtension flywayExtension;
    private final TemplateConfigBuilder templateConfigBuilder;

    private final EntityConfigBuilder entityConfigBuilder;
    private final MapperConfigBuilder mapperConfigBuilder;
    private final ServiceConfigBuilder serviceConfigBuilder;
    private final ServiceImplConfigBuilder serviceImplConfigBuilder;
    private final ControllerConfigBuilder controllerConfigBuilder;
    private final TableConfigBuilder tableConfigBuilder;
    private final TableDefConfigBuilder tableDefConfigBuilder;
    private final MapperXmlConfigBuilder mapperXmlConfigBuilder;

    @Inject
    public GlobalConfigBuilder(String name) {
        this.name = name;
        javadocConfigBuilder = new JavadocConfigBuilder();
        packageConfigBuilder = new PackageConfigBuilder();
        strategyConfigBuilder = new StrategyConfigBuilder();
        templateConfigBuilder = new TemplateConfigBuilder();
        entityConfigBuilder = new EntityConfigBuilder();
        mapperConfigBuilder = new MapperConfigBuilder();
        serviceConfigBuilder = new ServiceConfigBuilder();
        serviceImplConfigBuilder = new ServiceImplConfigBuilder();
        controllerConfigBuilder = new ControllerConfigBuilder();
        tableConfigBuilder = new TableConfigBuilder();
        tableDefConfigBuilder = new TableDefConfigBuilder();
        mapperXmlConfigBuilder = new MapperXmlConfigBuilder();
        dataSourceConfigBuilder = new DataSourceConfigBuilder();
        flywayExtension = new FlywayExtension();
    }

    @SuppressWarnings("unused")
    public void flyway(Closure<?> closure) {
        closure.setDelegate(flywayExtension);
        closure.call();
    }

    public FlywayExtension getFlywayExtension() {
        if (flywayExtension.driver == null) {
            flywayExtension.driver = dataSourceConfigBuilder.getDriverClassName();
        }
        if (flywayExtension.url == null) {
            flywayExtension.url = dataSourceConfigBuilder.getUrl();
        }
        if (flywayExtension.user == null) {
            flywayExtension.user = dataSourceConfigBuilder.getUsername();
        }
        if (flywayExtension.password == null) {
            flywayExtension.password = dataSourceConfigBuilder.getPassword();
        }
        return flywayExtension;
    }

    @SuppressWarnings("unused")
    public void dataSourceConfig(Closure<?> closure) {
        closure.setDelegate(dataSourceConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void javadocConfig(Closure<?> closure) {
        closure.setDelegate(javadocConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void packageConfig(Closure<?> closure) {
        closure.setDelegate(packageConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void strategyConfig(Closure<?> closure) {
        closure.setDelegate(strategyConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void templateConfig(Closure<?> closure) {
        closure.setDelegate(templateConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void entityConfig(Closure<?> closure) {
        closure.setDelegate(entityConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void mapperConfig(Closure<?> closure) {
        closure.setDelegate(mapperConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void serviceConfig(Closure<?> closure) {
        closure.setDelegate(serviceConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void serviceImplConfig(Closure<?> closure) {
        closure.setDelegate(serviceImplConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void controllerConfig(Closure<?> closure) {
        closure.setDelegate(controllerConfigBuilder);
        closure.call();
    }

    public void tableConfig(Closure<?> closure) {
        closure.setDelegate(tableConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void tableDefConfig(Closure<?> closure) {
        closure.setDelegate(tableDefConfigBuilder);
        closure.call();
    }

    @SuppressWarnings("unused")
    public void mapperXmlConfig(Closure<?> closure) {
        closure.setDelegate(mapperXmlConfigBuilder);
        closure.call();
    }
}
