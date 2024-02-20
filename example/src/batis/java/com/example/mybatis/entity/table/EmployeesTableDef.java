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
public class EmployeesTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final EmployeesTableDef EMPLOYEES = new EmployeesTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn EMAIL = new QueryColumn(this, "email");

    
    public final QueryColumn LAST_NAME = new QueryColumn(this, "last_name");

    
    public final QueryColumn FIRST_NAME = new QueryColumn(this, "first_name");

    
    public final QueryColumn HIRED_DATE = new QueryColumn(this, "hired_date");

    
    public final QueryColumn DATE_OF_BIRTH = new QueryColumn(this, "date_of_birth");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, FIRST_NAME, LAST_NAME, EMAIL, DATE_OF_BIRTH, HIRED_DATE};

    public EmployeesTableDef() {
        super("", "employees");
    }

}
