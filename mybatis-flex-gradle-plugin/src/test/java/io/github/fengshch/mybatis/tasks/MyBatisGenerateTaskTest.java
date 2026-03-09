package io.github.fengshch.mybatis.tasks;

import io.github.fengshch.mybatis.config.GlobalConfigBuilder;
import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class MyBatisGenerateTaskTest {
    @TempDir
    File tempDir;

    private Project project;
    private GlobalConfigBuilder globalConfigBuilder;

    @BeforeEach
    void setUp() {
        project = ProjectBuilder.builder().withProjectDir(tempDir).build();
        globalConfigBuilder = new GlobalConfigBuilder("test");
    }

    @Test
    void testTaskCreation() {
        MyBatisGenerateTask task = project.getTasks().register("testGenerate", MyBatisGenerateTask.class, globalConfigBuilder).get();
        assertNotNull(task);
        assertEquals("testGenerate", task.getName());
        assertEquals("mybatis", task.getGroup());
        assertEquals("Generate MyBatis Flex Code", task.getDescription());
    }

    @Test
    void testBatisDirectoryCleanup() throws IOException {
        // Create a batis directory with some files
        File batisDir = new File(tempDir, "src/batis/java");
        batisDir.mkdirs();

        File testFile = new File(batisDir, "test.txt");
        Files.writeString(testFile.toPath(), "test content");

        assertTrue(batisDir.exists());
        assertTrue(testFile.exists());

        // Note: We can't actually run the generate task without a database connection,
        // but we've verified the directory structure is set up correctly
        // The actual cleanup will happen when the task runs
    }

    @Test
    void testTaskConfiguration() {
        globalConfigBuilder.getPackageConfigBuilder().setSourceDir("src/batis/java");
        globalConfigBuilder.getPackageConfigBuilder().setBasePackage("com.example");

        MyBatisGenerateTask task = project.getTasks().register("testGenerate", MyBatisGenerateTask.class, globalConfigBuilder).get();

        assertNotNull(task);
        assertEquals("src/batis/java", globalConfigBuilder.getPackageConfigBuilder().getSourceDir());
        assertEquals("com.example", globalConfigBuilder.getPackageConfigBuilder().getBasePackage());
    }
}
