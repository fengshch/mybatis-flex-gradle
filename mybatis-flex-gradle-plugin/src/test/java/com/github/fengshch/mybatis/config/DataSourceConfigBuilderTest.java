package com.github.fengshch.mybatis.config;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataSourceConfigBuilderTest {
    private Project project;
    private DataSourceConfigBuilder builder;

    @BeforeEach
    void setUp() {
        project = ProjectBuilder.builder().build();
        builder = new DataSourceConfigBuilder();
    }

    @Test
    void testDefaultValues() {
        assertNull(builder.getUrl());
        assertNull(builder.getUsername());
        assertNull(builder.getPassword());
        assertNull(builder.getDriverClassName());
    }

    @Test
    void testSetUrl() {
        String url = "jdbc:h2:mem:testdb";
        builder.setUrl(url);
        assertEquals(url, builder.getUrl());
    }

    @Test
    void testSetUsername() {
        String username = "testuser";
        builder.setUsername(username);
        assertEquals(username, builder.getUsername());
    }

    @Test
    void testSetPassword() {
        String password = "testpass";
        builder.setPassword(password);
        assertEquals(password, builder.getPassword());
    }

    @Test
    void testSetDriverClassName() {
        String driver = "org.h2.Driver";
        builder.setDriverClassName(driver);
        assertEquals(driver, builder.getDriverClassName());
    }

    @Test
    void testCompleteConfiguration() {
        builder.setUrl("jdbc:mysql://localhost:3306/testdb");
        builder.setUsername("root");
        builder.setPassword("password");
        builder.setDriverClassName("com.mysql.cj.jdbc.Driver");

        assertEquals("jdbc:mysql://localhost:3306/testdb", builder.getUrl());
        assertEquals("root", builder.getUsername());
        assertEquals("password", builder.getPassword());
        assertEquals("com.mysql.cj.jdbc.Driver", builder.getDriverClassName());
    }
}
