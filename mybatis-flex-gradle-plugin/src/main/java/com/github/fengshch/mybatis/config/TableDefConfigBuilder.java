package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.TableDefConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class TableDefConfigBuilder {
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

    public void build(GlobalConfig globalConfig){
        TableDefConfig tableDefConfig = globalConfig.getTableDefConfig();
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
