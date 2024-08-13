package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.StrategyConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

@Data
public class StrategyConfigBuilder {
    /**
     * 数据库表前缀，多个前缀用英文逗号（,） 隔开。
     */
    private String tablePrefix;

    /**
     * 逻辑删除的默认字段名称。
     */
    private String logicDeleteColumn = "deleted";

    /**
     * 乐观锁的字段名称。
     */
    private String versionColumn = "version";

    /**
     * 是否生成视图映射。
     */
    private boolean generateForView;

    /**
     * 单独为某张表添加独立的配置。
     */
//    private Map<String, TableConfig> tableConfigMap;

    /**
     * 设置某个列的全局配置。
     */
//    private Map<String, ColumnConfig> columnConfigMap;

    /**
     * 需要生成的表在哪个模式下
     */
    private String generateSchema;
    /**
     * 生成哪些表，白名单。
     */
    private String[] generateTables;

    /**
     * 不生成哪些表，黑名单。
     */
    private String[] unGenerateTables;

    /**
     * 需要忽略的列 全局配置。
     */
    private String[] ignoreColumns;



    public void build(GlobalConfig globalConfig) {
        StrategyConfig strategyConfig = globalConfig.getStrategyConfig();
        if (StringUtils.isNotBlank(tablePrefix)) {
            strategyConfig.setTablePrefix(tablePrefix.split(","));
        }
        if (StringUtils.isNotBlank(logicDeleteColumn)) {
            strategyConfig.setLogicDeleteColumn(logicDeleteColumn);
        }
        if (StringUtils.isNotBlank(versionColumn)) {
            strategyConfig.setVersionColumn(versionColumn);
        }
        strategyConfig.setGenerateForView(generateForView);
        if(StringUtils.isNotBlank(generateSchema)){
            strategyConfig.setGenerateSchema(generateSchema);
        }
        if (generateTables != null) {
            strategyConfig.setGenerateTables(Set.of(generateTables));
        }
        if (unGenerateTables != null) {
            strategyConfig.setUnGenerateTables(Set.of(unGenerateTables));
        }
        if (ignoreColumns != null) {
            strategyConfig.setIgnoreColumns(ignoreColumns);
        }
    }
}
