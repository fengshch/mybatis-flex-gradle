package com.github.fengshch.mybatis.tasks;

import com.github.fengshch.mybatis.config.*;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.EntityConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.TableDefConfig;
import com.mybatisflex.codegen.dialect.IDialect;
import com.mybatisflex.codegen.dialect.JdbcTypeMapping;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
        IDialect iDialect = switch (dataSource.getDriverClassName()) {
            case "org.postgresql.Driver" -> IDialect.POSTGRESQL;
            case "com.mysql.cj.jdbc.Driver" -> IDialect.MYSQL;
            case "oracle.jdbc.driver.OracleDriver" -> IDialect.ORACLE;
            case "org.sqlite.JDBC" -> IDialect.SQLITE;
            default -> IDialect.DEFAULT;
        };
        Generator generator = new Generator(dataSource, globalConfig, iDialect);
        JdbcTypeMapping.registerMapping(Timestamp.class, LocalDateTime.class);
        generator.generate();
        dataSource.close();
    }

    private HikariDataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        DataSourceConfigBuilder dataSourceConfig = globalConfigBuilder.getDataSourceConfigBuilder();
        dataSource.setJdbcUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUsername());
        dataSource.setPassword(dataSourceConfig.getPassword());
        dataSource.setDriverClassName(dataSourceConfig.getDriverClassName());
        return dataSource;

    }


    private GlobalConfig getGlobalConfig() throws ClassNotFoundException {
        GlobalConfig globalConfig = getConfig();

        globalConfigBuilder.getJavadocConfigBuilder().build(globalConfig);
        globalConfigBuilder.getPackageConfigBuilder().build(this.getProject(), globalConfig);
        globalConfigBuilder.getStrategyConfigBuilder().build(globalConfig);

//        if (globalConfigBuilder.getTemplateConfig() != null) {
//            setTemplateConfig(globalConfig);
//        }
        globalConfigBuilder.getEntityConfigBuilder().build(globalConfig);
        globalConfigBuilder.getMapperConfigBuilder().build(globalConfig);
        globalConfigBuilder.getServiceConfigBuilder().build(globalConfig);
        globalConfigBuilder.getServiceImplConfigBuilder().build(globalConfig);
        globalConfigBuilder.getControllerConfigBuilder().build(globalConfig);
        globalConfigBuilder.getTableDefConfigBuilder().build(globalConfig);
        globalConfigBuilder.getMapperXmlConfigBuilder().build(globalConfig);

        return globalConfig;
    }

    @NotNull
    private GlobalConfig getConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setEntityGenerateEnable(globalConfigBuilder.isEntityGenerateEnable());
        globalConfig.setMapperGenerateEnable(globalConfigBuilder.isMapperGenerateEnable());
        globalConfig.setServiceGenerateEnable(globalConfigBuilder.isServiceGenerateEnable());
        globalConfig.setServiceImplGenerateEnable(globalConfigBuilder.isServiceImplGenerateEnable());
        globalConfig.setControllerGenerateEnable(globalConfigBuilder.isControllerGenerateEnable());
        globalConfig.setTableDefGenerateEnable(globalConfigBuilder.isTableDefGenerateEnable());
        globalConfig.setMapperXmlGenerateEnable(globalConfigBuilder.isMapperXmlGenerateEnable());
        globalConfig.setPackageInfoGenerateEnable(globalConfigBuilder.isPackageInfoGenerateEnable());
        return globalConfig;
    }

}
