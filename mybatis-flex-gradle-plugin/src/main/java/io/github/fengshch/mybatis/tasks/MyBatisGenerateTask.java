package io.github.fengshch.mybatis.tasks;

import io.github.fengshch.mybatis.config.*;
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
import org.jspecify.annotations.NonNull;

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
 * <p>
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
        getLogger().lifecycle("Starting MyBatis Flex generation for task {}", getPath());

        // Clean the batis directory before generation
        cleanBatisDirectory();

        HikariDataSource dataSource = getDataSource();
        Generator generator = getGenerator(dataSource);
        JdbcTypeMapping.registerMapping(Timestamp.class, LocalDateTime.class);
        generator.generate();
        dataSource.close();

        getLogger().lifecycle("MyBatis Flex generation finished for task {}", getPath());
    }

    private @NonNull Generator getGenerator(HikariDataSource dataSource) throws ClassNotFoundException {
        GlobalConfig globalConfig = getGlobalConfig();
        IDialect iDialect = switch (dataSource.getDriverClassName()) {
            case "org.postgresql.Driver" -> IDialect.POSTGRESQL;
            case "com.mysql.cj.jdbc.Driver" -> IDialect.MYSQL;
            case "oracle.jdbc.driver.OracleDriver" -> IDialect.ORACLE;
            case "org.sqlite.JDBC" -> IDialect.SQLITE;
            default -> IDialect.DEFAULT;
        };
        return new Generator(dataSource, globalConfig, iDialect);
    }

    /**
     * Cleans the batis directory before code generation to ensure a fresh start.
     * This method deletes the configured source directory if it exists.
     */
    private void cleanBatisDirectory() throws IOException {
        String sourceDir = globalConfigBuilder.getPackageConfigBuilder().getResolvedSourceDir();
        if (StringUtils.isBlank(sourceDir)) {
            return;
        }

        getLogger().lifecycle("Configured source directory: {}", sourceDir);

        File fileDir = new File(sourceDir);
        if (sourceDir.endsWith("src/main/java")) {
            String packageDir = globalConfigBuilder.getPackageConfigBuilder().getBasePackage();
            String packagePath = packageDir.replace(".", File.separator);
            fileDir = new File(sourceDir, packagePath);
            getLogger().lifecycle("Configured base package: {}", packageDir);
            getLogger().lifecycle("Resolved package directory: {}", packagePath);
//            fileDir = new File(fileDir.toURI());
        }
        getLogger().lifecycle("Resolved generation target directory: {}", fileDir.getAbsolutePath());
        if (fileDir.exists() && fileDir.isDirectory()) {
            getLogger().lifecycle("Cleaning batis directory: {}", fileDir.getAbsolutePath());
            deleteDirectory(fileDir);
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
        globalConfigBuilder.getPackageConfigBuilder().build(globalConfig);
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
