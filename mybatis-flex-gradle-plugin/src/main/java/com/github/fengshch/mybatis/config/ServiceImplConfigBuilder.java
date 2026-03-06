package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.ServiceImplConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Builder class for configuring Service implementation code generation settings.
 *
 * This class configures the generation of service implementation classes, including
 * naming conventions, inheritance, output paths, and cache example code generation.
 *
 * @see GlobalConfigBuilder
 * @see ServiceImplConfig
 */
@Data
public class ServiceImplConfigBuilder {

    /**
     * Constructs a new {@code ServiceImplConfigBuilder} with default settings.
     */
    public ServiceImplConfigBuilder() {
    }

    /**
     * 代码生成目录，当未配置时，使用 PackageConfig 的配置
     */
    private String sourceDir;
    /**
     * ServiceImpl 类的前缀。
     */
    private String classPrefix = "";

    /**
     * ServiceImpl 类的后缀。
     */
    private String classSuffix = "RepoImpl";

    /**
     * 自定义 ServiceImpl 的父类。
     */
    private String superClass;

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = false;

    /**
     * 是否生成缓存样例代码。
     */
    private boolean cacheExample = false;

    /**
     * Builds and applies the service implementation configuration to the global config.
     *
     * @param globalConfig the {@link GlobalConfig} to update with service implementation settings
     */
    public void build(GlobalConfig globalConfig) {
        ServiceImplConfig serviceImplConfig = globalConfig.getServiceImplConfig();

        if (StringUtils.isNotBlank(sourceDir)) {
            serviceImplConfig.setSourceDir(sourceDir);
        }

        if (StringUtils.isNotBlank(classPrefix)) {
            serviceImplConfig.setClassPrefix(classPrefix);
        }
        if (StringUtils.isNotBlank(classSuffix)) {
            serviceImplConfig.setClassSuffix(classSuffix);
        }
        if (StringUtils.isNotBlank(superClass)) {
            try {
                Class<?> aClass = Class.forName(superClass);
                serviceImplConfig.setSuperClass(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        serviceImplConfig.setOverwriteEnable(overwriteEnable);
        serviceImplConfig.setCacheExample(cacheExample);
    }
}
