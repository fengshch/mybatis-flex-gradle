package io.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.StrategyConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

/**
 * Builder class for configuring code generation strategy settings.
 *
 * This class configures table selection strategies, naming conventions, special columns
 * (logical delete, version fields), and generation filters for the code generator.
 *
 * @see GlobalConfigBuilder
 * @see StrategyConfig
 */
public class StrategyConfigBuilder {
    /**
     * Constructs a new {@code StrategyConfigBuilder} with default settings.
     */
    public StrategyConfigBuilder() {
    }

    /**
     * 数据库表前缀，多个前缀用英文逗号（,） 隔开。
     */
    private String tablePrefix;

    /**
     * 数据库表后缀，多个后缀用英文逗号（,） 隔开。
     */
    private String  tableSuffix;

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
    // private Map<String, TableConfig> tableConfigMap;

    /**
     * 设置某个列的全局配置。
     */
    // private Map<String, ColumnConfig> columnConfigMap;

    /**
     * 自定义列配置工厂。
     */
    //private ColumnConfigFactory columnConfigFactory;



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

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public String getLogicDeleteColumn() {
        return logicDeleteColumn;
    }

    public void setLogicDeleteColumn(String logicDeleteColumn) {
        this.logicDeleteColumn = logicDeleteColumn;
    }

    public String getVersionColumn() {
        return versionColumn;
    }

    public void setVersionColumn(String versionColumn) {
        this.versionColumn = versionColumn;
    }

    public boolean isGenerateForView() {
        return generateForView;
    }

    public void setGenerateForView(boolean generateForView) {
        this.generateForView = generateForView;
    }

    public String getGenerateSchema() {
        return generateSchema;
    }

    public void setGenerateSchema(String generateSchema) {
        this.generateSchema = generateSchema;
    }

    public String[] getGenerateTables() {
        return generateTables;
    }

    public void setGenerateTables(String[] generateTables) {
        this.generateTables = generateTables;
    }

    public String[] getUnGenerateTables() {
        return unGenerateTables;
    }

    public void setUnGenerateTables(String[] unGenerateTables) {
        this.unGenerateTables = unGenerateTables;
    }

    public String[] getIgnoreColumns() {
        return ignoreColumns;
    }

    public void setIgnoreColumns(String[] ignoreColumns) {
        this.ignoreColumns = ignoreColumns;
    }



    /**
     * Builds and applies the strategy configuration to the global config.
     *
     * @param globalConfig the {@link GlobalConfig} to update with strategy settings
     */
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
