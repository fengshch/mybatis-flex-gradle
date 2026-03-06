package com.github.fengshch.mybatis.config;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalConfigBuilderTest {
    private Project project;
    private GlobalConfigBuilder builder;

    @BeforeEach
    void setUp() {
        project = ProjectBuilder.builder().build();
        builder = new GlobalConfigBuilder("test");
    }

    @Test
    void testDefaultValues() {
        assertTrue(builder.isEntityGenerateEnable());
        assertTrue(builder.isMapperGenerateEnable());
        assertTrue(builder.isServiceGenerateEnable());
        assertTrue(builder.isServiceImplGenerateEnable());
        assertTrue(builder.isControllerGenerateEnable());
        assertTrue(builder.isTableDefGenerateEnable());
        assertTrue(builder.isMapperXmlGenerateEnable());
        assertTrue(builder.isPackageInfoGenerateEnable());
    }

    @Test
    void testSetEntityGenerateEnable() {
        builder.setEntityGenerateEnable(false);
        assertFalse(builder.isEntityGenerateEnable());
    }

    @Test
    void testSetMapperGenerateEnable() {
        builder.setMapperGenerateEnable(false);
        assertFalse(builder.isMapperGenerateEnable());
    }

    @Test
    void testSetServiceGenerateEnable() {
        builder.setServiceGenerateEnable(false);
        assertFalse(builder.isServiceGenerateEnable());
    }

    @Test
    void testSetServiceImplGenerateEnable() {
        builder.setServiceImplGenerateEnable(false);
        assertFalse(builder.isServiceImplGenerateEnable());
    }

    @Test
    void testSetControllerGenerateEnable() {
        builder.setControllerGenerateEnable(false);
        assertFalse(builder.isControllerGenerateEnable());
    }

    @Test
    void testSetTableDefGenerateEnable() {
        builder.setTableDefGenerateEnable(false);
        assertFalse(builder.isTableDefGenerateEnable());
    }

    @Test
    void testSetMapperXmlGenerateEnable() {
        builder.setMapperXmlGenerateEnable(false);
        assertFalse(builder.isMapperXmlGenerateEnable());
    }

    @Test
    void testSetPackageInfoGenerateEnable() {
        builder.setPackageInfoGenerateEnable(false);
        assertFalse(builder.isPackageInfoGenerateEnable());
    }

    @Test
    void testGetName() {
        assertEquals("test", builder.getName());
    }

    @Test
    void testGetDataSourceConfigBuilder() {
        assertNotNull(builder.getDataSourceConfigBuilder());
    }

    @Test
    void testGetJavadocConfigBuilder() {
        assertNotNull(builder.getJavadocConfigBuilder());
    }

    @Test
    void testGetPackageConfigBuilder() {
        assertNotNull(builder.getPackageConfigBuilder());
    }

    @Test
    void testGetStrategyConfigBuilder() {
        assertNotNull(builder.getStrategyConfigBuilder());
    }

    @Test
    void testGetTemplateConfigBuilder() {
        assertNotNull(builder.getTemplateConfigBuilder());
    }

    @Test
    void testGetEntityConfigBuilder() {
        assertNotNull(builder.getEntityConfigBuilder());
    }

    @Test
    void testGetMapperConfigBuilder() {
        assertNotNull(builder.getMapperConfigBuilder());
    }

    @Test
    void testGetServiceConfigBuilder() {
        assertNotNull(builder.getServiceConfigBuilder());
    }

    @Test
    void testGetServiceImplConfigBuilder() {
        assertNotNull(builder.getServiceImplConfigBuilder());
    }

    @Test
    void testGetControllerConfigBuilder() {
        assertNotNull(builder.getControllerConfigBuilder());
    }

    @Test
    void testGetTableConfigBuilder() {
        assertNotNull(builder.getTableConfigBuilder());
    }

    @Test
    void testGetTableDefConfigBuilder() {
        assertNotNull(builder.getTableDefConfigBuilder());
    }

    @Test
    void testGetMapperXmlConfigBuilder() {
        assertNotNull(builder.getMapperXmlConfigBuilder());
    }

    @Test
    void testGetFlywayExtension() {
        assertNotNull(builder.getFlywayExtension());
    }

    @Test
    void testFlywayExtensionInheritsDataSourceConfig() {
        builder.getDataSourceConfigBuilder().setUrl("jdbc:h2:mem:test");
        builder.getDataSourceConfigBuilder().setUsername("sa");
        builder.getDataSourceConfigBuilder().setPassword("password");
        builder.getDataSourceConfigBuilder().setDriverClassName("org.h2.Driver");

        var flyway = builder.getFlywayExtension();
        assertEquals("jdbc:h2:mem:test", flyway.url);
        assertEquals("sa", flyway.user);
        assertEquals("password", flyway.password);
        assertEquals("org.h2.Driver", flyway.driver);
    }
}
