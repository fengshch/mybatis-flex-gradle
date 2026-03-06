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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Gradle task for executing MyBatis Flex code generation.
 *
 * This task performs the actual code generation based on the database schema and the
 * configuration provided by {@link GlobalConfigBuilder}. It connects to the database,
 * introspects the schema, and generates entity, mapper, service, and other related classes.
 *
 * @see GlobalConfigBuilder
 * @see Generator
 */
public class MyBatisGenerateTask extends DefaultTask {
    private final GlobalConfigBuilder globalConfigBuilder;

    /**
     * Constructs a new {@code MyBatisGenerateTask} with the specified global config builder.
     *
     * @param globalConfigBuilder the {@link GlobalConfigBuilder} containing generation configuration
     */
    @Inject
    public MyBatisGenerateTask(GlobalConfigBuilder globalConfigBuilder) {
        this.setGroup("mybatis");
        this.setDescription("Generate MyBatis Flex Code");
        this.globalConfigBuilder = globalConfigBuilder;
    }

    @TaskAction
    void generate() throws ClassNotFoundException, IOException {
        // Clean the batis directory before generation
        cleanBatisDirectory();

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

    /**
     * Cleans the batis directory before code generation to ensure a fresh start.
     * This method deletes the configured source directory if it exists.
     */
    private void cleanBatisDirectory() throws IOException {
        String sourceDir = globalConfigBuilder.getPackageConfigBuilder().getSourceDir();
        if (StringUtils.isBlank(sourceDir)) {
            return;
        }

        File batisDir = new File(getProject().getProjectDir(), sourceDir);
        if (batisDir.exists() && batisDir.isDirectory()) {
            getLogger().lifecycle("Cleaning batis directory: {}", batisDir.getAbsolutePath());
            deleteDirectory(batisDir);
            getLogger().lifecycle("Batis directory cleaned successfully");
        }
    }

    /**
     * Recursively deletes a directory and all its contents.
     *
     * @param directory the directory to delete
     * @throws IOException if an I/O error occurs
     */
    private void deleteDirectory(File directory) throws IOException {
        Path dirPath = directory.toPath();
        if (Files.exists(dirPath)) {
            Files.walk(dirPath)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
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
