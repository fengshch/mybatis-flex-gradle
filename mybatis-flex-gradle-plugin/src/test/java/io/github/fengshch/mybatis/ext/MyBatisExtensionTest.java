package io.github.fengshch.mybatis.ext;

import io.github.fengshch.mybatis.config.GlobalConfigBuilder;
import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBatisExtensionTest {
    private Project project;
    private MyBatisExtension extension;

    @BeforeEach
    void setUp() {
        project = ProjectBuilder.builder().build();
        extension = project.getObjects().newInstance(MyBatisExtension.class);
    }

    @Test
    void testConfigurationsNotNull() {
        assertNotNull(extension.getConfigurations());
    }

    @Test
    void testCanCreateConfiguration() {
        GlobalConfigBuilder config = extension.getConfigurations().create("main");
        assertNotNull(config);
        assertEquals("main", config.getName());
    }

    @Test
    void testCanCreateMultipleConfigurations() {
        GlobalConfigBuilder main = extension.getConfigurations().create("main");
        GlobalConfigBuilder secondary = extension.getConfigurations().create("secondary");

        assertNotNull(main);
        assertNotNull(secondary);
        assertEquals("main", main.getName());
        assertEquals("secondary", secondary.getName());
        assertEquals(2, extension.getConfigurations().size());
    }

    @Test
    void testCanFindConfigurationByName() {
        extension.getConfigurations().create("main");
        GlobalConfigBuilder found = extension.getConfigurations().findByName("main");
        assertNotNull(found);
        assertEquals("main", found.getName());
    }

    @Test
    void testFindNonExistentConfigurationReturnsNull() {
        GlobalConfigBuilder found = extension.getConfigurations().findByName("nonexistent");
        assertNull(found);
    }
}
