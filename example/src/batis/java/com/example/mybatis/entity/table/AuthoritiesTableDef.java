package com.example.mybatis.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 *  表定义层。
 *
 * @author bill
 * @since 2024-02-20
 */
public class AuthoritiesTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final AuthoritiesTableDef AUTHORITIES = new AuthoritiesTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    
    public final QueryColumn AUTHORITY = new QueryColumn(this, "authority");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, USERNAME, AUTHORITY};

    public AuthoritiesTableDef() {
        super("", "authorities");
    }

}
