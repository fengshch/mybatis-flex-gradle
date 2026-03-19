package com.example.mybatis.mapper;

import com.example.mybatis.TestConfiguration;
import com.example.persistents.mapper.ProductsMapper;
import com.example.persistents.po.ProductsPO;
import com.example.persistents.po.table.ProductsTableDef;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test class for {@link ProductsMapper}.
 *
 * This test verifies the functionality of the ProductsMapper by executing
 * database queries against the Products table.
 */
@SpringBootTest(classes = TestConfiguration.class, properties = {
    "spring.datasource.url=jdbc:h2:file:./data/demo",
    "spring.datasource.username=sa",
    "spring.datasource.password=password",
    "spring.datasource.driverClassName=org.h2.Driver",
    "mybatis.mapper-locations=classpath:com/example/persistents/mapper/xml/**/*.xml",
    "mybatis.type-aliases-package=com.example.persistents.po",
    "mybatis.configuration.map-underscore-to-camel-case=true",
    "mybatis.configuration.log-impl=org.apache.ibatis.logging.slf4j.Slf4jImpl"
})
@Slf4j
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
        List<ProductsPO> products = productsMapper.selectListByQuery(queryWrapper);
        log.info("products: {}", products);
        assert products != null;
        assertFalse(products.isEmpty());
    }
}