package io.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.PackageConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * Builder class for configuring package paths and naming conventions.
 *
 * This class configures the directory and package structure for all generated code including
 * entities, mappers, services, controllers, and table definitions. It also handles XML mapper
 * file output paths.
 *
 * @see GlobalConfigBuilder
 * @see PackageConfig
 */
public class PackageConfigBuilder {

    /**
     * Constructs a new {@code PackageConfigBuilder} with default settings.
     */
    public PackageConfigBuilder() {
    }

    /**
     * 代码生成目录。
     */
    private String sourceDir = "src/batis/java";

    /**
     * 根包。
     */
    private String basePackage = "com.mybatisflex";

    /**
     * Entity 所在包。
     */
    private String entityPackage = "po";

    /**
     * Mapper 所在包。
     */
    private String mapperPackage;

    /**
     * Service 所在包。
     */
    private String servicePackage = "repo";

    /**
     * ServiceImpl 所在包。
     */
    private String serviceImplPackage = "repo.impl";

    /**
     * Controller 所在包。
     */
    private String controllerPackage;

    /**
     * TableDef 所在包。
     */
    private String tableDefPackage;

    /**
     * MapperXml 文件所在位置。
     */
    private String mapperXmlPath;// = "src/batis/resources/mapper";

    /**
     * Captured at configuration time to keep task execution configuration-cache safe.
     */
    private String projectDir;

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getTableDefPackage() {
        return tableDefPackage;
    }

    public void setTableDefPackage(String tableDefPackage) {
        this.tableDefPackage = tableDefPackage;
    }

    public String getMapperXmlPath() {
        return mapperXmlPath;
    }

    public void setMapperXmlPath(String mapperXmlPath) {
        this.mapperXmlPath = mapperXmlPath;
    }

    public String getProjectDir() {
        return projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }

    /**
     * Builds and applies the package configuration to the global config.
     *
     * @param globalConfig the {@link GlobalConfig} to update with package settings
     */
    public void build(GlobalConfig globalConfig) {
        PackageConfig packageConfig = globalConfig.getPackageConfig();
        if (StringUtils.isNotBlank(sourceDir)){
            String path = resolveProjectPath(sourceDir);
            packageConfig.setSourceDir(path);
        }
        if (StringUtils.isNotBlank(basePackage))
            packageConfig.setBasePackage(basePackage);
        if (StringUtils.isNotBlank(entityPackage))
            packageConfig.setEntityPackage(basePackage + "." + entityPackage);
        if (StringUtils.isNotBlank(mapperPackage))
            packageConfig.setMapperPackage(basePackage + "." + mapperPackage);
        if (StringUtils.isNotBlank(servicePackage))
            packageConfig.setServicePackage(basePackage + "." + servicePackage);
        if (StringUtils.isNotBlank(serviceImplPackage))
            packageConfig.setServiceImplPackage(basePackage + "." +serviceImplPackage);
        if (StringUtils.isNotBlank(controllerPackage))
            packageConfig.setControllerPackage(basePackage + "." + controllerPackage);
        if (StringUtils.isNotBlank(tableDefPackage))
            packageConfig.setTableDefPackage(basePackage + "." + tableDefPackage);
        if (StringUtils.isNotBlank(mapperXmlPath)){
            String path = resolveProjectPath(mapperXmlPath);
            packageConfig.setMapperXmlPath(path);
        }else{
            if(StringUtils.isBlank(mapperPackage )){
                mapperPackage = "mapper";
            }
            String path = resolveProjectPath(sourceDir + "/" + basePackage.replace(".", "/") + "/" + mapperPackage + "/xml");
            packageConfig.setMapperXmlPath(path);
        }
    }

    /**
     * Resolves the configured source directory against the captured project directory.
     *
     * @return the absolute source directory path, or {@code null} when no source directory is configured
     */
    public String getResolvedSourceDir() {
        if (StringUtils.isBlank(sourceDir)) {
            return null;
        }
        return resolveProjectPath(sourceDir);
    }

    private String resolveProjectPath(String path) {
        if (StringUtils.isBlank(projectDir)) {
            return path;
        }
        return projectDir + "/" + path;
    }
}
