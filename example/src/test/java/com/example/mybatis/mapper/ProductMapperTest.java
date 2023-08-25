package com.example.mybatis.mapper;

import com.example.mybatis.entity.Product;
import com.example.mybatis.entity.table.ProductTableDef;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
//@ActiveProfiles("test")
class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    @Test
    void testQuery() {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(ProductTableDef.PRODUCT.ALL_COLUMNS)
                .from(ProductTableDef.PRODUCT);
        List<Product> products = productMapper.selectListByQuery(queryWrapper);
        log.info("products: {}", products);
        assertTrue(products.size() > 0);
    }
}