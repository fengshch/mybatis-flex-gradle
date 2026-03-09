package io.github.fengshch.mybatis.config;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityConfigBuilderTest {
    private Project project;
    private EntityConfigBuilder builder;

    @BeforeEach
    void setUp() {
        project = ProjectBuilder.builder().build();
        builder = new EntityConfigBuilder();
    }

    @Test
    void testDefaultValues() {
        assertEquals("", builder.getClassPrefix());
        assertEquals("PO", builder.getClassSuffix());
        assertNull(builder.getSuperClass());
        assertTrue(builder.isOverwriteEnable());
        assertTrue(builder.isWithLombok());
        assertFalse(builder.isWithSwagger());
        assertFalse(builder.isWithActiveRecord());
    }

    @Test
    void testSetClassPrefix() {
        String prefix = "Base";
        builder.setClassPrefix(prefix);
        assertEquals(prefix, builder.getClassPrefix());
    }

    @Test
    void testSetClassSuffix() {
        String suffix = "Entity";
        builder.setClassSuffix(suffix);
        assertEquals(suffix, builder.getClassSuffix());
    }

    @Test
    void testSetSuperClass() {
        String superClass = "com.example.BaseEntity";
        builder.setSuperClass(superClass);
        assertEquals(superClass, builder.getSuperClass());
    }

    @Test
    void testSetWithLombok() {
        builder.setWithLombok(false);
        assertFalse(builder.isWithLombok());
    }

    @Test
    void testSetWithSwagger() {
        builder.setWithSwagger(true);
        assertTrue(builder.isWithSwagger());
    }

    @Test
    void testSetWithActiveRecord() {
        builder.setWithActiveRecord(true);
        assertTrue(builder.isWithActiveRecord());
    }

    @Test
    void testSetOverwriteEnable() {
        builder.setOverwriteEnable(false);
        assertFalse(builder.isOverwriteEnable());
    }
}
