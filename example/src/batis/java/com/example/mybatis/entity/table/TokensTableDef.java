package com.example.mybatis.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author bill
 * @since 2023-08-25
 */
public class TokensTableDef extends TableDef {

    /**
     * 
     */
    public static final TokensTableDef TOKENS = new TokensTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn TOKEN = new QueryColumn(this, "token");

    
    public final QueryColumn IDENTIFIER = new QueryColumn(this, "identifier");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, IDENTIFIER, TOKEN};

    public TokensTableDef() {
        super("", "tokens");
    }

}