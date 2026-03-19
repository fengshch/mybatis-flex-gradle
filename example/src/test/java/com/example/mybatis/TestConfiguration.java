package com.example.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * Minimal test configuration for Spring Boot tests.
 * 
 * This configuration is used for tests to avoid loading unnecessary beans
 * and focusing only on the MyBatis mappers and datasource configuration.
 * It also initializes the database using migration scripts.
 */
@SpringBootApplication(scanBasePackages = {
    "com.example.persistents.mapper",
    "com.example.persistents.repo"
})
@MapperScan("com.example.persistents.mapper")
public class TestConfiguration {
    
    /**
     * Initializes the database with migration scripts.
     * 
     * @param dataSource the Spring DataSource bean
     * @return the configured DataSourceInitializer
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db/migration/V1.01__Schema.sql"));
        populator.addScript(new ClassPathResource("db/migration/V1.02__Data.sql"));
        initializer.setDatabasePopulator(populator);
        
        return initializer;
    }
    
    /**
     * Creates a SqlSessionFactory bean for MyBatis.
     * 
     * @param dataSource the Spring DataSource bean
     * @return configured SqlSessionFactory
     * @throws Exception if there's an error creating the factory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(
            new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/example/persistents/mapper/xml/**/*.xml")
        );
        return sessionFactoryBean.getObject();
    }
}


