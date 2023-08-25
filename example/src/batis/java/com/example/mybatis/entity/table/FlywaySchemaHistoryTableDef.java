package com.example.mybatis.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author bill
 * @since 2023-08-25
 */
public class FlywaySchemaHistoryTableDef extends TableDef {

    /**
     * 
     */
    public static final FlywaySchemaHistoryTableDef FLYWAY_SCHEMA_HISTORY = new FlywaySchemaHistoryTableDef();

    
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    
    public final QueryColumn SCRIPT = new QueryColumn(this, "script");

    
    public final QueryColumn SUCCESS = new QueryColumn(this, "success");

    
    public final QueryColumn VERSION = new QueryColumn(this, "version");

    
    public final QueryColumn CHECKSUM = new QueryColumn(this, "checksum");

    
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    
    public final QueryColumn INSTALLED_BY = new QueryColumn(this, "installed_by");

    
    public final QueryColumn INSTALLED_ON = new QueryColumn(this, "installed_on");

    
    public final QueryColumn EXECUTION_TIME = new QueryColumn(this, "execution_time");

    
    public final QueryColumn INSTALLED_RANK = new QueryColumn(this, "installed_rank");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{INSTALLED_RANK, VERSION, DESCRIPTION, TYPE, SCRIPT, CHECKSUM, INSTALLED_BY, INSTALLED_ON, EXECUTION_TIME, SUCCESS};

    public FlywaySchemaHistoryTableDef() {
        super("", "flyway_schema_history");
    }

}
