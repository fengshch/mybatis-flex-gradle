package com.github.fengshch.mybatis.tasks;

import com.github.fengshch.mybatis.config.*;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.EntityConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.TableDefConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;
import java.util.Arrays;

public class MyBatisGenerateTask extends DefaultTask {
    private final GlobalConfigBuilder globalConfigBuilder;

    @Inject
    public MyBatisGenerateTask(GlobalConfigBuilder globalConfigBuilder) {
        this.setGroup("mybatis");
        this.setDescription("Generate MyBatis Flex Code");
        this.globalConfigBuilder = globalConfigBuilder;
    }

    @TaskAction
    void generate() throws ClassNotFoundException {
        HikariDataSource dataSource = getDataSource();
        GlobalConfig globalConfig = getGlobalConfig();
        Generator generator = new Generator(dataSource, globalConfig);
        generator.generate();
    }

    private HikariDataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        DataSourceConfigBuilder dataSourceConfig = globalConfigBuilder.getDataSourceConfig();
        dataSource.setJdbcUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUsername());
        dataSource.setPassword(dataSourceConfig.getPassword());
        dataSource.setDriverClassName(dataSourceConfig.getDriverClassName());
        return dataSource;

    }


    private GlobalConfig getGlobalConfig() throws ClassNotFoundException {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setEntityGenerateEnable(globalConfigBuilder.isEntityGenerateEnable());
        globalConfig.setMapperGenerateEnable(globalConfigBuilder.isMapperGenerateEnable());
        globalConfig.setServiceGenerateEnable(globalConfigBuilder.isServiceGenerateEnable());
        globalConfig.setServiceImplGenerateEnable(globalConfigBuilder.isServiceImplGenerateEnable());
        globalConfig.setControllerGenerateEnable(globalConfigBuilder.isControllerGenerateEnable());
        globalConfig.setTableDefGenerateEnable(globalConfigBuilder.isTableDefGenerateEnable());
        globalConfig.setMapperXmlGenerateEnable(globalConfigBuilder.isMapperXmlGenerateEnable());
        globalConfig.setPackageInfoGenerateEnable(globalConfigBuilder.isPackageInfoGenerateEnable());

        globalConfigBuilder.getJavadocConfig().build(globalConfig);
        globalConfigBuilder.getPackageConfig().build(this.getProject(), globalConfig);
        globalConfigBuilder.getStrategyConfig().build(globalConfig);

//        if (globalConfigBuilder.getTemplateConfig() != null) {
//            setTemplateConfig(globalConfig);
//        }
        globalConfigBuilder.getEntityConfig().build(globalConfig);
        globalConfigBuilder.getMapperConfig().build(globalConfig);
        globalConfigBuilder.getServiceConfig().build(globalConfig);
        globalConfigBuilder.getServiceImplConfig().build(globalConfig);
        globalConfigBuilder.getControllerConfig().build(globalConfig);
        globalConfigBuilder.getTableDefConfig().build(globalConfig);
        globalConfigBuilder.getMapperXmlConfig().build(globalConfig);

        return globalConfig;
    }

}
