package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.EntityConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
public class EntityConfigBuilder {

    /**
     * 代码生成目录，当未配置时，使用 PackageConfig 的配置
     */
    private String sourceDir;
    /**
     * Entity 类的前缀。
     */
    private String classPrefix = "";
    /**
     * Entity 类的后缀。
     */
    private String classSuffix = "PO";

    /**
     * Entity 类的父类，可以自定义一些 BaseEntity 类。
     */
    private String superClass;

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = true;

    /**
     * 生成Base类时是否覆盖之前生成的文件。
     */
    private boolean baseOverwriteEnable;

    /**
     * Entity 默认实现的接口。
     */
    private String implInterfaces;

    /**
     * Entity 是否使用 Lombok 注解。
     */
    private boolean withLombok = true;

    /**
     * 当开启 Lombok 注解且不使用 Active Record 时，是否生成 Entity @NoArgsConstructor 注解。
     */
    private boolean lombokNoArgsConstructorEnable = true;

    /**
     * 当开启 Lombok 注解且不使用 Active Record 时，是否生成 Entity @AllArgsConstructor 注解。
     */
    private boolean lombokAllArgsConstructorEnable = true;
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

    /**
     * 项目JDK 版本
     */
    private int jdkVersion = 21;

    /**
     * 当开启这个配置后，Entity 会生成两个类，比如 Account 表会生成 Account.java 以及 AccountBase.java
     * 这样的好处是，自动生成的 getter setter 字段等都在 Base 类里，而开发者可以在 Account.java 中添加自己的业务代码
     * 此时，当有数据库表结构发生变化，需要再次生成代码时，不会覆盖掉 Account.java 中的业务代码（只会覆盖 AccountBase 中的 Getter Setter）
     */
    private boolean withBaseClassEnable = false;

    /**
     * Base 类的后缀
     */
    private String withBaseClassSuffix = "Base";

    /**
     * Base 类所在的包，默认情况下是在 entity 包下，添加一个 base 文件夹。
     */
    private String withBasePackage;

    /**
     * 是否支持把 comment 添加到 @column 注解里
     */
    private boolean columnCommentEnable = false;

    /**
     * 是否总是生成 @Column 注解。
     */
    private boolean alwaysGenColumnAnnotation = false;

    /**
     * 继承的父类是否添加泛型
     */
    private boolean superClassGenericity = false;

    public void build(GlobalConfig globalConfig) {
        EntityConfig entityConfig = globalConfig.getEntityConfig();
        if (StringUtils.isNotBlank(sourceDir))
            entityConfig.setSourceDir(sourceDir);

        if (StringUtils.isNotBlank(classPrefix))
            entityConfig.setClassPrefix(classPrefix);

        if (StringUtils.isNotBlank(classSuffix))
            entityConfig.setClassSuffix(classSuffix);

        if (StringUtils.isNotBlank(superClass)) {
            Class<?> aClass = null;
            try {
                aClass = Class.forName(superClass);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("superClass not found: " + superClass + "!");
            }
            entityConfig.setSuperClass(aClass);
        }

        entityConfig.setOverwriteEnable(overwriteEnable);

        if (StringUtils.isNotBlank(implInterfaces)) {
            String[] array = this.implInterfaces.split(",");
            Class<?>[] classes = new Class[array.length];
            for (int i = 0; i < array.length; i++) {
                String implInterface = array[i];
                Class<?> aClass = null;
                try {
                    aClass = Class.forName(implInterface);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("implInterface not found: " + implInterface + "!");
                }
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

        if (jdkVersion > 0)
            entityConfig.setJdkVersion(jdkVersion);

        entityConfig.setWithBaseClassEnable(withBaseClassEnable);

        if (StringUtils.isNotBlank(withBaseClassSuffix))
            entityConfig.setWithBaseClassSuffix(withBaseClassSuffix);

        if (StringUtils.isNotBlank(withBasePackage))
            entityConfig.setWithBasePackage(withBasePackage);

        entityConfig.setColumnCommentEnable(columnCommentEnable);
        entityConfig.setAlwaysGenColumnAnnotation(alwaysGenColumnAnnotation);
    }
}
