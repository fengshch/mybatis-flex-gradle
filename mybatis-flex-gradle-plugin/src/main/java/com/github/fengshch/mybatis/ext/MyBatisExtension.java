package com.github.fengshch.mybatis.ext;

import com.github.fengshch.mybatis.config.GlobalConfigBuilder;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;

public class MyBatisExtension {
    private final NamedDomainObjectContainer<GlobalConfigBuilder> configurations;

    @Inject
    public MyBatisExtension(ObjectFactory objectFactory) {
        configurations = objectFactory.domainObjectContainer(GlobalConfigBuilder.class, name -> objectFactory.newInstance(GlobalConfigBuilder.class, name));
    }

    public NamedDomainObjectContainer<GlobalConfigBuilder> getConfigurations() {
        return configurations;
    }
}
