package com.github.fengshch.mybatis.config;

import com.mybatisflex.annotation.InsertListener;
import com.mybatisflex.annotation.SetListener;
import com.mybatisflex.annotation.UpdateListener;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.TableConfig;

import java.util.Map;

public class TableConfigBuilder {

    public static final String ALL_TABLES = "*";

    /**
     * 数据库的 schema（模式）。
     */
    private String schema;

    /**
     * 表名。
     */
    private String tableName = ALL_TABLES;

    /**
     * 默认为 驼峰属性 转换为 下划线字段。
     */
    private Boolean camelToUnderline;

    /**
     * 监听 entity 的 insert 行为。
     */
    private Class<? extends InsertListener> insertListenerClass;

    /**
     * 监听 entity 的 update 行为。
     */
    private Class<? extends UpdateListener> updateListenerClass;

    /**
     * 监听 entity 的查询数据的 set 行为。
     */
    private Class<? extends SetListener> setListenerClass;

    /**
     * 是否开启 Mapper 生成。
     */
    private Boolean mapperGenerateEnable = Boolean.TRUE;

    /**
     * 对应列的配置。
     */
    private Map<String, ColumnConfig> columnConfigMap;

    public void build(GlobalConfig globalConfig, String name){
        this.tableName = name;
        TableConfig tableConfig = globalConfig.getTableConfigMap().get(tableName);
    }

}
