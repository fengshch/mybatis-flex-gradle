package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.MapperConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MapperConfigBuilder {

    /**
     * 代码生成目录，当未配置时，使用 PackageConfig 的配置
     */
    private String sourceDir;
    /**
     * Mapper 类的前缀。
     */
    private String classPrefix = "";

    /**
     * Mapper 类的后缀。
     */
    private String classSuffix = "Mapper";

    /**
     * 自定义 Mapper 的父类。
     */
    private String superClass = "com.mybatisflex.core.BaseMapper";

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = true;

    /**
     * 是否添加 {@code @Mapper} 注解。
     */
    private boolean mapperAnnotation = true;

    public void build(GlobalConfig globalConfig) {
        MapperConfig mapperConfig = globalConfig.getMapperConfig();

        if (StringUtils.isNotBlank(sourceDir)) {
            mapperConfig.setSourceDir(sourceDir);
        }
        if (StringUtils.isNotBlank(classPrefix)) {
            mapperConfig.setClassPrefix(classPrefix);
        }
        if (StringUtils.isNotBlank(classSuffix)) {
            mapperConfig.setClassSuffix(classSuffix);
        }
        if (StringUtils.isNotBlank(superClass)) {
            try {

                Class<?> aClass = Class.forName(superClass);
                mapperConfig.setSuperClass(aClass);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        mapperConfig.setOverwriteEnable(overwriteEnable);
        mapperConfig.setMapperAnnotation(mapperAnnotation);
    }
}
