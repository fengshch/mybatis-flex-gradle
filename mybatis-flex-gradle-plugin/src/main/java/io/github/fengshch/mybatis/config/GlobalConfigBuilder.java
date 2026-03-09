package io.github.fengshch.mybatis.config;

import groovy.lang.Closure;
import lombok.Getter;
import lombok.Setter;
import org.flywaydb.gradle.FlywayExtension;

import javax.inject.Inject;

/**
 * Builder class for global code generation configuration.
 *
 * This class orchestrates all configuration builders including datasource, flyway, package,
 * entity, mapper, service, controller, and table configurations. It provides methods to enable/disable
 * code generation for different component types and configure Closure-based configuration blocks.
 *
 * @see DataSourceConfigBuilder
 * @see FlywayExtension
 * @see EntityConfigBuilder
 * @see MapperConfigBuilder
 * @see ServiceConfigBuilder
 */
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
    private final TemplateConfigBuilder templateConfigBuilder;

    private final FlywayExtension flywayExtension;

    private final EntityConfigBuilder entityConfigBuilder;
    private final MapperConfigBuilder mapperConfigBuilder;
    private final ServiceConfigBuilder serviceConfigBuilder;
    private final ServiceImplConfigBuilder serviceImplConfigBuilder;
    private final ControllerConfigBuilder controllerConfigBuilder;
    private final TableConfigBuilder tableConfigBuilder;
    private final TableDefConfigBuilder tableDefConfigBuilder;
    private final MapperXmlConfigBuilder mapperXmlConfigBuilder;

    /**
     * Constructs a new {@code GlobalConfigBuilder} with the specified configuration name.
     *
     * @param name the unique name for this configuration
     */
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

    /**
     * Configures Flyway database migration settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring flyway properties
     */
    @SuppressWarnings("unused")
    public void flyway(Closure<?> closure) {
        closure.setDelegate(flywayExtension);
        closure.call();
    }

    /**
     * Gets the configured Flyway extension with database connection settings from datasource config if not set.
     *
     * @return the {@link FlywayExtension} with configured settings
     */
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

    /**
     * Configures datasource settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring datasource properties
     */
    @SuppressWarnings("unused")
    public void dataSourceConfig(Closure<?> closure) {
        closure.setDelegate(dataSourceConfigBuilder);
        closure.call();
    }

    /**
     * Configures javadoc generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring javadoc properties
     */
    @SuppressWarnings("unused")
    public void javadocConfig(Closure<?> closure) {
        closure.setDelegate(javadocConfigBuilder);
        closure.call();
    }

    /**
     * Configures package paths and names using a Closure.
     *
     * @param closure the {@link Closure} for configuring package properties
     */
    @SuppressWarnings("unused")
    public void packageConfig(Closure<?> closure) {
        closure.setDelegate(packageConfigBuilder);
        closure.call();
    }

    /**
     * Configures code generation strategy using a Closure.
     *
     * @param closure the {@link Closure} for configuring strategy properties
     */
    @SuppressWarnings("unused")
    public void strategyConfig(Closure<?> closure) {
        closure.setDelegate(strategyConfigBuilder);
        closure.call();
    }

    /**
     * Configures template settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring template properties
     */
    @SuppressWarnings("unused")
    public void templateConfig(Closure<?> closure) {
        closure.setDelegate(templateConfigBuilder);
        closure.call();
    }

    /**
     * Configures entity code generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring entity properties
     */
    @SuppressWarnings("unused")
    public void entityConfig(Closure<?> closure) {
        closure.setDelegate(entityConfigBuilder);
        closure.call();
    }

    /**
     * Configures mapper interface code generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring mapper properties
     */
    @SuppressWarnings("unused")
    public void mapperConfig(Closure<?> closure) {
        closure.setDelegate(mapperConfigBuilder);
        closure.call();
    }

    /**
     * Configures service interface code generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring service properties
     */
    @SuppressWarnings("unused")
    public void serviceConfig(Closure<?> closure) {
        closure.setDelegate(serviceConfigBuilder);
        closure.call();
    }

    /**
     * Configures service implementation code generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring service implementation properties
     */
    @SuppressWarnings("unused")
    public void serviceImplConfig(Closure<?> closure) {
        closure.setDelegate(serviceImplConfigBuilder);
        closure.call();
    }

    /**
     * Configures controller code generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring controller properties
     */
    @SuppressWarnings("unused")
    public void controllerConfig(Closure<?> closure) {
        closure.setDelegate(controllerConfigBuilder);
        closure.call();
    }

    /**
     * Configures table-specific code generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring table properties
     */
    public void tableConfig(Closure<?> closure) {
        closure.setDelegate(tableConfigBuilder);
        closure.call();
    }

    /**
     * Configures TableDef (table definition) code generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring table definition properties
     */
    @SuppressWarnings("unused")
    public void tableDefConfig(Closure<?> closure) {
        closure.setDelegate(tableDefConfigBuilder);
        closure.call();
    }

    /**
     * Configures mapper XML file code generation settings using a Closure.
     *
     * @param closure the {@link Closure} for configuring mapper XML properties
     */
    @SuppressWarnings("unused")
    public void mapperXmlConfig(Closure<?> closure) {
        closure.setDelegate(mapperXmlConfigBuilder);
        closure.call();
    }
}
