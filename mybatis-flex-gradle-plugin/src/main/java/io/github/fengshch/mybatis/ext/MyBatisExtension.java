package io.github.fengshch.mybatis.ext;

import io.github.fengshch.mybatis.config.GlobalConfigBuilder;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;

/**
 * Main Gradle extension for MyBatis Flex code generation plugin.
 *
 * This extension provides access to named domain object containers for managing multiple
 * {@link GlobalConfigBuilder} configurations, allowing users to define different code
 * generation profiles within their Gradle build script.
 *
 * @see GlobalConfigBuilder
 * @see NamedDomainObjectContainer
 */
public class MyBatisExtension {
    private final NamedDomainObjectContainer<GlobalConfigBuilder> configurations;

    /**
     * Constructs a new {@code MyBatisExtension} with the specified object factory.
     *
     * @param objectFactory the Gradle {@link ObjectFactory} for creating domain objects
     */
    @Inject
    public MyBatisExtension(ObjectFactory objectFactory) {
        configurations = objectFactory.domainObjectContainer(GlobalConfigBuilder.class, name -> objectFactory.newInstance(GlobalConfigBuilder.class, name));
    }

    public NamedDomainObjectContainer<GlobalConfigBuilder> getConfigurations() {
        return configurations;
    }
}
