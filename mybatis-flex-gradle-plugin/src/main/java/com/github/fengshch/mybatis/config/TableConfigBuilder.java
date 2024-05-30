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
//    private Class<? extends InsertListener> insertListenerClass;
    private String insertListenerClassName;
    /**
     * 监听 entity 的 update 行为。
     */
//    private Class<? extends UpdateListener> updateListenerClass;
    private String updateListenerClassName;

    /**
     * 监听 entity 的查询数据的 set 行为。
     */
//    private Class<? extends SetListener> setListenerClass;
    private String setListenerClassName;
    /**
     * 是否开启 Mapper 生成。
     */
    private Boolean mapperGenerateEnable = Boolean.TRUE;

    /**
     * 对应列的配置。
     */
    private Map<String, ColumnConfig> columnConfigMap;

    public void build(GlobalConfig globalConfig) throws ClassNotFoundException {
        TableConfig tableConfig = globalConfig.getTableConfigMap().get(tableName);

        if (schema != null) {
            tableConfig.setSchema(schema);
        }

        Class<? extends InsertListener> insertListenerClass = Class.forName(insertListenerClassName).asSubclass(InsertListener.class);
        Class<? extends UpdateListener> updateListenerClass = Class.forName(updateListenerClassName).asSubclass(UpdateListener.class);
        Class<? extends SetListener> setListenerClass = Class.forName(setListenerClassName).asSubclass(SetListener.class);

        tableConfig.setInsertListenerClass(insertListenerClass);
        tableConfig.setUpdateListenerClass(updateListenerClass);
        tableConfig.setSetListenerClass(setListenerClass);
        tableConfig.setMapperGenerateEnable(mapperGenerateEnable);
        tableConfig.setColumnConfigMap(columnConfigMap);

    }

}
