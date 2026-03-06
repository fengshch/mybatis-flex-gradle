package io.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.TableDefConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Builder class for configuring TableDef code generation settings.
 *
 * This class configures the generation of TableDef (table definition) auxiliary classes that
 * provide type-safe SQL builder support for dynamic query construction.
 *
 * @see GlobalConfigBuilder
 * @see TableDefConfig
 */
@Data
public class TableDefConfigBuilder {

    /**
     * Constructs a new {@code TableDefConfigBuilder} with default settings.
     */
    public TableDefConfigBuilder() {
    }

    /**
     * 代码生成目录，当未配置时，使用 PackageConfig 的配置
     */
    private String sourceDir;
    /**
     * TableDef 类的前缀。
     */
    private String classPrefix = "";

    /**
     * TableDef 类的后缀。
     */
    private String classSuffix = "TableDef";

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = true;

    /**
     * 生成辅助类的字段风格。
     */
    private String propertiesNameStyle;

    /**
     * 生成辅助类的引用常量名后缀。
     */
    private String instanceSuffix = "";

    /**
     * Builds and applies the table definition configuration to the global config.
     *
     * @param globalConfig the {@link GlobalConfig} to update with table definition settings
     */
    public void build(GlobalConfig globalConfig){
        TableDefConfig tableDefConfig = globalConfig.getTableDefConfig();

        if(StringUtils.isNotBlank(sourceDir)){
            tableDefConfig.setSourceDir(sourceDir);
        }

        if(StringUtils.isNotBlank(classPrefix)){
            tableDefConfig.setClassPrefix(classPrefix);
        }
        if(StringUtils.isNotBlank(classSuffix)){
            tableDefConfig.setClassSuffix(classSuffix);
        }
        tableDefConfig.setOverwriteEnable(overwriteEnable);
        if(StringUtils.isNotBlank(propertiesNameStyle)){
            tableDefConfig.setPropertiesNameStyle(TableDefConfig.NameStyle.valueOf(propertiesNameStyle));
        }
        if(StringUtils.isNotBlank(instanceSuffix)){
            tableDefConfig.setInstanceSuffix(instanceSuffix);
        }
    }
}
