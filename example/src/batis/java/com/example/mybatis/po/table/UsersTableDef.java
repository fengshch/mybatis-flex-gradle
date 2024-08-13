package com.example.mybatis.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 *  表定义层。
 *
 * @author bill
 * @since 2024-08-13
 */
public class UsersTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final UsersTableDef USERS_PO = new UsersTableDef();

    
    public final QueryColumn EMAIL = new QueryColumn(this, "EMAIL");

    
    public final QueryColumn USER_ID = new QueryColumn(this, "USER_ID");

    
    public final QueryColumn USERNAME = new QueryColumn(this, "USERNAME");

    
    public final QueryColumn CREATED_AT = new QueryColumn(this, "CREATED_AT");

    
    public final QueryColumn PASSWORD_HASH = new QueryColumn(this, "PASSWORD_HASH");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{USER_ID, USERNAME, EMAIL, PASSWORD_HASH, CREATED_AT};

    public UsersTableDef() {
        super("", "USERS");
    }

    private UsersTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public UsersTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new UsersTableDef("", "USERS", alias));
    }

}
