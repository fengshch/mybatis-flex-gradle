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
public class OrdersTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final OrdersTableDef ORDERS_PO = new OrdersTableDef();

    
    public final QueryColumn USER_ID = new QueryColumn(this, "USER_ID");

    
    public final QueryColumn ORDER_ID = new QueryColumn(this, "ORDER_ID");

    
    public final QueryColumn ORDER_DATE = new QueryColumn(this, "ORDER_DATE");

    
    public final QueryColumn TOTAL_AMOUNT = new QueryColumn(this, "TOTAL_AMOUNT");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ORDER_ID, USER_ID, ORDER_DATE, TOTAL_AMOUNT};

    public OrdersTableDef() {
        super("", "ORDERS");
    }

    private OrdersTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public OrdersTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new OrdersTableDef("", "ORDERS", alias));
    }

}
