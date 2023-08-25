package com.example.mybatis.repo;

import com.example.mybatis.entity.Product;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
//@ActiveProfiles("test")
class ProductRepoTest {
    @Resource
    ProductRepo productRepo;

    @Test
    void testQuery() {
        List<Product> products = productRepo.list();
        log.info("products: {}", products);

        assertTrue(products.size() > 0);
    }
}