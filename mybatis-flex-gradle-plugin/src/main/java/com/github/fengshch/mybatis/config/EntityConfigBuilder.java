package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.EntityConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class EntityConfigBuilder {
    /**
     * Entity 类的后缀。
     */
    private String classSuffix = "";

    /**
     * Entity 类的父类，可以自定义一些 BaseEntity 类。
     */
    private String superClass;

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = true;

    /**
     * Entity 默认实现的接口。
     */
    private String implInterfaces;

    /**
     * Entity 是否使用 Lombok 注解。
     */
    private boolean withLombok = true;

    /**
     * Entity 是否使用 Swagger 注解。
     */
    private boolean withSwagger = false;

    /**
     * Swagger 版本
     */
    private String swaggerVersion;

    /**
     * Entity 是否启用 Active Record 功能。
     */
    private boolean withActiveRecord = false;

    /**
     * 实体类数据源。
     */
    private String dataSource;

    public void build(GlobalConfig globalConfig) throws ClassNotFoundException {
        EntityConfig entityConfig = globalConfig.getEntityConfig();
        if (StringUtils.isNotBlank(classSuffix))
            entityConfig.setClassSuffix(classSuffix);

        if (StringUtils.isNotBlank(superClass)) {
            Class<?> aClass = Class.forName(superClass);
            entityConfig.setSuperClass(aClass);
        }

        entityConfig.setOverwriteEnable(overwriteEnable);

        if (StringUtils.isNotBlank(implInterfaces)) {
            String[] array = this.implInterfaces.split(",");
            Class<?>[] classes = new Class[array.length];
            for (int i = 0; i < array.length; i++) {
                String implInterface = array[i];
                Class<?> aClass = Class.forName(implInterface);
                classes[i] = aClass;
            }
            entityConfig.setImplInterfaces(classes);
        }

        entityConfig.setWithLombok(withLombok);

        entityConfig.setWithSwagger(withSwagger);

        if (StringUtils.isNotBlank(swaggerVersion))
            entityConfig.setSwaggerVersion(EntityConfig.SwaggerVersion.valueOf(swaggerVersion));

        entityConfig.setWithActiveRecord(withActiveRecord);

        if (StringUtils.isNotBlank(dataSource))
            entityConfig.setDataSource(dataSource);

    }
}
