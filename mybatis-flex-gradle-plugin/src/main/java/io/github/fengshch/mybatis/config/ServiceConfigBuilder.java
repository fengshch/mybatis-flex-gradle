package io.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.ServiceConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * Builder class for configuring Service interface code generation settings.
 *
 * This class configures the generation of service interface classes, including
 * naming conventions, inheritance, output paths, and overwrite options.
 *
 * @see GlobalConfigBuilder
 * @see ServiceConfig
 */
public class ServiceConfigBuilder {
    /**
     * Constructs a new {@code ServiceConfigBuilder} with default settings.
     */
    public ServiceConfigBuilder() {
    }

    /**
     * 代码生成目录，当未配置时，使用 PackageConfig 的配置
     */
    private String sourceDir;
    /**
     * Service 类的前缀。
     */
    private String classPrefix = "";

    /**
     * Service 类的后缀。
     */
//    private String classSuffix = "Service";
    private String classSuffix = "Repo";

    /**
     * 自定义 Service 的父类。
     */
    private String superClass = "com.mybatisflex.core.service.IService";

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = false;

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String getClassPrefix() {
        return classPrefix;
    }

    public void setClassPrefix(String classPrefix) {
        this.classPrefix = classPrefix;
    }

    public String getClassSuffix() {
        return classSuffix;
    }

    public void setClassSuffix(String classSuffix) {
        this.classSuffix = classSuffix;
    }

    public String getSuperClass() {
        return superClass;
    }

    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    public boolean isOverwriteEnable() {
        return overwriteEnable;
    }

    public void setOverwriteEnable(boolean overwriteEnable) {
        this.overwriteEnable = overwriteEnable;
    }

    /**
     * Builds and applies the service configuration to the global config.
     *
     * @param globalConfig the {@link GlobalConfig} to update with service settings
     */
    public void build(GlobalConfig globalConfig) {
        ServiceConfig serviceConfig = globalConfig.getServiceConfig();

        if(StringUtils.isNotBlank(sourceDir)){
            serviceConfig.setSourceDir(sourceDir);
        }

        if (StringUtils.isNotBlank(classPrefix)) {
            serviceConfig.setClassPrefix(classPrefix);
        }
        if (StringUtils.isNotBlank(classSuffix)) {
            serviceConfig.setClassSuffix(classSuffix);
        }
        if (StringUtils.isNotBlank(superClass)) {
            try {
                Class<?> aClass = Class.forName(superClass);
                serviceConfig.setSuperClass(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        serviceConfig.setOverwriteEnable(overwriteEnable);
    }
}
