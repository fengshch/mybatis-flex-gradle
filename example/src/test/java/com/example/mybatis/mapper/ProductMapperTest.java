package com.example.mybatis.mapper;

import com.example.mybatis.po.ProductsPo;
import com.example.mybatis.po.table.ProductsTableDef;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
class ProductMapperTest {

    @Autowired
    ProductsMapper productsMapper;

    @Autowired
    DataSource dataSource;

    @Test
    void testQuery() {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(ProductsTableDef.PRODUCTS_PO.ALL_COLUMNS)
                .from(ProductsTableDef.PRODUCTS_PO);
        List<ProductsPo> products = productsMapper.selectListByQuery(queryWrapper);
        log.info("products: {}", products);
        assertFalse(products.isEmpty());
    }
}