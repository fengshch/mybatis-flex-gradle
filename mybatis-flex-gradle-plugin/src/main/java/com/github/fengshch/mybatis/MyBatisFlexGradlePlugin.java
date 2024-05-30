/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.fengshch.mybatis;

import com.github.fengshch.mybatis.config.DataSourceConfigBuilder;
import com.github.fengshch.mybatis.config.GlobalConfigBuilder;
import com.github.fengshch.mybatis.ext.MyBatisExtension;
import com.github.fengshch.mybatis.tasks.*;
import org.apache.commons.lang3.StringUtils;
import org.flywaydb.gradle.FlywayExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.internal.file.FileMetadata;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.gradle.internal.file.impl.DefaultFileMetadata.file;

/**
 * A simple 'hello world' plugin.
 */
public class MyBatisFlexGradlePlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getPlugins().apply(JavaBasePlugin.class);

        MyBatisExtension myBatisExtension = project.getExtensions().create("mybatis", MyBatisExtension.class);
        project.getExtensions().create("flyway", FlywayExtension.class);

        project.afterEvaluate(p -> {
            System.out.println("mybatis: " + myBatisExtension.getConfigurations().getNames());
            myBatisExtension.getConfigurations().forEach(globalConfigBuilder -> {
                configDatasource(project, globalConfigBuilder);
                createGenerateTask(project, globalConfigBuilder);

                project.getPlugins().withType(JavaBasePlugin.class, javaBasePlugin -> {
                    JavaPluginExtension javaPluginExtension = project.getExtensions().getByType(JavaPluginExtension.class);
                    SourceSetContainer sourceSets = javaPluginExtension.getSourceSets();

                    if (sourceSets.getNames().contains("main")) {
                        SourceSet sourceSet = sourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME);
                        String batisSourceSetJavaDir = globalConfigBuilder.getPackageConfigBuilder().getSourceDir();
                        sourceSet.getJava().srcDir(batisSourceSetJavaDir);
                    }
                });

                FlywayExtension flywayExtension = globalConfigBuilder.getFlywayExtension();
                applyFlywayTask(project, globalConfigBuilder, flywayExtension);
            });
        });
    }

    private void createGenerateTask(Project project, GlobalConfigBuilder globalConfigBuilder) {
        String name = globalConfigBuilder.getName().equals("main") ? "" : globalConfigBuilder.getName();
        String taskName = "mybatis" + StringUtils.capitalize(name) + "Generate";
        project.getTasks().register(taskName, MyBatisGenerateTask.class, globalConfigBuilder);
    }

    @SuppressWarnings("unchecked")
    private void configDatasource(Project project, GlobalConfigBuilder globalConfigBuilder) {
        String profile = "default";
        if (project.hasProperty("profile"))
            profile = (String) project.property("profile");
        else if (getActiveProfile(project) != null) {
            profile = getActiveProfile(project);
        } else if (System.getenv("PROFILE") != null) {
            profile = System.getenv("PROFILE");
        }


        DataSourceConfigBuilder dataSourceConfig = globalConfigBuilder.getDataSourceConfigBuilder();
        String configName = globalConfigBuilder.getName();

        Map<String, String> pathsMap = getStringStringMap();
        String configFileName = pathsMap.get(profile);
        File configFile = project.file(configFileName);
        if (configFile.exists()) {
            Map<String, Object> props = loadYaml(configFile);
            if (props == null)
                return;
            Map<String, Object> mainConfig = (Map<String, Object>) props.get("spring");
            if (mainConfig == null)
                return;
            Map<String, Object> datasource = (Map<String, Object>) mainConfig.get("datasource");
            if (datasource == null)
                return;
            datasource = modifyDatasource(datasource, project);
            if ("main".equals(configName)) {
                setConfigFromMap(dataSourceConfig, datasource);
            } else {
                Map<String, Object> datasourceMap = (Map<String, Object>) datasource.get(configName);
                setConfigFromMap(dataSourceConfig, datasourceMap);
            }
        }
    }

    @NotNull
    private static Map<String, String> getStringStringMap() {
        Map<String, String> pathsMap = new HashMap<>();
        pathsMap.put("default", "src/main/resources/application.yml");
        pathsMap.put("dev", "src/main/resources/application-dev.yml");
        pathsMap.put("test", "src/main/resources/application-test.yml");
        return pathsMap;
    }

    private HashMap<String, Object> loadYaml(File file) {
        Yaml yaml = new Yaml();
        try (FileInputStream fis = new FileInputStream(file)) {
            return yaml.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Properties loadProperties(File file) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        }
        return properties;
    }

    private void setConfigFromMap(DataSourceConfigBuilder config, Map<String, Object> datasource) {
        config.setDriverClassName(String.valueOf(datasource.getOrDefault("driverClassName", datasource.get("driver-class-name"))));
        config.setUrl(String.valueOf(datasource.get("url")));
        config.setUsername(String.valueOf(datasource.get("username")));
        config.setPassword(String.valueOf(datasource.get("password")));
    }

    private void setConfigFromProperties(DataSourceConfigBuilder config, Properties properties, String prefix) {
        config.setDriverClassName(properties.getProperty(prefix + ".driverClassName", properties.getProperty(prefix + ".driver-class-name")));
        config.setUrl(properties.getProperty(prefix + ".url"));
        config.setUsername(properties.getProperty(prefix + ".username"));
        config.setPassword(properties.getProperty(prefix + ".password"));
    }

    private void applyFlywayTask(Project project, GlobalConfigBuilder globalConfigBuilder, FlywayExtension
            flywayExtension) {
        String taskNamePri = globalConfigBuilder.getName().equals("main") ? "flyway" : globalConfigBuilder.getName();
        project.getTasks().register(taskNamePri + "Clean", CustomFlywayCleanTask.class, flywayExtension);
        project.getTasks().create(taskNamePri + "Baseline", CustomFlywayBaselineTask.class, flywayExtension);
        project.getTasks().create(taskNamePri + "Migrate", CustomFlywayMigrateTask.class, flywayExtension);
        project.getTasks().create(taskNamePri + "Undo", CustomFlywayUndoTask.class, flywayExtension);
        project.getTasks().create(taskNamePri + "Validate", CustomFlywayValidateTask.class, flywayExtension);
        project.getTasks().create(taskNamePri + "Info", CustomFlywayInfoTask.class, flywayExtension);
        project.getTasks().create(taskNamePri + "Repair", CustomFlywayRepairTask.class, flywayExtension);
    }

    @SuppressWarnings("unchecked")
    private String getActiveProfile(Project project) {
        File yamlFile = project.file("src/main/resources/application.yml");
        if (yamlFile.exists()) {
            Map<String, Object> props = loadYaml(yamlFile);
            if (props != null) {
                Map<String, Object> spring = (Map<String, Object>) props.get("spring");
                if (spring == null) return null;
                Map<String, Object> profiles = (Map<String, Object>) spring.get("profiles");
                if (profiles != null) return (String) profiles.get("active");
            }
        }
        return null;
    }

    private Map<String, Object>  modifyDatasource(Map<String, Object> datasource,Project project ){
        if (datasource == null)
           return null;
        String url = (String) datasource.get("url");
        if(url.contains("jdbc:h2:file:./")){
            String path = project.getProjectDir().getAbsolutePath();
            url = url.replace("jdbc:h2:file:./", "jdbc:h2:file:"+path+"/");
        }
        if(url.contains("jdbc:h2:file:../")){
            String path = project.getProjectDir().getParentFile().getAbsolutePath();
            url = url.replace("jdbc:h2:file:../", "jdbc:h2:file:"+path+"/");
        }
        datasource.put("url", url);
        return datasource;
    }
}