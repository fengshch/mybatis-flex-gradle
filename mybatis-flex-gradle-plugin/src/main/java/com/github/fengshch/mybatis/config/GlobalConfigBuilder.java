package com.github.fengshch.mybatis.config;

import groovy.lang.Closure;
import org.flywaydb.gradle.FlywayExtension;

import javax.inject.Inject;

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
        tableDefConfigBuilder = new TableDefConfigBuilder();
        mapperXmlConfigBuilder = new MapperXmlConfigBuilder();
        flywayConfigBuilder = new FlywayConfigBuilder(name);
    }

    public String getName() {
        return name;
    }

    private final FlywayConfigBuilder flywayConfigBuilder;

    public void flyway(Closure<?> closure) {
        closure.setDelegate(flywayConfigBuilder);
        closure.call();
    }

    public FlywayConfigBuilder getFlywayConfigBuilder() {
        flywayConfigBuilder.setDriver(dataSourceConfigBuilder.getDriverClassName());
        flywayConfigBuilder.setUrl(dataSourceConfigBuilder.getUrl());
        flywayConfigBuilder.setUser(dataSourceConfigBuilder.getUsername());
        flywayConfigBuilder.setPassword(dataSourceConfigBuilder.getPassword());
        return flywayConfigBuilder;
    }

    private DataSourceConfigBuilder dataSourceConfigBuilder;

    @SuppressWarnings("unused")
    public void dataSourceConfig(Closure<?> closure) {
        dataSourceConfigBuilder = new DataSourceConfigBuilder();
        closure.setDelegate(dataSourceConfigBuilder);
        closure.call();
    }

    public DataSourceConfigBuilder getDataSourceConfig() {
        return dataSourceConfigBuilder;
    }

    public void setDataSourceConfig(DataSourceConfigBuilder dataSourceConfigBuilder) {
        this.dataSourceConfigBuilder = dataSourceConfigBuilder;
    }

    private final JavadocConfigBuilder javadocConfigBuilder;

    @SuppressWarnings("unused")
    public void javadocConfig(Closure<?> closure) {
        closure.setDelegate(javadocConfigBuilder);
        closure.call();
    }

    public JavadocConfigBuilder getJavadocConfig() {
        return javadocConfigBuilder;
    }

    private final PackageConfigBuilder packageConfigBuilder;

    @SuppressWarnings("unused")
    public void packageConfig(Closure<?> closure) {
        closure.setDelegate(packageConfigBuilder);
        closure.call();
    }

    public PackageConfigBuilder getPackageConfig() {
        return packageConfigBuilder;
    }

    private final StrategyConfigBuilder strategyConfigBuilder;

    @SuppressWarnings("unused")
    public void strategyConfig(Closure<?> closure) {
        closure.setDelegate(strategyConfigBuilder);
        closure.call();
    }

    public StrategyConfigBuilder getStrategyConfig() {
        return strategyConfigBuilder;
    }

    private final TemplateConfigBuilder templateConfigBuilder;

    @SuppressWarnings("unused")
    public void templateConfig(Closure<?> closure) {
        closure.setDelegate(templateConfigBuilder);
        closure.call();
    }

    public TemplateConfigBuilder getTemplateConfig() {
        return templateConfigBuilder;
    }

    private final EntityConfigBuilder entityConfigBuilder;

    @SuppressWarnings("unused")
    public void entityConfig(Closure<?> closure) {
        closure.setDelegate(entityConfigBuilder);
        closure.call();
    }

    public EntityConfigBuilder getEntityConfig() {
        return entityConfigBuilder;
    }

    private final MapperConfigBuilder mapperConfigBuilder;

    @SuppressWarnings("unused")
    public void mapperConfig(Closure<?> closure) {
        closure.setDelegate(mapperConfigBuilder);
        closure.call();
    }

    public MapperConfigBuilder getMapperConfig() {
        return mapperConfigBuilder;
    }

    private final ServiceConfigBuilder serviceConfigBuilder;

    @SuppressWarnings("unused")
    public void serviceConfig(Closure<?> closure) {
        closure.setDelegate(serviceConfigBuilder);
        closure.call();
    }

    public ServiceConfigBuilder getServiceConfig() {
        return serviceConfigBuilder;
    }

    private final ServiceImplConfigBuilder serviceImplConfigBuilder;

    @SuppressWarnings("unused")
    public void serviceImplConfig(Closure<?> closure) {
        closure.setDelegate(serviceImplConfigBuilder);
        closure.call();
    }

    public ServiceImplConfigBuilder getServiceImplConfig() {
        return serviceImplConfigBuilder;
    }

    private final ControllerConfigBuilder controllerConfigBuilder;

    @SuppressWarnings("unused")
    public void controllerConfig(Closure<?> closure) {
        closure.setDelegate(controllerConfigBuilder);
        closure.call();
    }

    public ControllerConfigBuilder getControllerConfig() {
        return controllerConfigBuilder;
    }

    private final TableDefConfigBuilder tableDefConfigBuilder;

    @SuppressWarnings("unused")
    public void tableDefConfig(Closure<?> closure) {
        closure.setDelegate(tableDefConfigBuilder);
        closure.call();
    }

    public TableDefConfigBuilder getTableDefConfig() {
        return tableDefConfigBuilder;
    }

    private final MapperXmlConfigBuilder mapperXmlConfigBuilder;

    @SuppressWarnings("unused")
    public void mapperXmlConfig(Closure<?> closure) {
        closure.setDelegate(mapperXmlConfigBuilder);
        closure.call();
    }

    public MapperXmlConfigBuilder getMapperXmlConfig() {
        return mapperXmlConfigBuilder;
    }

    public boolean isEntityGenerateEnable() {
        return entityGenerateEnable;
    }

    public void setEntityGenerateEnable(boolean entityGenerateEnable) {
        this.entityGenerateEnable = entityGenerateEnable;
    }

    public boolean isMapperGenerateEnable() {
        return mapperGenerateEnable;
    }

    public void setMapperGenerateEnable(boolean mapperGenerateEnable) {
        this.mapperGenerateEnable = mapperGenerateEnable;
    }

    public boolean isServiceGenerateEnable() {
        return serviceGenerateEnable;
    }

    public void setServiceGenerateEnable(boolean serviceGenerateEnable) {
        this.serviceGenerateEnable = serviceGenerateEnable;
    }

    public boolean isServiceImplGenerateEnable() {
        return serviceImplGenerateEnable;
    }

    public void setServiceImplGenerateEnable(boolean serviceImplGenerateEnable) {
        this.serviceImplGenerateEnable = serviceImplGenerateEnable;
    }

    public boolean isControllerGenerateEnable() {
        return controllerGenerateEnable;
    }

    public void setControllerGenerateEnable(boolean controllerGenerateEnable) {
        this.controllerGenerateEnable = controllerGenerateEnable;
    }

    public boolean isTableDefGenerateEnable() {
        return tableDefGenerateEnable;
    }

    public void setTableDefGenerateEnable(boolean tableDefGenerateEnable) {
        this.tableDefGenerateEnable = tableDefGenerateEnable;
    }

    public boolean isMapperXmlGenerateEnable() {
        return mapperXmlGenerateEnable;
    }

    public void setMapperXmlGenerateEnable(boolean mapperXmlGenerateEnable) {
        this.mapperXmlGenerateEnable = mapperXmlGenerateEnable;
    }

    public boolean isPackageInfoGenerateEnable() {
        return packageInfoGenerateEnable;
    }

    public void setPackageInfoGenerateEnable(boolean packageInfoGenerateEnable) {
        this.packageInfoGenerateEnable = packageInfoGenerateEnable;
    }
}
