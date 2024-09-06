package com.example.mybatis.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 *  表定义层。
 *
 * @author bill
 * @since 2024-09-06
 */
public class ProductsTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductsTableDef PRODUCTS_PO = new ProductsTableDef();

    
    public final QueryColumn PRICE = new QueryColumn(this, "PRICE");

    
    public final QueryColumn STOCK = new QueryColumn(this, "STOCK");

    
    public final QueryColumn CREATED_AT = new QueryColumn(this, "CREATED_AT");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "PRODUCT_ID");

    
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "DESCRIPTION");

    
    public final QueryColumn PRODUCT_NAME = new QueryColumn(this, "PRODUCT_NAME");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{PRODUCT_ID, PRODUCT_NAME, DESCRIPTION, PRICE, STOCK, CREATED_AT};

    public ProductsTableDef() {
        super("", "PRODUCTS");
    }

    private ProductsTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductsTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductsTableDef("", "PRODUCTS", alias));
    }

}
