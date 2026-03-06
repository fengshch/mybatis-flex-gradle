package io.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.JavadocConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.function.UnaryOperator;

/**
 * Builder class for configuring JavaDoc/code comment generation settings.
 *
 * This class configures how JavaDoc comments are generated for entity, mapper, service,
 * controller, and table definition classes. It supports customization of author information,
 * comment formatting, and package-level documentation.
 *
 * @see GlobalConfigBuilder
 * @see JavadocConfig
 */
@Data
public class JavadocConfigBuilder {
    /**
     * Constructs a new {@code JavadocConfigBuilder} with default settings.
     */
    public JavadocConfigBuilder() {
    }

    /**
     * 作者。
     */
    private String author = System.getProperty("user.name");

    /**
     * 自。
     */
    private String since;

    /**
     * 表名格式化。
     */
    private UnaryOperator<String> tableCommentFormat = UnaryOperator.identity();

    /**
     * 列名格式化。
     */
    private UnaryOperator<String> columnCommentFormat = UnaryOperator.identity();

    /**
     * Entity 包注释。
     */
    private String entityPackage = "实体类层（Entity）软件包。";

    /**
     * Mapper 包注释。
     */
    private String mapperPackage = "映射层（Mapper）软件包。";

    /**
     * Service 包注释。
     */
    private String servicePackage = "服务层（Service）软件包。";

    /**
     * ServiceImpl 包注释。
     */
    private String serviceImplPackage = "服务层实现（ServiceImpl）软件包。";

    /**
     * Controller 包注释。
     */
    private String controllerPackage = "控制层（Controller）软件包。";

    /**
     * TableDef 包注释。
     */
    private String tableDefPackage = "表定义层（TableDef）软件包。";


    /**
     * Builds and applies the javadoc configuration to the global config.
     *
     * @param globalConfig the {@link GlobalConfig} to update with javadoc settings
     */
    public void build(GlobalConfig globalConfig){
        JavadocConfig javadocConfig = globalConfig.getJavadocConfig();
        if (StringUtils.isNotBlank(author))
            javadocConfig.setAuthor(author);
        if (StringUtils.isNotBlank(since))
            javadocConfig.setSince(since);
        if(tableCommentFormat != null)
            javadocConfig.setTableCommentFormat(tableCommentFormat);

        if(columnCommentFormat != null)
            javadocConfig.setColumnCommentFormat(columnCommentFormat);

        if (StringUtils.isNotBlank(entityPackage))
            javadocConfig.setEntityPackage(entityPackage);
        if (StringUtils.isNotBlank(mapperPackage))
            javadocConfig.setMapperPackage(mapperPackage);
        if (StringUtils.isNotBlank(servicePackage))
            javadocConfig.setServicePackage(servicePackage);
        if (StringUtils.isNotBlank(serviceImplPackage))
            javadocConfig.setServiceImplPackage(serviceImplPackage);
        if (StringUtils.isNotBlank(controllerPackage))
            javadocConfig.setControllerPackage(controllerPackage);
        if (StringUtils.isNotBlank(tableDefPackage))
            javadocConfig.setTableDefPackage(tableDefPackage);

    }
}
